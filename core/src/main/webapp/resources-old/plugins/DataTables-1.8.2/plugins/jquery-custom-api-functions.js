$.fn.dataTableExt.oApi.fnAddDataAndDisplay = function ( oSettings, aData )
{
	/* Add the data */
	var iAdded = this.oApi._fnAddData( oSettings, aData );
	var nAdded = oSettings.aoData[ iAdded ].nTr;
	
	/* Need to re-filter and re-sort the table to get positioning correct, not perfect
	 * as this will actually redraw the table on screen, but the update should be so fast (and
	 * possibly not alter what is already on display) that the user will not notice
	 */
	this.oApi._fnReDraw( oSettings );
	
	/* Find it's position in the table */
	var iPos = -1;
	for( var i=0, iLen=oSettings.aiDisplay.length ; i<iLen ; i++ )
	{
		if( oSettings.aoData[ oSettings.aiDisplay[i] ].nTr == nAdded )
		{
			iPos = i;
			break;
		}
	}
	
	/* Get starting point, taking account of paging */
	if( iPos >= 0 )
	{
		oSettings._iDisplayStart = ( Math.floor(i / oSettings._iDisplayLength) ) * oSettings._iDisplayLength;
		this.oApi._fnCalculateEnd( oSettings );
	}
	
	this.oApi._fnDraw( oSettings );
	return {
		"nTr": nAdded,
		"iPos": iAdded
	};
}

/* Example use */
/*
var oTable;
$(document).ready(function() {
	oTable = $('#example').dataTable();
	oTable.fnAddDataAndDisplay( [ 1, 2, 3, 4, 5 ] );
} );
*/


jQuery.fn.dataTableExt.oApi.fnProcessingIndicator = function ( oSettings, onoff )
{
	if( typeof(onoff) == 'undefined' )
	{
		onoff=true;
	}
	this.oApi._fnProcessingDisplay( oSettings, onoff );
}

/* Example usage */
/*
oTable.fnProcessingIndicator();      // On
oTable.fnProcessingIndicator(false); // Off
*/




$.fn.dataTableExt.oApi.fnReloadAjax = function ( oSettings, sNewSource, fnCallback, bStandingRedraw )
{
	if ( typeof sNewSource != 'undefined' && sNewSource != null )
	{
		oSettings.sAjaxSource = sNewSource;
	}
	this.oApi._fnProcessingDisplay( oSettings, true );
	var that = this;
	var iStart = oSettings._iDisplayStart;
	
	oSettings.fnServerData( oSettings.sAjaxSource, [], function(json) {
		/* Clear the old information from the table */
		that.oApi._fnClearTable( oSettings );
		
		/* Got the data - add it to the table */
		for ( var i=0 ; i<json.aaData.length ; i++ )
		{
			that.oApi._fnAddData( oSettings, json.aaData[i] );
		}
		
		oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
		that.fnDraw();
		
		if ( typeof bStandingRedraw != 'undefined' && bStandingRedraw === true )
		{
			oSettings._iDisplayStart = iStart;
			that.fnDraw( false );
		}
		
		that.oApi._fnProcessingDisplay( oSettings, false );
		
		/* Callback user function - for event handlers etc */
		if ( typeof fnCallback == 'function' && fnCallback != null )
		{
			fnCallback( oSettings );
		}
	}, oSettings );
}

/* Example call to load a new file */
/*
oTable.fnReloadAjax( 'media/examples_support/json_source2.txt' );
*/

/* Example call to reload from original file */
/*
oTable.fnReloadAjax();
*/




jQuery.fn.dataTableExt.oApi.fnSetFilteringDelay = function ( oSettings, iDelay ) {
	/*
	 * Inputs:      object:oSettings - dataTables settings object - automatically given
	 *              integer:iDelay - delay in milliseconds
	 * Usage:       $('#example').dataTable().fnSetFilteringDelay(250);
	 * Author:      Zygimantas Berziunas (www.zygimantas.com) and Allan Jardine
	 * License:     GPL v2 or BSD 3 point style
	 * Contact:     zygimantas.berziunas /AT\ hotmail.com
	 */
	var
		_that = this,
		iDelay = (typeof iDelay == 'undefined') ? 250 : iDelay;
	
	this.each( function ( i ) {
		$.fn.dataTableExt.iApiIndex = i;
		var
			$this = this, 
			oTimerId = null, 
			sPreviousSearch = null,
			anControl = $( 'input', _that.fnSettings().aanFeatures.f );
		
			anControl.unbind( 'keyup' ).bind( 'keyup', function() {
			var $$this = $this;

			if (sPreviousSearch === null || sPreviousSearch != anControl.val()) {
				window.clearTimeout(oTimerId);
				sPreviousSearch = anControl.val();	
				oTimerId = window.setTimeout(function() {
					$.fn.dataTableExt.iApiIndex = i;
					_that.fnFilter( anControl.val() );
				}, iDelay);
			}
		});
		
		return this;
	} );
	return this;
}

/* Example call */
/*
$(document).ready(function() {
	$('.dataTable').dataTable().fnSetFilteringDelay();
} );
*/
