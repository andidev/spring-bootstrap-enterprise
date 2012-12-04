(function() {

	$.validator.setDefaults({
		errorClass: 'error',
		validClass: 'success',
		errorElement: 'span',
		highlight: function(element, errorClass, validClass) {
			var $obj;
			$obj = element.type === 'radio' ? this.findByName(element.name) : $(element);
			return $obj.parents('div.control-group').removeClass(validClass).addClass(errorClass);
		},
		unhighlight: function(element, errorClass, validClass) {
			var $obj;
			$obj = element.type === 'radio' ? this.findByName(element.name) : $(element);
			$obj.next('span.help-inline.' + errorClass).remove();
			return $obj.parents('div.control-group').removeClass(errorClass).addClass(validClass);
		},
		errorPlacement: function(error, element) {
			if (element.siblings().length > 0) {
				error.insertAfter(element.siblings(':last'));
			} else {
				error.insertAfter(element);
			}
		}
	});

	$.validator.messages = ({
		required: "can't be blank",
		remote: 'needs to get fixed',
		email: 'is not a valid email address',
		url: 'is not a valid URL',
		date: 'is not a valid date',
		dateISO: 'is not a valid date (ISO)',
		number: 'is not a valid number',
		digits: 'needs to be digits',
		creditcard: 'is not a valid credit card number',
		equalTo: 'is not the same value again',
		accept: 'is not a value with a valid extension',
		maxlength: jQuery.validator.format('needs to be more than {0} characters'),
		minlength: jQuery.validator.format('needs to be at least {0} characters'),
		rangelength: jQuery.validator.format('needs to be a value between {0} and {1} characters long'),
		range: jQuery.validator.format('needs to be a value between {0} and {1}'),
		max: jQuery.validator.format('needs to be a value less than or equal to {0}'),
		min: jQuery.validator.format('needs to be a value greater than or equal to {0}')
	});

	$.validator.prototype.errors = function() {
		var errorClass;
		errorClass = this.settings.errorClass.replace(' ', '.');
		return $(this.settings.errorElement + '.' + errorClass, this.errorContext);
	};

	$.validator.prototype.optional = function(element) {
		return $(element).hasClass('optional') || (!$.validator.methods.required.call(this, $.trim(element.value), element) && 'dependency-mismatch');
	};

	$.validator.prototype.showLabel = function(element, message) {
		var label;
		label = this.errorsFor(element);
		if (label.length === 0) {
			var railsGenerated = $(element).next('span.help-inline');
			if (railsGenerated.length) {
				railsGenerated.attr({
					'for': this.idOrName(element),
					'generated': 'true'
				});
				label = railsGenerated;
			}
		}
		if (label.length) {
			label.removeClass(this.settings.validClass).addClass(this.settings.errorClass);
			label.attr('generated') && label.html(message);
		} else {
			label = $('<' + this.settings.errorElement + '/>').attr({
				'for': this.idOrName(element),
				'generated': true
			}).addClass(this.settings.errorClass).html(message || '').addClass('help-inline');
			if (this.settings.wrapper) {
				label = label.hide().show().wrap('<' + this.settings.wrapper + '/>').parent();
			}
			if (!this.labelContainer.append(label).length) {
				if (this.settings.errorPlacement) {
					this.settings.errorPlacement(label, $(element));
				} else {
					label.insertAfter(element);
				}
			}
		}
		if (!message && this.settings.success) {
			label.text('');
			if (typeof this.settings.success === 'string') {
				label.addClass(this.settings.success);
			} else {
				this.settings.success(label);
			}
		}
		return this.toShow = this.toShow.add(label);
	};

}).call(this);