$(function() { 

    /* Area 51
    --------------------------------------------------------------*/  




    /* Apply Plugins
    --------------------------------------------------------------*/  
 
    /* WORKAROUND: 100% width */
    // initial load of page
    $(document).ready(resizeEqualWidth);
    // assign largest width
    function resizeEqualWidth() {
        $(".hover-menu > li.menu-item > a").equalWidths();
    }
    
    

});