(function($) {

    var methods = {
        init: function(options) {
			
			// default options
			var defaultOptions = {
				enabledFunctions: ["cut", "copy", "paste", "paste-above", "paste-inside", "remove", "save-to-clipboard"],
				nodata: "nodata"
			};	
			
			
			
			// override default options with input options
			var options =  $.extend(defaultOptions, options);

				
				
				
				

					
					
					
					
			/* Event Handlers for Keyboard Shortcuts
			--------------------------------------------------------------*/  
			
			/* keydown */
			$(window).keydown(function(event) {
				console.log('key ' + event.keyCode + ' keydown!');
				if (event.keyCode === 17) { // key Ctrl
					_ctrlKeyDown = true;
					_getSelectedTagMenu().addClass('keyboard-shortcut-state');
				}
				if (event.ctrlKey) {
					switch (event.keyCode) {
						case 88: // key X
							if ( _isEnabled("cut") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.cut').addClass('key-down-state');
							}
							break;
						case 67: // key C
							if ( _isEnabled("copy") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.copy').addClass('key-down-state');
							}
							break;
						case 86: // key V
							if ( _isEnabled("paste") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.paste').addClass('key-down-state');
							}
							break;
						case 66: // key B
							if ( _isEnabled("paste-above") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.paste-above').addClass('key-down-state');
							}
							break;
						case 70: // key F
							if ( _isEnabled("paste-inside") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.paste-inside').addClass('key-down-state');
							}
							break;
						case 82: // key R
							if ( _isEnabled("remove") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.remove').addClass('key-down-state');
							}
							break;
						case 83: // key S
							if ( _isEnabled("save-to-clipboard") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.save-to-clipboard').addClass('key-down-state');
							}
							break;
					}
					event.stopPropagation();
				}

				return;

			});

			
			
			/* keyup */
			$(window).keyup(function(event) {
				console.log('key ' + event.keyCode + ' keyup!');
				if (event.keyCode === 17) { // key Ctrl
					_ctrlKeyDown = false;
					_getSelectedTagMenu().removeClass('keyboard-shortcut-state');
				}
				if (event.ctrlKey) {
					switch (event.keyCode) {
						case 88: // key X
							if ( _isEnabled("cut") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.cut').removeClass('key-down-state');
								cutTag(_getSelectedTag());
							}
							break;
						case 67: // key C
							if ( _isEnabled("copy") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.copy').removeClass('key-down-state');
								copyTag(_getSelectedTag());
							}
							break;
						case 86: // key V
							if ( _isEnabled("paste") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.paste').removeClass('key-down-state');
								pasteTag(_getSelectedTag());
							}
							break;
						case 66: // key B
							if ( _isEnabled("paste-above") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.paste-above').removeClass('key-down-state');
								pasteAboveTag(_getSelectedTag());
							}
							break;
						case 70: // key F
							if ( _isEnabled("paste-inside") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.paste-inside').removeClass('key-down-state');
								pasteInsideTag(_getSelectedTag());
							}
							break;
						case 82: // key R
							if ( _isEnabled("remove") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.remove').removeClass('key-down-state');
								removeTag(_getSelectedTag());
							}
							break;
						case 83: // key S
							if ( _isEnabled("save-to-clipboard") ) {
								event.preventDefault();
								event.stopPropagation();
								_getSelectedTagMenu().find('.brush-menu-item.save-to-clipboard').removeClass('key-down-state');
								saveToClipboard(_getSelectedTag());
							}
							break;


					}
				}
				
				return;

			});
				
				
				
				

				
				
				
				
				
			/* Event Handlers for Brush Menu
			--------------------------------------------------------------*/  
				
			function _bindMenu(input) {
				
				$(input).bind({
				
					mouseenter: function(event) {
						var $this = $(this);
						event.stopPropagation();
						if ( $this.find('div.brush-menu').length === 0 ) {
							$this.prepend(_$brushMenu);
							var top = $this.position().top;
							var right = $this.position().left + $this.outerWidth(true); // get right position
							$this.find('div.brush-menu').css( {"top": top, "left": right} )
							$this.addClass('selected');
							// set keyboard-shortcut-state if ctrl is pressed
							if (_ctrlKeyDown) { 
								$this.find('div.brush-menu').addClass('keyboard-shortcut-state');
							}
						
							if ( _isEnabled("cut") ) { 
								_bindMenuItemCut(this);
							}
							if ( _isEnabled("copy") ) { 
								_bindMenuItemCopy(this);
							}
							if ( _isEnabled("paste") ) { 
								_bindMenuItemPaste(this);
							}
							if ( _isEnabled("paste-above") ) { 
								_bindMenuItemPasteAbove(this);
							}
							if ( _isEnabled("paste-inside") ) { 
								_bindMenuItemPasteInside(this);
							}
							if ( _isEnabled("remove") ) { 
								_bindMenuItemRemove(this);
							}
							if ( _isEnabled("save-to-clipboard") ) { 
								_bindMenuItemSaveToClipboard(this);
							}

						}
						
					},
					
					mouseleave: function(event) {
						var $this = $(this);
						event.stopPropagation();
						$this.find('div.brush-menu').remove();
						$this.removeClass('selected');
					}
					
				});

			}	
				
				
				
			/* Event Handlers for Brush Menu Items
			--------------------------------------------------------------*/
			
			/* cut */
			function _bindMenuItemCut(input) {
				$("span.brush-menu-item.cut", input).bind({
					
					click: function(event) {
						if ( _isEnabled("cut") ) { 
							console.log('clicked brush-menu cut!');
							cutTag(_getSelectedTag());
						}
					}
					
				});
			}
			
			
			
			/* copy */
			function _bindMenuItemCopy(input) {
				$("span.brush-menu-item.copy", input).bind({
				
					click: function(event) {
						if ( _isEnabled("copy") ) {
							console.log('clicked brush-menu copy!');
							copyTag(_getSelectedTag());
						}
					}
					
				});
			}	
			
			
			
			/* paste */
			function _bindMenuItemPaste(input) {
				
				$("span.brush-menu-item.paste", input).bind({
					
					click: function(event) {
						if ( _isEnabled("paste") ) {
							console.log('clicked brush-menu paste!');
							pasteTag(_getSelectedTag());
						}
					}
					
				});
			}			


			
			/* paste-above */
			function _bindMenuItemPasteAbove(input) {
				$("span.brush-menu-item.paste-above", input).bind({
				
					click: function(event) {
						if ( _isEnabled("paste-above") ) {
							console.log('clicked brush-menu paste-above!');
							pasteAboveTag(_getSelectedTag());
						}
					}
					
				});	
			}					



			/* paste-inside */
			function _bindMenuItemPasteInside(input) {
				$("span.brush-menu-item.paste-inside", input).bind({
				
					click: function(event) {
						if ( _isEnabled("paste-inside") ) {
							console.log('clicked brush-menu paste-inside!');
							pasteInsideTag(_getSelectedTag());
						}
					}
					
				});
			}			
			
			
			
			/* remove */	
			function _bindMenuItemRemove(input) {
				$("span.brush-menu-item.remove", input).bind({
				
					click: function(event) {
						if ( _isEnabled("remove") ) {
							console.log('clicked brush-menu remove!');
							removeTag(_getSelectedTag());
						}
					}
					
				});
			}			
			


			/* save-to-clipboard */
			function _bindMenuItemSaveToClipboard(input) {
				$("span.brush-menu-item.save-to-clipboard", input).bind({
				
					click: function(event) {
						if ( _isEnabled("save-to-clipboard") ) {
							console.log('clicked brush-menu save-to-clipboard!');
							saveToClipboard(_getSelectedTag());
						}
					}
					
				});
			}
			
			
			

			
			
			
			
				
				
			/* Public Help Methods
			--------------------------------------------------------------*/  
			
			/* function methods */
			function cutTag(input) {
				var $html = $(input).clone();
				$html.find('div.brush-menu').remove();
				$html.removeClass('selected');
				localStorage.setItem( "clipboard", $html.prop('outerHTML') );
				$(input).remove();
				_log('cut to clipboard: ' + localStorage.getItem( "clipboard" ) );
			}			
			function copyTag(input) {
				var $html = $(input).clone();
				$html.find('div.brush-menu').remove();
				$html.removeClass('selected');
				localStorage.setItem( "clipboard", $html.prop('outerHTML') );
				localStorage.setItem( "options", JSON.stringify(options) );
				_log('copied to clipboard: ' + localStorage.getItem( "clipboard" ) );
			}				
			function pasteTag(input) {
				$(input).after( localStorage.getItem( "clipboard" ) );
				$(input).next().painterBrush( JSON.parse(localStorage.getItem( "options" )) );
				_log('pasted clipboard: ' + localStorage.getItem( "clipboard" ) );
			}					
			function pasteAboveTag(input) {
				$(input).before( localStorage.getItem( "clipboard" ) );
				$(input).prev().painterBrush( JSON.parse(localStorage.getItem( "options" )) );
				_log('pasted above clipboard: ' + localStorage.getItem( "clipboard" ) );
			}					
			function pasteInsideTag(input) {
				$(input).append( localStorage.getItem( "clipboard" ) );
				_log('pasted inside clipboard: ' + localStorage.getItem( "clipboard" ) );
			}				
			function removeTag(input) {
				$(input).remove();
				_log('removed tag!');
			}			
			function clearClipboard(input) {
				localStorage.setItem( "clipboard", "" );
				_log('cleared clipboard: ' + localStorage.getItem( "clipboard" ) );
			}			
			function saveToClipboard(input) {

				_log('saved to clipboard: ' + localStorage.getItem( "clipboard" ) );
			}
				
				
				
				
				
				
				
				
				
				
			/* Private Help Variables
			--------------------------------------------------------------*/  
				
			var _ctrlKeyDown = false;
			var _$brushMenu = _createMenu();

				
				
				
				
				
				
				
				
				
			/* Private Help Methods
			--------------------------------------------------------------*/  
				
			function _getSelectedTag() {
				return $('.selected');
			}
	
			function _getSelectedTagMenu() {
				return $('.selected div.brush-menu');
			}
				
			function _isEnabled(function_) {
				if ( $.inArray(function_, options["enabledFunctions"]) === -1 ) { 
					return false;
				} else {
					return true;
				}
			}		

			function _createMenu() {
				
				var brushMenu = 
					'<div class="brush-menu">' +
					'	<span class="brush-menu-item cut"><span class="description">Cut</span><span class="keyboard-shortcut">X</span></span>' +
					'	<span class="brush-menu-item copy"><span class="description">Copy</span><span class="keyboard-shortcut">C</span></span>' +
					'	<span class="brush-menu-item paste"><span class="description">Paste</span><span class="keyboard-shortcut">V</span></span>' +
					'	<span class="brush-menu-item paste-above"><span class="description">Paste Above</span><span class="keyboard-shortcut">B</span></span>' +
					'	<span class="brush-menu-item paste-inside"><span class="description">Paste Inside</span><span class="keyboard-shortcut">F</span></span>' +
					'	<span class="brush-menu-item remove"><span class="description">Remove</span><span class="keyboard-shortcut">R</span></span>' +
					'	<span class="brush-menu-item save-to-clipboard"><span class="description">Save to Clipboard</span><span class="keyboard-shortcut">S</span></span>' +
					'</div>';
				var $brushMenu = $(brushMenu);
				
				// remove menu-items that are not enabled
				if ( !_isEnabled("cut") ) { 
					$brushMenu.find('.brush-menu-item.cut').remove();
				}
				if ( !_isEnabled("copy") ) { 
					$brushMenu.find('.brush-menu-item.copy').remove();
				}
				if ( !_isEnabled("paste") ) { 
					$brushMenu.find('.brush-menu-item.paste').remove();
				}
				if ( !_isEnabled("paste-above") ) { 
					$brushMenu.find('.brush-menu-item.paste-above').remove();
				}
				if ( !_isEnabled("paste-inside") ) { 
					$brushMenu.find('.brush-menu-item.paste-inside').remove();
				}
				if ( !_isEnabled("remove") ) { 
					$brushMenu.find('.brush-menu-item.remove').remove();
				}
				if ( !_isEnabled("save-to-clipboard") ) { 
					$brushMenu.find('.brush-menu-item.save-to-clipboard').remove();
				}

				return $brushMenu;
				
			}		

			function _applyPlugin(input) {
				
				_bindMenu(input);
				
			}		
					
					
					
			// apply plugin
			return this.each(function() {
		
				_applyPlugin(this);
				
				// apply editing plugin to headers, labels, etc
				$("> div.label > label", this).editable(function(value, settings) { 
						return(value);
					}, { 
						tooltip   : 'Click to edit...'
				});
				// apply editing plugin to headers, labels, etc
				$("> h3.group-header", this).editable(function(value, settings) { 
						return(value);
					}, { 
						tooltip   : 'Click to edit...'
				});
				

				$("div.labeled-content", this).painterBrush({
					enabledFunctions: ["cut", "copy", "paste", "paste-above", "remove"]
				});
				
			});
			
			
			
		},
        show: function() {},
        hide: function() {},
        update: function(content) {}
    };

	
	
    $.fn.painterBrush = function(method) {

	

		/* Functions
		----------------------------------*/
		
		this.templateFunction = function(){
			return "templateFunction";
		}
		
		

	
	
	
	
	
	
	
		/* Method calling logic
		----------------------------------*/
		
        if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.notificationField');
        }
		
		
		
		
    };

	
})(jQuery);





$(function() { 

	

	/* Apply Plugin
	----------------------------------*/
	
	// apply brush plugin to data objects
	$("div.labeled-content", this).painterBrush({
		enabledFunctions: ["cut", "copy", "paste", "paste-above", "remove"]
	});
				


});