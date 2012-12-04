(function($){
     $.fn.notify = function(messageType, message){
        return this.each(function(){
           var $this = $(this);
		   
		   //$this.attr('class', ''); // remove current classes
		   //$this.addClass("error");
		   
		   
		   
			if (messageType === "error") {
				var $notification = $("<div class='notification error'>");
				
				var messageIcon = '<span class="ui-icon ui-icon-alert" />';
				var messageText = '<span class="message">' + message + '</span>';
				var confirm = '<span class="confirm">Confirm</span>';

				$notification.html(messageIcon + messageText + confirm);
				$notification.click(function(){
					$(this).stop(true, true).fadeOut("slow", function(){
						$(this).remove();
					});
				});
				
				$this.append($notification);
				$notification.fadeIn("slow");

				return $notification;
			}
		   
			if (messageType === "info") {
				var $notification = $("<div class='notification info'>");
				
				var messageIcon = '<span class="ui-icon ui-icon-info" />';
				var messageText = '<span class="message">' + message + '</span>';
				var hide = '<span class="hide">Hide</span>';

				$notification.html(messageIcon + messageText + hide);
				$notification.click(function(){
					$(this).stop(true, true).fadeOut("slow", function(){
						$(this).remove();
					});
				});
				
				$this.append($notification);
				$notification.fadeIn("slow").children(".hide").css("display", "none").parent().delay("1000").fadeOut("slow", function(){
					$(this).remove();
				});
				$notification.hover(function(){
					$(this).children(".hide").css("display", "inline");
				},function(){
					$(this).children(".hide").css("display", "none");
				});
				
				return $notification;
			}
		   
			if (messageType === "loading") {
				var $notification = $("<div class='notification info loading'>");
				
				var messageIcon = '<span class="custom-icon loading" />';
				var messageText = '<span class="message">' + message + '</span>';
				var hide = '<span class="hide">Hide</span>';

				$notification.html(messageIcon + messageText + hide);
				$notification.click(function(){
					$(this).stop(true, true).fadeOut("slow", function(){
						$(this).remove();
					});
				});
				
				$this.append($notification);
				$notification.fadeIn("slow").children(".hide").css("display", "none");
				$notification.hover(function(){
					$(this).children(".hide").css("display", "inline");
				},function(){
					$(this).children(".hide").css("display", "none");
				});
				
				return $notification;				
			}
		   
			if (messageType === "loading-success") {
				var $notification = $("#notification-field .loading");
				
				$notification.removeClass("loading");
				$notification.addClass("loading-success");

				var messageIcon = '<span class="ui-icon ui-icon-check" />';
				var messageText = '<span class="message">' + message + '</span>';
				var hide = '<span class="hide">Hide</span>';

				$notification.html(messageIcon + messageText + hide);
				$notification.click(function(){
					$(this).stop(true, true).fadeOut("slow", function(){
						$(this).remove();
					});
				});
				
				$notification.fadeIn("slow").children(".hide").css("display", "none").parent().delay("1000").fadeOut("slow", function(){
					$(this).remove();
				});
				$notification.hover(function(){
					$(this).children(".hide").css("display", "inline");
				},function(){
					$(this).children(".hide").css("display", "none");
				});

				return $notification;				
			}

			if (messageType === "loading-failed") {
				var $notification = $("#notification-field .loading");
				
				$notification.removeClass("loading");
				$notification.addClass("error");
				$notification.addClass("loading-failed");
				
				var messageIcon = '<span class="ui-icon ui-icon-alert" />';
				var messageText = '<span class="message">' + message + '</span>';
				var confirm = '<span class="confirm">Confirm</span>';

				$notification.html(messageIcon + messageText + confirm);
				$notification.click(function(){
					$(this).stop(true, true).fadeOut("slow", function(){
						$(this).remove();
					});
				});

				$notification.fadeIn("slow");

				return $notification;	
			}		   

        });
     }
})(jQuery);

$(function() { 
	$("body").append("<div id='notification-field'></div>");
});















			$(function() { 

				/* Search Form Buttons
				--------------------------------------------------------------*/  

				// clear notification
				$( ".button.error" ).click(function(){
					$("#notification-field").notify("error", "Error!");
					//$("#notification-field").stop(true, true).notify("<span class='ui-icon ui-icon-check' />Cleared Form!").fadeIn("slow").delay(500).fadeOut("slow");
				}); 	
				$( ".button.info" ).click(function(){
					$("#notification-field").notify("info", "Info!");
					//$("#notification-field").stop(true, true).notify("<span class=\'preloader\' />Searching...").fadeIn("slow");
				}); 
				$( ".button.loading" ).click(function(){
					$("#notification-field").notify("loading", "Loading...");
				}); 
				$( ".button.loading-success" ).click(function(){
					$("#notification-field").notify("loading-success", "Loading Success!");
				}); 	 
				$( ".button.loading-failed" ).click(function(){
					$("#notification-field").notify("loading-failed", "Loading Failed!");
				}); 	 				


			});