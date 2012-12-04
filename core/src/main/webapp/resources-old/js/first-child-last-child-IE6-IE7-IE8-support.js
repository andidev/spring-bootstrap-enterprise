/* This plugin enables workaround support for pseudo-selector first-child and last-child in IE6, IE7 and IE8 */
/* All first childs will be stylable through the first-child and last-child class selector e.g. ".first-child { backround-color: red; } .last-child { backround-color: blue }" */
/* It only adds first- and last-child classes to the following tags: <div>, <h1>, to support more tags simply edit the selector in the plugin */
$(function() { 
	/* apply first-child class to all first-child divs */
    $('div:first-child, h1:first-child').addClass('first-child');
	/* apply last-child class to all last-child divs */
    $('div:last-child, h1:last-child').addClass('last-child');
});