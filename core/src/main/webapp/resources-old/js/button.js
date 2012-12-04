$(function() { 

    /* Area 51
    --------------------------------------------------------------*/  




    /* Default Button
    --------------------------------------------------------------*/  
    
    // clear button
    $( ".button, .a" ).button({
        
    });









    /* Search Form Buttons
    --------------------------------------------------------------*/  

    // clear button
    $( ".button.clear" ).button({
        icons: {
            primary: "ui-icon-closethick"
        }
    });
	

	
    // clear notification
    $( ".button.clear" ).click(function(){

    }); 	
	
	
	
    // search button
    $( ".button.search" ).button({
        icons: {
            primary: "ui-icon-search"
        }
    });        
	

	
    // search notification
    $( ".button.search" ).click(function(){

    }); 	
	
	
	
	
	
	
	
	
	
	
    /* Table Buttons
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
    });



    // copy notification
    $( ".button.copy" ).click(function(){
	
    }); 

	

    // export button
    $( ".button.export" ).button({
        icons: {
            primary: "ui-icon-document"
        }
    });



    // export notification
    $( ".button.export" ).click(function(){
	
    }); 	
	
	
	
	
	
	
	
	
	
	
    /* Creation Buttons
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
    });



    // add notification
    $( ".button.add" ).click(function(){
	
    }); 	
	
	

    // remove button
    $( ".button.remove" ).button({
        icons: {
            primary: "ui-icon-minus"
        }
    });



    // remove notification
    $( ".button.remove" ).click(function(){
		
    }); 
	
	

    // revert button
    $( ".button.revert" ).button({
        icons: {
            primary: "ui-icon-arrowreturnthick-1-w"
        }
    });



    // revert notification
    $( ".button.revert" ).click(function(){		

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
		
    }); 

	

	
	
	
	
	
	
	
    /* Data Lock Buttons
    --------------------------------------------------------------*/  
    // unlocked button
    $( ".button.unlocked" ).button({
        icons: {
            primary: "ui-icon-unlocked"
        }
    });

	
	
    // unlocked notification
    $( ".button.unlocked" ).click(function(){
		
    }); 


	
    // locked button
    $( ".button.locked" ).button({
        icons: {
            primary: "ui-icon-locked"
        }
    });

	
	
    // locked notification
    $( ".button.locked" ).click(function(){
		
    }); 
	
	
	
    // unlocked-locked button
    $( ".buttonset.unlocked-locked" ).buttonset();
    $( ".buttonset.unlocked-locked .button.unlocked" ).button( "option", "text", false );
    $( ".buttonset.unlocked-locked .button.locked" ).button( "option", "text", false );



});