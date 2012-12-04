$(function() {

	// To detect native support for the HTML5 placeholder attribute
	var fakeInput = document.createElement("input"),
		placeHolderSupport = ("placeholder" in fakeInput);

	// Applies placeholder attribute behavior in web browsers that don't support it
	if (!placeHolderSupport) {

		$('[placeholder]').focus(function() {
			var input = $(this);
			if (input.val() == input.attr('placeholder')) {
				input.val('');
				input.removeClass('placeholder');
			}
		}).blur(function() {
			var input = $(this);
			if (input.val() == '' || input.val() == input.attr('placeholder')) {
				input.addClass('placeholder');
				input.val(input.attr('placeholder'));
			}
		}).blur().parents('form').submit(function() {
			$(this).find('[placeholder]').each(function() {
				var input = $(this);
				if (input.val() == input.attr('placeholder')) {
					input.val('');
				}
			})
		});

	}

	
	// Add jquery validation support, see http://stackoverflow.com/questions/4410118/jquery-validation-and-placeholder-conflict and http://jsfiddle.net/dido/n7wZ7/
	// Test if the submitted value is not equal to our placeholder.
	// Use the default validation message for required fields.
	$.validator.addMethod('notPlaceholder', function(val, el) {
		return ( val !== $(el).attr('placeholder') );
	}, $.validator.messages.required);
	
	
});


