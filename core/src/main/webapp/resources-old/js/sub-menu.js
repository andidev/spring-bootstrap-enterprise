$(function() { 

    /* Area 51
    --------------------------------------------------------------*/  




    /* Apply Plugins
    --------------------------------------------------------------*/  
 
    /* WORKAROUND: 100% height */
    // initial load of page
    $(document).ready(resizeWindowHeight);

    // every resize of window
    $(window).resize(resizeWindowHeight);
    
    // assign height
    $(".sub-menu").css('box-sizing', 'border-box');
    function resizeWindowHeight() {
        var newHeight = $(window).height();
        $(".sub-menu").height(newHeight);
    }
    
    

});