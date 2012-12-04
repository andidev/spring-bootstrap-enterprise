$(function() { 

    /* Area 51
    --------------------------------------------------------------*/  




    /* Apply Plugins
    --------------------------------------------------------------*/  

    /* apply autocomplete jquery-ui */
    $('input.text-autocomplete').autocomplete({ "source": ["VALUE"] });



	/* apply select-autocomplete jquery plugin */
	/* TODO: add select-autocomplete functionality
    $('select.select-autocomplete').combobox(); */


	
    /* apply form validation jquery plugin */
    /* see http://bassistance.de/jquery-plugins/jquery-plugin-validation/ */
    /*
    jQuery.validator.setDefaults({ 
        debug: true,
            onfocusout: true,
            onkeyup: true,
    });
    $("form").validate({
		rules: {
			digits: {
				digits: true
		    },
			range: {
				
		    },
			number: {
				number: true	
			},
			minutes: {
				min: 0,
				max: 59
			},
			hours: {
				minlength: 0,
				maxlength: 23	
			},
			days: {
				minlength: 0,
				maxlength: 365	
			},
			time: {
				time: true,
			}
		},
        errorPlacement: function(error, element) {
            if( element.parent()[0].nodeName === 'LI' ) {
				var width = element.parent().parent().width();
				error.appendTo(element.parent().parent()).width(width);
			} else {
				var width = element.parent().width();
				error.appendTo(element.parent()).width(width);
			}
			//error.addClass('animated');
        },
		success: "valid",
		highlight: function(element, errorClass, validClass) {
			//$(element).addClass(errorClass).removeClass(validClass);
			//$(element.form).find("label[for=" + element.id + "]").addClass(errorClass);
		},
		unhighlight: function(element, errorClass, validClass) {
			//$(element).removeClass(errorClass).addClass(validClass);
			//	$(element.form).find("label[for=" + element.id + "]").removeClass(errorClass);
		}
    });
    */
	
	
    /* apply datepicker jquery-ui */
    /* see http://jqueryui.com/demos/datepicker/#default */
    $('input.data.text.date').datepicker({
        dateFormat: 'yy-mm-dd' /* TODO: fix better multilanguage support */
    });

	
	
    /* apply daterangepicker jquery-ui plugin */
    /* see http://www.filamentgroup.com/lab/date_range_picker_using_jquery_ui_16_and_jquery_ui_css_framework/ and http://www.datejs.com/ */
	$dateRange = $('input.data.text.date-range'); // WORKAROUND: use if case since init fails when no input.data.text.date-range is found
    if ($dateRange.length > 0) {
		$('input.data.text.date-range').daterangepicker({
			presetRanges: [
				{
				text: 'Past 7 Days',
				dateStart: 'Today',
				dateEnd: 'Last Week'},
			{
				text: 'Past Month',
				dateStart: 'Today',
				dateEnd: 'Last Month'},
			{
				text: 'Past 3 Month',
				dateStart: 'Today',
				dateEnd: 'Last 3 Month'},
			{
				text: 'Past Year',
				dateStart: 'Today',
				dateEnd: 'Last Year'}
			],
			arrows: false,
			dateFormat: 'yy-mm-dd',
			/* TODO: fix better multilanguage support */
			rangeSplitter: '-',
			datepickerOptions: {
				changeMonth: true,
				changeYear: true
			},
			onOpen: function() {},
			onClose: function() {}
		});
	};

	
	
    /* apply checkbox toggler plugin */
    /* see http://awardwinningfjords.com/2009/06/16/iphone-style-checkboxes.html and https://github.com/tdreyno/iphone-style-checkboxes */
    /*
	$('input.data.checkbox.yes-no').iphoneStyle({ 
		checkedLabel: 'Yes', 
		uncheckedLabel: 'No'
	});
    $('input.data.checkbox.on-off').iphoneStyle({ 
		checkedLabel: 'On', 
		uncheckedLabel: 'Off'
	});
    $('input.data.checkbox.enabled-disabled').iphoneStyle({ 
		checkedLabel: 'Enabled', 
		uncheckedLabel: 'Disabled' 
	});
	*/


    	
	
});