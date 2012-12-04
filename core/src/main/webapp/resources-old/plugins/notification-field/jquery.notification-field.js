(function($) {

    var methods = {
        init: function(options) {
			
			// default options
            var defaultOptions = {
                top: 60,
                right: 10
            };		
			
			// override default options with input options
			var options =  $.extend(defaultOptions, options);
			
			// apply plugin
			return this.each(function() {
		
			});
			
			
			
		},
        show: function() {},
        hide: function() {},
        update: function(content) {}
    };

    $.fn.notificationField = function(method) {


		/* Handling All Notification Functions
		----------------------------------*/
		
		this.hideAllNotifications = function(){
			return "hideAllNotifications";
		}
		this.showAllNotifications = function(){
			return "showAllNotifications";
		}
		this.removeAllNotifications = function(){
			return "removeAllNotifications";
		}		
		
		
		
		
		
		
		
		
		
		
		/* General Notification Functions
		----------------------------------*/
		
		// general error
		this.notifyError = function(message){
	
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
			
			this.append($notification);
			$notification.fadeIn("slow");

			return $notification;
				
		}
		
		
		
		// general alert
		this.notifyAlert = function(message, iconClass){
		
			var $notification = $("<div class='notification alert'>");
			
			if (iconClass) {
				var messageIcon = '<span class="' + iconClass + '" />';
			} else {
				var messageIcon = '<span class="ui-icon ui-icon-info" />';				
			}
			var messageText = '<span class="message">' + message + '</span>';
			var confirm = '<span class="confirm">Confirm</span>';

			$notification.html(messageIcon + messageText + confirm);
			$notification.click(function(){
				$(this).stop(true, true).fadeOut("slow", function(){
					$(this).remove();
				});
			});
			
			this.append($notification);
			$notification.fadeIn("slow");

			return $notification;
			
		}		
		
		
		
		// general info
		this.notifyInfo = function(message, iconClass){
			var $notification = $("<div class='notification info'>");
			if (iconClass) {
				var messageIcon = '<span class="' + iconClass + '" />';
			} else {
				var messageIcon = '<span class="ui-icon ui-icon-info" />';				
			}
			var messageText = '<span class="message">' + message + '</span>';
			var hide = '<span class="hide">Hide</span>';

			$notification.html(messageIcon + messageText + hide);
			$notification.click(function(){
				$(this).stop(true, true).fadeOut("slow", function(){
					$(this).remove();
				});
			});
			
			this.append($notification);
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
		
		
		
		// general loading
		this.notifyLoading = function(message){
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
			
			this.append($notification);
			$notification.fadeIn("slow").children(".hide").css("display", "none");
			$notification.hover(function(){
				$(this).children(".hide").css("display", "inline");
			},function(){
				$(this).children(".hide").css("display", "none");
			});
			
			return $notification;	
		}
		
		
		
		// general loading success
		this.notifyLoadingSuccess = function($notification, message){
			
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
		
		
		
		// general loading failed
		this.notifyLoadingFailed = function($notification, message){
			
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

		
		
		
		
		
		
		
				
		
		/* Create/Delete/Save Notification Functions
		----------------------------------*/
		
		// create
		this.notifyCreate = function(unit){
			if (unit) {
				var message = 'Creating ' + unit + '...';
			} else {
				var message = 'Creating..."';
			}
			return this.notifyLoading(message);
		}
		this.notifyCreateSuccess = function($notification, unit){
			if (unit) {
				var message = 'Created ' + unit + ' Successfully!';
			} else {
				var message = 'Created Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifyCreateFailed = function($notification, unit){
			if (unit) {
				var message = 'Creating ' + unit + ' Failed!';
			} else {
				var message = 'Creating Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}	
		
		
		
		// delete
		this.notifyDelete = function(unit){
			if (unit) {
				var message = 'Deleting ' + unit + '...';
			} else {
				var message = 'Deleting..."';
			}
			return this.notifyLoading(message);
		}
		this.notifyDeleteSuccess = function($notification, unit){
			if (unit) {
				var message = 'Deleted ' + unit + ' Successfully!';
			} else {
				var message = 'Deleted Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifyDeleteFailed = function($notification, unit){
			if (unit) {
				var message = 'Deleting ' + unit + ' Failed!';
			} else {
				var message = 'Deleting Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}

		
		
		// save
		this.notifySave = function(unit){
			if (unit) {
				var message = 'Saving ' + unit + '...';
			} else {
				var message = 'Saving..."';
			}
			return this.notifyLoading(message);
		}
		this.notifySaveSuccess = function($notification, unit){
			if (unit) {
				var message = 'Saved ' + unit + ' Successfully!';
			} else {
				var message = 'Saved Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifySaveFailed = function($notification, unit){
			if (unit) {
				var message = 'Saving ' + unit + ' Failed!';
			} else {
				var message = 'Saving Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}	
		
		
		
		
		
		
		
		
		
		
		/* Add/Remove/Update Notification Functions
		----------------------------------*/
		
		// add
		this.notifyAdd = function(unit){
			if (unit) {
				var message = 'Adding ' + unit + '...';
			} else {
				var message = 'Adding..."';
			}
			return this.notifyLoading(message);
		}
		this.notifyAddSuccess = function($notification, unit){
			if (unit) {
				var message = 'Added ' + unit + ' Successfully!';
			} else {
				var message = 'Added Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifyAddFailed = function($notification, unit){
			if (unit) {
				var message = 'Adding ' + unit + ' Failed!';
			} else {
				var message = 'Adding Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}	

		
		
		// remove
		this.notifyRemove = function(unit){
			if (unit) {
				var message = 'Removing ' + unit + '...';
			} else {
				var message = 'Removing..."';
			}
			return this.notifyLoading(message);
		}
		this.notifyRemoveSuccess = function($notification, unit){
			if (unit) {
				var message = 'Removed ' + unit + ' Successfully!';
			} else {
				var message = 'Removed Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifyRemoveFailed = function($notification, unit){
			if (unit) {
				var message = 'Removing ' + unit + ' Failed!';
			} else {
				var message = 'Removing Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}			

		
		
		// update
		this.notifyUpdate = function(unit){
			if (unit) {
				var message = 'Updating ' + unit + '...';
			} else {
				var message = 'Updating..."';
			}
			return this.notifyLoading(message);
		}
		this.notifyUpdateSuccess = function($notification, unit){
			if (unit) {
				var message = 'Updated ' + unit + ' Successfully!';
			} else {
				var message = 'Updated Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifyUpdateFailed = function($notification, unit){
			if (unit) {
				var message = 'Updating ' + unit + ' Failed!';
			} else {
				var message = 'Updating Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}	

		
		
		
		
		
		
		
		
		
		
		/* Search/Download/Upload/Export/Import Notification Functions
		----------------------------------*/
		
		// search
		this.notifySearch = function(unit){
			if (unit) {
				var message = 'Searching ' + unit + '...';
			} else {
				var message = 'Searching..."';
			}
			return this.notifyLoading(message);
		}
		this.notifySearchSuccess = function($notification, unit){
			if (unit) {
				var message = 'Searched ' + unit + ' Successfully!';
			} else {
				var message = 'Searched Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifySearchFailed = function($notification, unit){
			if (unit) {
				var message = 'Searching ' + unit + ' Failed!';
			} else {
				var message = 'Searching Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}
		
		
		
		// download
		this.notifyDownload = function(){
			if (unit) {
				var message = 'Downloading ' + unit + '...';
			} else {
				var message = 'Downloading..."';
			}
			return this.notifyLoading(message);
		}
		this.notifyDownloadSuccess = function($notification, unit){
			if (unit) {
				var message = 'Downloaded ' + unit + ' Successfully!';
			} else {
				var message = 'Downloaded Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifyDownloadFailed = function($notification, unit){
			if (unit) {
				var message = 'Downloading ' + unit + ' Failed!';
			} else {
				var message = 'Downloading Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}		
		
		
		
		// upload
		this.notifyUpload = function(){
			if (unit) {
				var message = 'Uploading ' + unit + '...';
			} else {
				var message = 'Uploading..."';
			}
			return this.notifyLoading(message);
		}
		this.notifyUploadSuccess = function($notification, unit){
			if (unit) {
				var message = 'Uploaded ' + unit + ' Successfully!';
			} else {
				var message = 'Uploaded Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifyUploadFailed = function($notification, unit){
			if (unit) {
				var message = 'Uploading ' + unit + ' Failed!';
			} else {
				var message = 'Uploading Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}
		
		
		
		// export
		this.notifyUpload = function(){
			if (unit) {
				var message = 'Exporting ' + unit + '...';
			} else {
				var message = 'Exporting..."';
			}
			return this.notifyLoading(message);
		}
		this.notifyUploadSuccess = function($notification, unit){
			if (unit) {
				var message = 'Exported ' + unit + ' Successfully!';
			} else {
				var message = 'Exported Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifyUploadFailed = function($notification, unit){
			if (unit) {
				var message = 'Exporting ' + unit + ' Failed!';
			} else {
				var message = 'Exporting Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}
		
		
		
		// import
		this.notifyDownload = function(){
			if (unit) {
				var message = 'Importing ' + unit + '...';
			} else {
				var message = 'Importing..."';
			}
			return this.notifyLoading(message);
		}
		this.notifyDownloadSuccess = function($notification, unit){
			if (unit) {
				var message = 'Imported ' + unit + ' Successfully!';
			} else {
				var message = 'Imported Successfully!"'
			}	
			return this.notifyLoadingSuccess($notification, message);
		}
		this.notifyDownloadFailed = function($notification, unit){
			if (unit) {
				var message = 'Importing ' + unit + ' Failed!';
			} else {
				var message = 'Importing Failed!"'
			}	
			return this.notifyLoadingFailed($notification, message);
		}
		
		
		
		
		
		
		
		
		
		
		/* Special Notification Functions
		----------------------------------*/
		
		// copy to clipboard
		this.notifyCopyToClipboard = function(unit){
			return this.notifyInfo("Copied To Clipboard!");
		}
			
	
	
		// lock data
		this.notifyLockData = function(unit){
			return this.notifyInfo("Locked Data!");
		}
		
		
		
		// unlock data
		this.notifyUnlockData = function(unit){
			return this.notifyInfo("Unlocked Data!");
		}
		
		
		
		// clear form
		this.notifyClearForm = function(unit){
			return this.notifyInfo("Cleared Form!");
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

	// create notification-field container for notifications
	$("body").append("<div id='notification-field'></div>");
	var $notificationField = $("div#notification-field").notificationField();
	
	
 /* Search Form Buttons
	--------------------------------------------------------------*/  
	var $notification;

	// clear notification
	$( ".button.error" ).click(function(){
		$notificationField.notifyError("Error!");
	}); 
	$( ".button.alert" ).click(function(){
		$notificationField.notifyAlert("Alert!");
	});	
	$( ".button.info" ).click(function(){
		$notificationField.notifyInfo("Info!");
	}); 
	$( ".button.loading" ).click(function(){
		$notification = $notificationField.notifyLoading("Loading...");
	}); 
	$( ".button.loading-success" ).click(function(){
		$notificationField.notifyLoadingSuccess($notification, "Loading Success!");
	}); 	 
	$( ".button.loading-failed" ).click(function(){
		$notificationField.notifyLoadingFailed($notification, "Loading Failed!");
	}); 	 				


});