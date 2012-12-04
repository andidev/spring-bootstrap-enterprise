/* ------------------------------------------------------------------------------------------ */
/* Log functions */
/* ------------------------------------------------------------------------------------------ */
// Use this wrapper around normal log function so that logging can be extended later on if needed
function l( log ) {
	console.log(log);
}
function _log( log ) {
	console.log(log);
}
// log css property change
jQuery.fn._logCssPropertyChange = function( name, value ) {
	_log('set css property: ' + name + ' = ' + value);
}
// 
function _logHtml( logText, tag ) {
	$(tag)._log(logText);
	_log('... = ' + $(tag).html());
}
//
jQuery.fn._logHtml = function( logText ) {
	return this.each(function() {
		_logHtml( logText, this );
	});
}
// 
function _logEvent( event ) {
	$(event.target)._log('triggered event: ' + event.type);
}
// Log a set of tags
jQuery.fn._log = function( logText ) {
	
	return this.each(function() {

	    var loggedTag;
	    var loggedAttributes = '';
	
	    var attribute;
	    var currentAttribute;
	    for( var i = 0; i < this.attributes.length; i++) {
	
	        attribute = this.attributes[i];
	
	        // skip every not specified attribute (useful for example in IE)
	        if ( attribute.specified == false ) continue;
	
	        currentAttribute = attribute.name + '="' + attribute.value + '"';
	        loggedAttributes += ((currentAttribute != '')?' ':'') + currentAttribute;
	    }
	
	    var tagName = this.tagName.toLowerCase();	
        logText = logText + ', <' + tagName + ((loggedAttributes != '')? ' '+ loggedAttributes : '') + '>...</' + tagName + '>';  

		_log( logText );
	});
}