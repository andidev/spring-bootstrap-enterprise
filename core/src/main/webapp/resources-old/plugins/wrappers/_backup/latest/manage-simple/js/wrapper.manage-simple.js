(function($) {

    var methods = {
        init: function(options) {
			
			// default options
            var defaultOptions = {
                add: function(){},
                remove: function(){},
                update: function(){}
            };		
			
			// override default options with input options
			var options =  $.extend(defaultOptions, options);
			
			// apply plugin
			return this.each(function() {
                var $resultTable = $('table').dataTable({
                    "bJQueryUI" : true,
                    "sPaginationType" : "full_numbers",
                    "bAutoWidth": false,
                    "oLanguage": {
                        "sSearch": "Filter"
                    },
                    "sDom": '<"H"Tfr>t<"F"ip>',
                    "oTableTools": {
                    
                        "sSwfPath": "plugins/DataTables-1.8.2/plugins/TableTools-2.0.1/media/swf/copy_cvs_xls_pdf.swf",
                        "aButtons": [
                            {
                                "sExtends":    "collection",
                                "sButtonText": "Export",
                                "aButtons":    [ "csv", "xls", "pdf" ]
                            },
                            "copy"

                        ]
                    }                    
                });
				
				
				
			});
			
			
			
		},
        add: function() {
			alert("add");
		},
        remove: function() {
			alert("remove");
		},
        update: function() {
			alert("update");
		},
        show: function() {},
        hide: function() {},
        update: function(content) {}
    };

	
	
	
	
	
	
	
	
	
	
    $.fn.tableManageSimple = function(method) {


		/* Functions
		----------------------------------*/
		
		this.hideAllNotifications = function(){
			return "hideAllNotifications";
		}

		
		

	
	
	
	
	
	
	
		/* Method calling logic
		----------------------------------*/
		
        if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.tableManageSimple');
        }
		
		
		
		
    };

	
})(jQuery);





$(function() { 

	// create notification-field container for notifications
	$("body").append("<div id='notification-field'></div>");
	var $notificationField = $("div#notification-field").notificationField();
	 				


});