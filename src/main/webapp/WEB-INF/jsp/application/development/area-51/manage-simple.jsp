<!DOCTYPE html>
<html>

	<head>
         
        <!-- jquery -->
        <script type="text/javascript" src="jquery-ui/js/jquery-1.6.2.min.js"></script>

        <!-- jquery plugin: table -->
        <script type="text/javascript" language="javascript" src="plugins/DataTables-1.8.2/media/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="plugins/DataTables-1.8.2/plugins/jquery-custom-api-functions.js"></script>
		<link type="text/css" href="plugins/DataTables-1.8.2/media/css/demo_table_jui.css" rel="stylesheet" /> <!-- TODO: move css into table-layout.ccs -->

        <!-- jquery plugin: table plugins -->
        <link type="text/css" href="plugins/DataTables-1.8.2/plugins/TableTools-2.0.1/media/css/TableTools_JUI.css" rel="stylesheet" /> <!-- TODO: move css into table-layout.ccs -->
		<script type="text/javascript" charset="utf-8" src="plugins/DataTables-1.8.2/plugins/TableTools-2.0.1/media/js/ZeroClipboard.js"></script>
		<script type="text/javascript" charset="utf-8" src="plugins/DataTables-1.8.2/plugins/TableTools-2.0.1/media/js/TableTools.js"></script>

		<!-- jquery plugin: form validation, see http://bassistance.de/jquery-plugins/jquery-plugin-validation/ -->
		<script type="text/javascript" language="javascript" src="plugins/jquery.validate.min.js"></script>

		<!-- jquery plugin: jeditable, see http://www.appelsiini.net/projects/jeditable -->
		<script type="text/javascript" language="javascript" src="plugins/jeditable/jquery.jeditable.mini.js"></script>

		<!-- jquery plugin: copy to clipboard, see http://www.steamdev.com/zclip/#features -->
		<!--<script type="text/javascript" language="javascript" src="plugins/copytoclipboard/jquery.zclip.min.js"></script>-->
		
		<!-- jquery plugin: painter, own creation -->
		<!-- <script type="text/javascript" language="javascript" src="plugins/painter/jquery.painter-brush.js"></script>
        <link type="text/css" href="plugins/painter/jquery.painter-brush.css" rel="stylesheet" /> -->
			
        <!-- jquery plugin: notification-field, unitedlog creation -->
        <script type="text/javascript" language="javascript" src="plugins/notification-field/jquery.notification-field.js"></script>
        <link type="text/css" href="plugins/notification-field/jquery.notification-field.css" rel="stylesheet" /> <!-- TODO: move css into table-layout.ccs -->
		<!--[if lte IE 6]>
        <link type="text/css" href="plugins/notification-field/jquery.notification-field-IE6-support.css" rel="stylesheet" />
		<![endif]-->		

        <!-- jquery plugin: doTimeout, see http://benalman.com/projects/jquery-dotimeout-plugin/ -->
        <!-- Import this if needed <script type="text/javascript" src="plugins/jquery.dotimeout.min.js"></script> -->

        <!-- jquery plugin: cookie handler -->
		<script type="text/javascript" src="plugins/cookie/jquery.cookie.js"></script>
		
        <!-- jquery plugin: select tag help functions, see http://www.texotela.co.uk/code/jquery/select/ -->
        <script type="text/javascript" language="javascript" src="plugins/jquery.selectboxes.js"></script>
		
        <!-- jquery plugin: checkbox toggler, see http://awardwinningfjords.com/2009/06/16/iphone-style-checkboxes.html and https://github.com/tdreyno/iphone-style-checkboxes -->
		<script src="plugins/checkbox-toggler/iphone-style-checkboxes/jquery/iphone-style-checkboxes.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="plugins/checkbox-toggler/iphone-style-checkboxes/style.css" type="text/css" media="screen" charset="utf-8" />
		
		
		
        <!-- jquery-ui -->
        <link type="text/css" href="jquery-ui/css/custom-theme/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="jquery-ui/js/jquery-ui-1.8.16.custom.min.js"></script>

        <!-- jquery-ui plugin: daterangepicker, see http://www.filamentgroup.com/lab/date_range_picker_using_jquery_ui_16_and_jquery_ui_css_framework/ and http://www.datejs.com/   -->
        <link type="text/css" href="jquery-ui/plugins/daterangepicker/jquery-ui.daterangepicker.css" rel="stylesheet" /> <!-- TODO: move css into data.ccs -->
        <script type="text/javascript" language="javascript" src="jquery-ui/plugins/daterangepicker/jquery-ui.daterangepicker.js"></script>
		
        <!-- jquery-ui plugin: select-autocomplete -->
        <!-- <script type="text/javascript" src="jquery-ui/plugins/select-autocomplete/select-autocomplete.js"></script> -->
		
		
		
        <!-- crossbrowser fixes -->
        <link rel="stylesheet" type="text/css" href="css/css-reset.css" />
        <link rel="stylesheet" type="text/css" href="css/clear-fix.css" />
        <script type="text/javascript" src="js/jquery.first-child-last-child-IE6-IE7-IE8-support.js"></script>

        <!-- help/debug scripts -->
		<script type="text/javascript" src="js/jquery.outerhtml.js"></script>
		<script type="text/javascript" src="plugins/log/jquery.log.js"></script>
		<!-- TODO: add a jquery log api e.g. http://plugins.jquery.com/project/jql -->
		<!-- TODO: find out if serverside logging with ajax would be useful-->

		
		
		<!-- page -->
        <link rel="stylesheet" type="text/css" href="css/page.css" />
        <script type="text/javascript" src="js/jquery.page.js"></script>

		<!-- layout -->
        <link rel="stylesheet" type="text/css" href="css/layout.css" />
        <script type="text/javascript" src="js/jquery.layout.js"></script>
		
		<!-- data -->
        <link rel="stylesheet" type="text/css" href="css/data.css" />
		<script type="text/javascript" src="js/jquery.data.js"></script>

		<!-- table-layout -->
		<link rel="stylesheet" type="text/css" href="css/table-layout.css" />
		<script type="text/javascript" src="js/jquery.table-layout.js"></script>

		<!-- table-data -->
        <link rel="stylesheet" type="text/css" href="css/table-data.css" />
		<script type="text/javascript" src="js/jquery.table-data.js"></script>

		<!-- page-button -->
        <link rel="stylesheet" type="text/css" href="css/button.css" />
        <script type="text/javascript" src="js/jquery.button.js"></script>
		<!-- <script type="text/javascript" src="js/jquery.button-showcase.js"></script> -->

		
		<!-- wrapper manage simple -->
        <link rel="stylesheet" type="text/css" href="plugins/wrappers/manage-simple/css/manage-simple.css" />

        <!-- Page specific css -->
        <style type="text/css">



        </style>

        <!-- Page specific javascript -->
        <script type="text/javascript">
            $(function() {

            });

			
			
        </script>
		
	</head>
	</head>

    <body class="body">

        <style type="text/css">

           
            

        </style>
        <!-- Page specific js -->
        <script type="text/javascript">
            $(function() {

				/* TODOs
                --------------------------------------------------------------*/  
				// TODO: change save-state to confirmed-state
				// TODO: change saveRow to confirmRow







				// TODO: create general saveTableChange


				// TODO: create general revertTableChange


				// TODO: create general revertRowChange 


				// TODO: create general saveRowChange




				// TODO: 
				// TODO: 
				// TODO: 
				// TODO: 
				// TODO: 
				// TODO: 
				
				
				

			
			
			
			
			
			
                /* Bind events
                --------------------------------------------------------------*/  

                /* search */
                $('.button.search').click(function() {
                    oTable.fnReloadAjax("search.do?" + $('form').serialize(), function(){
                        
                    });
                });


                 
                 
				 
				 
				 
				 
				 
				 
                /* Apply datatables jquery datatables plugin
                --------------------------------------------------------------*/  

				/* options */
				var options = {
					"columns" : [ 
						{
							"tag": "select",
							"name": "group",
							"class": "group",
							"options": [["", ""], ["Rollcontainers", "RC"], ["Freezers", "FC"], ["Other", "OTHER"]]
						}, {
							"tag": "input",
							"type": "hidden",
							"name": "unit",
							"class": "unit"
						}, {
							"tag": "input",
							"name": "description",
							"class": "description"
						}, {
							"tag": "input",
							"type": "checkbox",
							"name": "external-code",
							"class": "external-code",
							"value": "1234",
							"label": "Enabled?",
							"true": "Enabled",
							"false": "Disabled"
						}, {
							"tag" : "custom",
							"html" : "<input name='extra1' class='extra1' value='default value' />",
							"setValue" : function(value, html){ $(html).val(value); },
							"getValue" : function(html){ return $(html).val(); }
						}, {
							"tag": "input",
							"type": "hidden",
							"name": "extra2",
							"class": "extra2"
						}, {
							"tag": "input",
							"name": "extra3",
							"class": "extra3"
						}, {
							"tag": "input",
							"name": "extra4",
							"class": "extra4"
						}
					 ]
					
				};
				
				
								
				function _createHtml(options) {
					switch (options.tag) {

					case "custom":
						// use custom html
						return $(options.html);
						break;

					case "select":
						// create select
						var $select = $('<select></select>');
						$select.attr('name', options.name);
						$select.attr('class', options.class);
						// create options
						var $selectOption;
						$.each(options.options, function(key, value) {
							$selectOption = $('<option></option>');
							$selectOption.attr('value', value[1]);
							$selectOption.html(value[0]);
							$select.append($selectOption);
						});
						return $select;
						break;

					case "input":
					default:
						switch (options.type) {
						case "checkbox":
							// create input type="checkbox"
							var $input = $('<input/>');
							$input.attr('type', options.type);
							$input.attr('name', options.name);
							$input.attr('class', options.class);
							$input.attr('value', options.value);
							// create label for input
							var $label = $('<label/>');
							$label.html(options.label);
							$label.prepend($input);
							return $label;
							break;
						case "hidden":
							// create input type="hidden"
							var $input = $('<input/>');
							$input.attr('type', options.type);
							$input.attr('name', options.name);
							$input.attr('class', options.class);
							// create span for input value
							var $span = $('<span></span>');
							$span.append($input);
							return $span;
							break;
						case "text":
						default:
							// create input type="text"
							var $input = $('<input/>');
							$input.attr('name', options.name);
							$input.attr('class', options.class);
							return $input;
						}

					}
				}


				function _setHtmlValue(value, html, options) {
					switch (options.tag) {

					case "custom":
						// use custom set method    
						return options.setValue(value, html);
						break;

					case "select":
						// set select value 
						var $select = $(html);
						$('option', $(html)).each(function() {
							var $option = $(this);
							if ($option.html() === value) {
								$select.val($option.val());
							}
						});
						break;

					case "input":
					default:
						switch (options.type) {
						case "checkbox":
							// get input type="checkbox" value
							if (value === options.true) {
								$('input[type=checkbox]', $(html)).prop('checked', true);
							} else {
								$('input[type=checkbox]', $(html)).prop('checked', false);
							}
							break;
						case "hidden":
							// get input type="hidden" value
							$span = $(html);
							$('input[type=hidden]', $span).val(value);
							$span.prepend(value); // 
							break;
						case "text":
						default:
							// get input type="text" value
							$(html).val(value);
						}

					}
				}

				function _getHtmlValue(html, options) {
					switch (options.tag) {

					case "custom":
						// use custom get method
						return options.getValue(html);
						break;

					case "select":
						// get select value
						return $('option[value=' + $(html).val() + ']', $(html)).html();
						break;

					case "input":
					default:
						switch (options.type) {
						case "checkbox":
							// get input type="checkbox" value
							var checked = $('input[type=checkbox]', $(html)).prop('checked');
							if (checked) {
								return options.true;
							} else {
								return options.false;
							}
							break;
						case "hidden":
							// get input type="hidden" value
							return $('input[type=hidden]', $(html)).val();
							break;
						case "text":
						default:
							// get input type="text" value
							return $(html).val();
						}

					}
				}



				function _saveHtml(td, options) {
					var $html = _getHtmlValue(td.children(), options);
					$(td).html($html);
				}

				function _editHtml(td, options) {
					if(typeof options == 'undefined'){
						l('optiones == undefined');
return "";
					}
					// create html
					var text = $(td).text();
					var $html = _createHtml(options);
					_setHtmlValue(text, $html, options);
					$(td).html($html);
				}

				
				
				
				/* Add edit columns  */
				var editCell = "<span class='edit-menu-item add-row'></span>"+
							   "<span class='edit-menu-item remove-row'></span>"+
							   "<span class='edit-menu-item edit-row'></span>"+
							   "<span class='edit-menu-item save-row'></span>"+
							   "<span class='edit-menu-item revert-row'></span>"+
							   "<span class='edit-menu-item delete-row'></span>";

				$("table thead tr").prepend('<th>Edit</th>'); // class edit-menu
				$("table tbody tr").prepend("<td>"+editCell+"</td>"); // class edit-menu
				$("table thead tr").prepend("<th>Row</th>"); // class row-id
				$("table tbody tr").prepend(function(index, html){
					var rowNumber = index + 1;
					return "<td>"+rowNumber+"</td>"; // class row-id
				});
	
				

			

				
				
                // Table plugin
                var oTable = $('table').dataTable({
                    "bJQueryUI" : true,
					"sScrollY": "500px",
					"sScrollX": "800px",
                    "bAutoWidth": false,
					"sScrollXInner": "1200px",
					"bScrollCollapse": true,
					"bPaginate": false,
                    "oLanguage": {
                        "sSearch": "Filter"
                    },
					"aaSortingFixed": [[0,'asc']],
					"aoColumnDefs": [ 
						{ "bSortable": false, "aTargets": [ "_all" ] },
						{ "sClass": "row-id", "aTargets": [ 0 ] },
						{ "bVisible": false, "aTargets": [ 0 ] },
						{ "sClass": "edit-menu", "aTargets": [ 1 ] },
						{ "bVisible": false, "aTargets": [ 1 ] },
						{ "sWidth": "60px", "aTargets": [ 1 ] }
					],
                    "sDom": '<"H"Tfr>t<"F"ip>',
                    "oTableTools": {
                        "sSwfPath": "plugins/DataTables-1.8.2/plugins/TableTools-2.0.1/media/swf/copy_cvs_xls.swf",
                        "aButtons": [
                            {
                                "sExtends":    "collection",
                                "sButtonText": "Export",
                                "aButtons":    [ "print", "csv", "xls", "pdf" ]
                            },
							"copy"
                        ]
                    }
                });
				
				
				
				
				
				
				
								
				

                /* Initialise Edit Table Buttons
                --------------------------------------------------------------*/  
				
				_log('\ninitialise table');

				// add edit table buttons
				$('div.DTTT_container.ui-buttonset.ui-buttonset-multi').append(
					'<button class="button edit edit-table DTTT_button">Edit</button>' +
					'<button class="button revert revert-table DTTT_button">Revert</button>' +
					'<button class="button save save-table DTTT_button">Save</button>'
				);
				$('button.edit-table').button({
					icons: {
						primary: "ui-icon-pencil"
					}
				});
				$('button.revert-table').button({
					icons: {
						primary: "ui-icon-arrowreturnthick-1-w"
					}
				});
				$('button.save-table, ').button({
					icons: {
						primary: "ui-icon-check"
					}
				});


				
				// apply view state
				$('div.dataTables_wrapper').addClass('table-simple');
				_changeState($('div.table-simple'), 'view-state');
				
 			


			
				
				
				

				
				/* Event Handlers for Edit Table Buttons
                --------------------------------------------------------------*/  

               /* edit table */
                $('button.edit-table').click(function() {
					_log('\nclicked edit-table');
						
					// switch columns to table edit state
					oTable.fnSetColumnVis( 1, true );


					
					// apply edit state
					$('div.table-simple tbody tr').addClass('read-row-state');
					_changeState($('div.table-simple'), 'edit-state');
					

						
				});
								
				
				
				/* save table */
                $('button.save-table').click(function() {
					_log('\nclicked save-table');
					
					// handle added rows
					var addedRow = [];
					$('tr.add-row-state').each(function(){
						thisRow = this;
						$thisRow = $(this);
						
						_revertAddRow(oTable, thisRow);
					});
					$('tr.save-add-row-state').each(function(){
						thisRow = this;
						$thisRow = $(this);

						//_saveAddRow(oTable, thisRow);
						$thisRow.removeClass('save-add-row-state');
					});

					
					
					// handle removed rows
					$('tr.remove-row-state').each(function(){
						thisRow = this;
						$thisRow = $(this);

						//saveRemoveRow(oTable, thisRow);
						oTable.fnDeleteRow(thisRow);
					});

					
					
					// handle edited rows
					$('tr.edit-row-state').each(function(){
						thisRow = this;
						$thisRow = $(this);

						_revertEditRow(oTable, thisRow);
					});
					$('tr.save-edit-row-state').each(function(){
						thisRow = this;
						$thisRow = $(this);

						//_saveEditRow(oTable, thisRow);
						$thisRow.removeClass('save-edit-row-state');
					});


					
					// switch columns to table view state
                    oTable.fnSetColumnVis( 1, false );


					
					// apply view state
					$('div.table-simple tbody tr').removeClass('read-row-state');
					_changeState($('div.table-simple'), 'view-state');
					

				});				



                /* revert table */
                $('button.revert-table').click(function() {
					_log('\nclicked revert-table');
					
					// handle added rows
					var addedRow = [];
					$('tr.add-row-state').each(function(){
						thisRow = this;
						$thisRow = $(this);
						
						_revertAddRow(oTable, thisRow);
					});
					$('tr.save-add-row-state').each(function(){
						thisRow = this;
						$thisRow = $(this);

						_revertSaveAddRow(oTable, thisRow);
					});

					
					
					// handle removed rows
					$('tr.remove-row-state').each(function(){
						thisRow = this;
						$thisRow = $(this);

						_revertRemoveRow(oTable, thisRow);
					});

					
					
					// handle edited rows
					$('tr.edit-row-state').each(function(){
						thisRow = this;
						$thisRow = $(this);

						_revertEditRow(oTable, thisRow);
					});
					$('tr.save-edit-row-state').each(function(){
						thisRow = this;
						$thisRow = $(this);

						_revertSaveEditRow(oTable, thisRow);
					});
					
					
					
					
					// switch columns to table edit state
					oTable.fnSetColumnVis( 1, false );


					
					// apply view state
					$('div.table-simple tbody tr').removeClass('read-row-state');
					_changeState($('div.table-simple'), 'view-state');
					
					

				});
				
				
				
				
				
				
				
				
				
				
                /* Event Handlers for Edit Row Menu
                --------------------------------------------------------------*/  
				
				/* edit row */
				$("span.edit-row").live({
				
					click: function (event) {
						_log('\nclicked edit-row');
						event.preventDefault();	
						$thisRow = $(this).closest('tr');
						
						editRow(oTable, $thisRow[0]);
					}

				});
				
				
				
				/* add row */
				$("span.add-row").live({
				
					click: function (event) {
						_log('\nclicked add-row');
						event.preventDefault();	
						$thisRow = $(this).closest('tr');
						
						addRow(oTable, $thisRow[0]);
					}

				});


				
				/* remove row */
				$("span.remove-row").live({
				
					click: function(event) {
						_log('\nclicked remove-row');
						event.preventDefault();	
						$thisRow = $(this).closest('tr');

						removeRow(oTable, $thisRow[0]);
					}

				});
 				
				
				
				/* save row */
				$("span.save-row").live({
				
					click: function (event) {
						_log('\nclicked save-row');
						event.preventDefault();	
						thisRow = $(this).closest('tr')[0];

						saveRow(oTable, thisRow);
					}
					
				});
				
				
				
				/* revert row */
				$("span.revert-row").live({
				
					click: function (event) {
						_log('\nclicked revert-row');
						event.preventDefault();	
						$thisRow = $(this).closest('tr');
						
						revertRow(oTable, $thisRow[0]);	
					}
					
				});               
 				
				

				/* click row */
				$('tr.read-row-state td:not(.edit-menu), tr.save-edit-row-state td:not(.edit-menu), tr.save-add-row-state td:not(.edit-menu), tr.remove-row-state td:not(.edit-menu)').live({
					
					click: function (event) {
						event.preventDefault();
						_log('\nrow clicked!');						

						var $clickedTag = $(event.target);
						var $thisCell = $clickedTag.closest('td');
						
						var $thisRow = $clickedTag.closest('tr');		
						var thisRow = $thisRow[0];		
						

						editRow(oTable, thisRow);
						focusCellInput(oTable, $thisCell);

						
						if ( $thisCell.hasClass('edit-menu') || $thisCell.length === 0 ) {
						
							// ignore row click since edit-menu cell i clicked	
							return;	
							
						}
						

					}

				});
				

				
				/* press enter to save row */
				$('tr.edit-row-state input, tr.add-row-state input').live({
					
					keyup: function (event) {
						var $thisInput = $(this);
						var $thisRow = $thisInput.closest('tr');		
						
						var KEYCODE_ENTER = 13;
						var KEYCODE_ESC = 27;
						if (event.keyCode == KEYCODE_ENTER) {
							_log('\nenter key pressed!');						
							saveRow(oTable, $thisRow); 
						} 
						if (event.keyCode == KEYCODE_ESC) {
							_log('\nescape key pressed!');						
							revertRow(oTable, $thisRow); 
						} 

					}

				});

				
				
				
				

				
				
				
				
				
                /* Public Help Methods
                --------------------------------------------------------------*/  

				// TODO: thisnk below over
				// TODO: change name for _editRow(), ... to _goToEditRowState
				// TODO: change name for _changeState(), ... to _changeStateClass()
				

				
				/* general edit row */
				function editRow(oTable, $row) {
					_log('called editRow()');
					if ( !($row instanceof jQuery) ) {
						$row = $($row); // convert to jquery object
					}

					currentState = _getState($row);
					switch (currentState) {
					
						case 'read-row-state':

							// state change: read-row-state -> edit-row-state
							_editRow(oTable, $row[0]);
							return;

						case 'edit-row-state':
							
							// state change: none, do nothing
							return;

						case 'save-edit-row-state':
							
							// state change: save-edit-row-state -> edit-row-state
							_editSaveEditRow(oTable, $row[0]);	
							return;

						case 'add-row-state':
						
							// state change: none, do nothing
							return;

						case 'save-add-row-state':
						
							// state change: save-add-row-state -> add-row-state
							_editSaveAddRow(oTable, $row[0]);	
							return;

						case 'remove-row-state':
						
							// state change: remove-row-state -> read-row-state -> edit-row-state
							_revertRemoveRow(oTable, $row[0]);	
							_editRow(oTable, $row[0]);	
							return;
							
					} // switch currentState
					

					// ERROR: should not be possible, row state is missing
					alert("ERROR: should not be possible, row state is missing");
					_log("ERROR: should not be possible, row state is missing");


					
				}

				
				
				/* general add row */
				function addRow(oTable, $row) {
					_log('called addRow()');
					if ( !($row instanceof jQuery) ) {
						$row = $($row); // convert to jquery object
					}

					currentState = _getState($row);
					switch (currentState) {
					
						case 'read-row-state':
						
							// state change: read-row-state -> NEW-ROW: add-row-state
							_addRow(oTable, $row[0]);
							return;

						case 'edit-row-state':
		
							// state change: none, do nothing
							return;

						case 'save-edit-row-state':
							
							// state change: save-edit-row-state -> NEW-ROW: add-row-state
							_addRow(oTable, $row[0]);	
							return;

						case 'add-row-state':
						
							// state change: none, do nothing
							return;

						case 'save-add-row-state':
						
							// state change: save-add-row-state -> NEW-ROW: add-row-state
							_addRow(oTable, $row[0]);	
							return;

						case 'remove-row-state':
						
							// state change: none, do nothing
							return;
							
					} // switch currentState
					

					// ERROR: should not be possible, row state is missing
					alert("ERROR: should not be possible, row state is missing");
					_log("ERROR: should not be possible, row state is missing");


					
				}	



				/* general remove row */
				function removeRow(oTable, $row) {
					_log('called removeRow()');
					if ( !($row instanceof jQuery) ) {
						$row = $($row); // convert to jquery object
					}

					currentState = _getState($row);
					switch (currentState) {
						case 'read-row-state':

							// state change: read-row-state -> remove-row-state
							_removeRow(oTable, $row[0]);
							return;

						case 'edit-row-state':
							
							// state change: edit-row-state -> read-row-state -> remove-row-state
							_revertEditRow(oTable, $row[0]);
							_removeRow(oTable, $row[0]);
							return;

						case 'save-edit-row-state':
							
							// state change: save-edit-row-state -> read-row-state -> remove-row-state
							_revertSaveEditRow(oTable, $row[0]);
							_removeRow(oTable, $row[0]);
							return;

						case 'add-row-state':
						
							// state change: add-row-state -> REMOVE-ROW
							oTable.fnDeleteRow($row[0]);
							return;

						case 'save-add-row-state':
						
							// state change: save-add-row-state -> REMOVE-ROW
							oTable.fnDeleteRow($row[0]);
							return;

						case 'remove-row-state':
						
							// state change: none, do nothing
							return;
						
					} // switch currentState
					

					// ERROR: should not be possible, row state is missing
					alert("ERROR: should not be possible, row state is missing");


					
				}	

				

				/* general revert row */
				function revertRow(oTable, $row) {
					_log('called revertRow()');
					if ( !($row instanceof jQuery) ) {
						$row = $($row); // convert to jquery object
					}

					currentState = _getState($row);
					switch (currentState) {
					
						case 'read-row-state':

							// state change: none, do nothing
							return;

						case 'edit-row-state':
							
							// state change: edit-row-state -> read-row-state
							_revertEditRow(oTable, $row[0]);
							return;

						case 'save-edit-row-state':
							
							// state change: save-edit-row-state -> read-row-state
							_revertSaveEditRow(oTable, $row[0]);
							return;

						case 'add-row-state':
						
							// state change: add-row-state -> REMOVE-ROW
							oTable.fnDeleteRow($row[0]);
							return;

						case 'save-add-row-state':
						
							// state change: save-add-row-state -> REMOVE-ROW
							oTable.fnDeleteRow($row[0]);
							return;

						case 'remove-row-state':
						
							// state change: remove-row-state -> read-row-state
							_revertRemoveRow(oTable, $row[0]);	
							return;
							
					} // switch currentState
					

					// ERROR: should not be possible, row state is missing
					alert("ERROR: should not be possible, row state is missing");


					
				}	

				

				/* general save row */
				function saveRow(oTable, $row) {
					_log('called saveRow()');
					if ( !($row instanceof jQuery) ) {
						$row = $($row); // convert to jquery object
					}

					currentState = _getState($row);
					switch (currentState) {
					
						case 'read-row-state':

							// state change: none, do nothing
							return;

						case 'edit-row-state':
							
							// state change: edit-row-state -> save-edit-row-state
							_saveEditRow(oTable, $row[0]);
							return;

						case 'save-edit-row-state':
							
							// state change: none, do nothing
							return;

						case 'add-row-state':
							
							// state change: edit-row-state -> save-add-row-state
							_saveAddRow(oTable, $row[0]);
							return;

						case 'save-add-row-state':
						
							// state change: none, do nothing
							return;

						case 'remove-row-state':
						
							// state change: none, do nothing
							return;
							
					} // switch currentState
					

					// ERROR: should not be possible, row state is missing
					alert("ERROR: should not be possible, row state is missing");


					
				}
				
				
				
				
				
				
				
				
				
				
                /* Private Help Variables
                --------------------------------------------------------------*/  
				var _$thisTable = $('table');
				var _$currentEditRow;
				var _$editedRows;
				var _$addedRows;
				var _$removedRows;

				
				
				
				
				
				
				
				
				
                /* Private Help Methods
                --------------------------------------------------------------*/  
				
				/* get row id */
				function _getRowId(row) {
					if ( row instanceof jQuery && row.length > 0 ) {
						row = row[0]; // convert to dom object
					}
					
					var position = oTable.fnGetPosition(row);
					var rowId = oTable.fnGetData(position)[0];

					return rowId;
					
					
					
				}
						
						

				/* create below row id */
				function _getBelowRowId($row) {
					if ( !($row instanceof jQuery) ) {
						$row = $($row); // convert to jquery object
					}
					
					$nextRow = $row.next('tr');

					if ( $nextRow.length > 0 ) {
						var belowRowId = parseFloat( $nextRow.children('td')[0].innerText );
					} else {
						var belowRowId = parseFloat(  $row[0].innerText ) + 1;
					}
					
					return belowRowId;
					
					
				}
				
				
				
				/* change object state */
				function _changeState($object, newState) {
					if ( !($object instanceof jQuery) ) {
						$object = $($object); // convert to jquery object
					}
					
					// chamge state
					var currentState = _getState($object);					
					if ( currentState === '' ) {
						// object has no state, add new state
						_log('state changed: no-state -> ' + newState);
						$object.addClass( newState );
						return;
					} else if ( currentState ) {
						// object has state, change state
						_log('state changed: ' + currentState + ' -> ' + newState);
						$object.removeClass( currentState );
						$object.addClass( newState );
						return;
					} else {
						// ERROR: object has more than one state, ignore
						_log( 'state changed: ERROR: object has more than one state' );
						_log( $object );
						return;
					}

					
					
				}

				
				
				/* get object state */
				function _getState($object) {
					if ( !($object instanceof jQuery) ) {
						$object = $($object); // convert to jquery object
					}

					// get current state
					var currentState = $object.attr('class').match(/[^\s]*-state/gi);
					if ( currentState == null ) {
						// object has no state
						currentState = '';
						return currentState;
					} else if ( currentState.length == 1 ) {
						// object has one state
						currentState = currentState.toString().replace(',', ' ');
						return currentState;
					} else {
						// ERROR: object has more than one state
						alert( 'ERROR: object has more than one state: ' + currentState.toString() )
						_log( 'ERROR: object has more than one state' + currentState.toString() );
						_log( $object );
						return;
					}
					
					
					
				}
	
				/* edit row */
				function _editRow ( oTable, nRow )
				{
					_log('called _editRow()');
				
					/* set revert data */
					var aData = oTable.fnGetData(nRow);
					$(nRow).data('aData', aData.slice(0));
					
					/* make row editable */
					var $cells = $('>td', nRow).not('td.edit-menu'); // skip edit menu cell
					$cells.each(function(index){
						$thisCell = $(this);
						_editHtml($thisCell, options.columns[index]);
					});

					_changeState(nRow, 'edit-row-state');
				}

				function _revertEditRow ( oTable, nRow )
				{
					_log('called _revertEditRow()');
					
					/* get revert data */
					var aData = $(nRow).data('aData');
					
					/* restore revert data */
					var $cells = $('>td', nRow).not('td.edit-menu'); // skip edit menu cell
					$cells.each(function(index){
						oTable.fnUpdate( aData[index+2], nRow, index+2, false ); // +2 since tow first columns are hidden
					});
					
					oTable.fnDraw();
					
					_changeState(nRow, 'read-row-state');
				}	

				function _saveEditRow ( oTable, nRow )
				{
					_log('called _saveEditRow()');
					
					var jqTds = $('>td', nRow);
					// ignore edit menu

					/* make row static */
					var $cells = $('>td', nRow).not('td.edit-menu'); // skip edit menu cell
					$cells.each(function(index){
						$thisCell = $(this);
						_saveHtml($thisCell, options.columns[index]);
						oTable.fnUpdate( $thisCell.html(), nRow, index+2, false ); // +2 since tow first columns are hidden
					});				

					oTable.fnDraw();
					
					_changeState(nRow, 'save-edit-row-state');
				}

				function _revertSaveEditRow ( oTable, nRow )
				{
					_log('called _revertSaveEditRow()');
					
					/* get revert data */
					var aData = $(nRow).data('aData');
					
					/* restore revert data */
					var $cells = $('>td', nRow).not('td.edit-menu'); // skip edit menu cell
					$cells.each(function(index){
						$thisCell = $(this);
						oTable.fnUpdate( aData[index+2], nRow, index+2, false ); // +2 since tow first columns are hidden
					});
					
					oTable.fnDraw();
					
					_changeState(nRow, 'read-row-state');
				}			

				function _editSaveEditRow ( oTable, nRow )
				{
					_log('called _editSaveEditRow()');
				
					var aData = oTable.fnGetData(nRow);

					/* make row editable */
					var $cells = $('>td', nRow).not('td.edit-menu'); // skip edit menu cell
					$cells.each(function(index){
						$thisCell = $(this);
						_editHtml($thisCell, options.columns[index]);
					});

					_changeState(nRow, 'edit-row-state');
				}
				
				
				
				/* add row */
				function _addRow ( oTable, nRow )
				{
					_log('called _addRow()');
					var nRowData = oTable.fnGetData(nRow);
					var aiNew = oTable.fnAddData([ 
						nRowData[0], 
						editCell, 
						'', 
						'', 
						'', 
						'', 
						'', 
						'', 
						'', 
						''
					]);
					var nNewRow = oTable.fnGetNodes( aiNew[0] );
					
					var aData = oTable.fnGetData(nNewRow);
					var jqTds = $('>td', nNewRow);
					
					
					// keep row id
					$(jqTds[0]).addClass('edit-menu'); // add class to edit-menu
					jqTds[1].innerHTML = '<input value="'+aData[2]+'">';
					jqTds[2].innerHTML = '<input value="'+aData[3]+'">';
					jqTds[3].innerHTML = '<input value="'+aData[4]+'">';
					jqTds[4].innerHTML = '<input value="'+aData[5]+'">';
					jqTds[5].innerHTML = '<input value="'+aData[6]+'">';
					jqTds[6].innerHTML = '<input value="'+aData[7]+'">';
					jqTds[7].innerHTML = '<input value="'+aData[8]+'">';
					jqTds[8].innerHTML = '<input value="'+aData[9]+'">';
					
					_changeState(nNewRow, 'add-row-state');
				}					

				function _revertAddRow ( oTable, nRow )
				{
					_log('called _revertAddRow()');
					oTable.fnDeleteRow(nRow);

					_changeState(nRow, 'no-row-state');
				}
				
				function _saveAddRow ( oTable, nRow )
				{
					_log('called _saveAddRow()');
					
					var jqInputs = $('input', nRow);
					// keep row id
					// keep edit menu
					oTable.fnUpdate( jqInputs[0].value, nRow, 2, false );
					oTable.fnUpdate( jqInputs[1].value, nRow, 3, false );
					oTable.fnUpdate( jqInputs[2].value, nRow, 4, false );
					oTable.fnUpdate( jqInputs[3].value, nRow, 5, false );
					oTable.fnUpdate( jqInputs[4].value, nRow, 6, false );
					oTable.fnUpdate( jqInputs[5].value, nRow, 7, false );
					oTable.fnUpdate( jqInputs[6].value, nRow, 8, false );
					oTable.fnUpdate( jqInputs[7].value, nRow, 9, false );

					oTable.fnDraw();
					
					_changeState(nRow, 'save-add-row-state');
				}
				
				function _revertSaveAddRow ( oTable, nRow )
				{
					_log('called _revertSaveAddRow()');
					oTable.fnDeleteRow(nRow);

					_changeState(nRow, 'no-row-state');
				}	
				
				function _editSaveAddRow ( oTable, nRow )
				{
					_log('called _editSaveAddRow()');
				
					var aData = oTable.fnGetData(nRow);
					var jqTds = $('>td', nRow);
					// keep row id
					// keep edit menu
					jqTds[1].innerHTML = '<input value="'+aData[2]+'">';
					jqTds[2].innerHTML = '<input value="'+aData[3]+'">';
					jqTds[3].innerHTML = '<input value="'+aData[4]+'">';
					jqTds[4].innerHTML = '<input value="'+aData[5]+'">';
					jqTds[5].innerHTML = '<input value="'+aData[6]+'">';
					jqTds[6].innerHTML = '<input value="'+aData[7]+'">';
					jqTds[7].innerHTML = '<input value="'+aData[8]+'">';
					jqTds[8].innerHTML = '<input value="'+aData[9]+'">';
					
					_changeState(nRow, 'add-row-state');
				}	
								

		

				/* remove row */
				function _removeRow ( oTable, nRow )
				{
					_log('called _removeRow()');
					
					_changeState(nRow, 'remove-row-state');
				}					

				function _revertRemoveRow ( oTable, nRow )
				{
					_log('called _revertRemoveRow()');
					
					_changeState(nRow, 'read-row-state');
				}						

				
				
				/* other help functions */
				function focusCellInput(oTable, $cell) {
					$cell.find('input').focus();
				}	

				


				
				
				
				
				
				
				
				

				
				
                /* Other Functionality
                --------------------------------------------------------------*/  
				
				/* modify button looks */ 
				// copy
				$("button.DTTT_button_copy span").html("");
				$("button.DTTT_button_copy span").addClass('ui-button-text icon-only');
				$("button.DTTT_button_copy").prepend('<span class="ui-button-icon-primary ui-icon  ui-icon-clipboard"></span>');
				// export
				$("button.DTTT_button_collection span").html("");
				$("button.DTTT_button_collection span").addClass('ui-button-text icon-only');
				$("button.DTTT_button_collection").prepend('<span class="ui-button-icon-primary ui-icon  ui-icon-transferthick-e-w"></span>');




				
				
				
				
				
				

				
				
                /* Programming Templates
                --------------------------------------------------------------*/  
				/*
				if ( !($input instanceof jQuery) ) {
					$input = $($input); // convert input to jquery object
				}
				if (index === total - 1) {
					// this is the last one
				}
				
				// backup			//rowArray.push( $($row.find('td')[index]).text() );
				*/




				
				
				
				
				
				

				
				
                /* Area 51
                --------------------------------------------------------------*/  
				
				/*
				// testing row hoover edit:  Apply the jEditable handlers to the table 
				$('td', oTable.fnGetNodes()).editable( '../examples_support/editable_ajax.php', {
					"callback": function( sValue, y ) {
						var aPos = oTable.fnGetPosition( this );
						oTable.fnUpdate( sValue, aPos[0], aPos[1] );
					},
					"submitdata": function ( value, settings ) {
						return {
							"row_id": this.parentNode.getAttribute('id'),
							"column": oTable.fnGetPosition( this )[2]
						};
					},
					"height": "18px"
				} );
				*/
				
				
				
				/*
				// testing row hoover edit
				$("table tbody tr");				
				
				// testing td hoover edit
				$("table tbody td").live({
					onmouseover: function(event) {
						if (event.currentTarget === this) {
							$thisCell = $(this);
							_log($thisCell.width());
							$thisCell.html('<input class="edit-state" style="width:'+$thisCell.innerWidth()+'px" value="'+$thisCell.html()+'">');
							event.preventDefault();							
						}
					},
					onmouseout: function(event) {
						if (event.currentTarget === this) {
							$thisCell = $(this);
											
							event.preventDefault();						
						}					

					}
				});
				*/
				

            });

        </script>
		
        <div class="body-content"> 

			
       <div class="body-content"> 

			
            <!-- Table -->
            <div class="table">
                <h3 class="group-header">Manage Result</h3> 
				<table class="table-content display"> 
					<thead>
						<tr> 
							<th>Group</th>
							<th>Description</th>
							<th>Unit</th>
							<th>External Code</th>
							<th>Extra1</th>
							<th>Extra2</th>
							<th>Extra3</th>
							<th>Extra4</th>
						</tr>                                     
					</thead>
					<tbody>
						<tr>
							<td>Rollcontainers</td>
							<td>Rollcontainer In</td>
							<td>RCIN</td>
							<td>Disabled</td>							
							<td></td>						
							<td></td>								
							<td></td>						
							<td></td>												
						</tr>
						<tr>
							<td>Rollcontainers</td>
							<td>Rollcontainer In</td>
							<td>RCOUT</td>
							<td>Enabled</td>							
							<td></td>						
							<td></td>								
							<td></td>						
							<td></td>												
						</tr>
						<tr>
							<td>Freezers</td>
							<td>Freezer In</td>
							<td>FCIN</td>
							<td>Enabled</td>							
							<td></td>						
							<td></td>								
							<td></td>						
							<td></td>											
						</tr>
					</tbody> 
				</table>

                 
            </div><!-- Table -->   
            
            
        </div>
    </body>

</html>
