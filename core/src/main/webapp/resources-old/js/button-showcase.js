$(function() { 
$(function() { 

    /* Area 51
    --------------------------------------------------------------*/  




    /* Apply Plugins - Search Form Buttons
    --------------------------------------------------------------*/
    
    // clear button
    $( ".button.clear" ).button({
        icons: {
            primary: "ui-icon-closethick"
        }
    })
	

	
    // clear notification
    $( ".button.clear" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class='ui-icon ui-icon-check' />Cleared Form!").fadeIn("slow").delay(500).fadeOut("slow");

    }); 	
	
	
	
    // search button
    $( ".button.search" ).button({
        icons: {
            primary: "ui-icon-search"
        }
    });        
	

	
    // search notification
    $( ".button.search" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class=\'preloader\' />Searching...").fadeIn("slow", function(){
			setTimeout ( '$("#notification-field").writeError("<span class=\'ui-icon ui-icon-check\' />Search Successfull!").delay(500).fadeOut("slow");', 1000 );
		});

    }); 
	
	
	
	
	
	
	

    /* Apply Plugins - Table Buttons
    --------------------------------------------------------------*/ 
    
	// edit button
    $( ".button.edit" ).button({
        icons: {
            primary: "ui-icon-pencil"
        }
    });        	


	
    // copy button
    $( ".button.copy" ).button({
        icons: {
            primary: "ui-icon-clipboard"
        }
    })



    // copy notification
    $( ".button.copy" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class='ui-icon ui-icon-clipboard' />Copied Data to Clipboard").fadeIn("slow").delay(500).fadeOut("slow");

    }); 

	

    // export button
    $( ".button.export" ).button({
        icons: {
            primary: "ui-icon-document"
        }
    })



    // export notification
    $( ".button.export" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class='ui-icon ui-icon-check' />Exported Data Successfully!").fadeIn("slow").delay(500).fadeOut("slow");

    }); 	
	
	
	
	
	
	
	
	
	
	
    /* Apply Plugins - Creation Buttons
    --------------------------------------------------------------*/  
    
	// edit button
    $( ".button.edit" ).button({
        icons: {
            primary: "ui-icon-pencil"
        }
    });                 


	
    // add button
    $( ".button.add" ).button({
        icons: {
            primary: "ui-icon-plus"
        }
    })



    // add notification
    $( ".button.add" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class='ui-icon ui-icon-check' />Added Data Successfully!").fadeIn("slow").delay(500).fadeOut("slow");

    }); 	
	
	

    // remove button
    $( ".button.remove" ).button({
        icons: {
            primary: "ui-icon-minus"
        }
    })



    // remove notification
    $( ".button.remove" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class='ui-icon ui-icon-check' />Removed Data Successfully!").fadeIn("slow").delay(500).fadeOut("slow");

    }); 
    
    
	
	
	
	
	
	
	
	
    /* Confirm Edit Buttons
    --------------------------------------------------------------*/  
	
    // confirm cancel
    $( ".button.cancel" ).button({
        icons: {
            primary: "ui-icon-closethick"
        }
    });        


    
    // confirm create
    $( ".button.create" ).button({
        icons: {
            primary: "ui-icon-check"
        }
    });
	

	
    // create notification
    $( ".button.create" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class='ui-icon ui-icon-check' />Created Data Successfully!").fadeIn("slow").delay(500).fadeOut("slow");

    }); 	
	
    
    
	
	
	
	
	
	
	
    /* Confirm Add Buttons
    --------------------------------------------------------------*/  
	
    // confirm cancel
    $( ".button.cancel" ).button({
        icons: {
            primary: "ui-icon-closethick"
        }
    });    
	
	
	
    // confirm save
    $( ".button.save" ).button({
        icons: {
            primary: "ui-icon-check"
        }
    });   
	

	
    // save notification
    $( ".button.save" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class='ui-icon ui-icon-check' />Saved Data Successfully!").fadeIn("slow").delay(500).fadeOut("slow");

    });              
    
    
    
	
	
	
	
	
	
	
    /* Confirm Remove Buttons
    --------------------------------------------------------------*/  
	
    // confirm cancel
    $( ".button.cancel" ).button({
        icons: {
            primary: "ui-icon-closethick"
        }
    });    
	
	
	
    // confirm delete
	$( ".button.delete" ).button({
        icons: {
            primary: "ui-icon-trash"
        }
    }); 
	

	
    // delete notification
    $( ".button.delete" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class='ui-icon ui-icon-trash' />Deleted Data Successfully!").fadeIn("slow").delay(500).fadeOut("slow");

    }); 

	

	
	
	
	
	
	
	
    /* Data Lock Buttons
    --------------------------------------------------------------*/  
    // unlocked button
    $( ".button.unlocked" ).button({
        icons: {
            primary: "ui-icon-unlocked"
        }
    })

	
	
    // unlocked notification
    $( ".button.unlocked" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class='ui-icon ui-icon-unlocked' />Unlocked Data!").fadeIn("slow").delay(500).fadeOut("slow");

    }); 


	
    // locked button
    $( ".button.locked" ).button({
        icons: {
            primary: "ui-icon-locked"
        }
    })

	
	
    // locked notification
    $( ".button.locked" ).click(function(){
		
		$("#notification-field").stop(true, true).writeAlert("<span class='ui-icon ui-icon-locked' />Locked Data!").fadeIn("slow").delay(500).fadeOut("slow");

    }); 
	
	
	
    // unlocked-locked button
	$( ".buttonset.unlocked-locked" ).buttonset();
	$( ".buttonset.unlocked-locked .button.unlocked" ).button( "option", "text", false );
	$( ".buttonset.unlocked-locked .button.locked" ).button( "option", "text", false );



});