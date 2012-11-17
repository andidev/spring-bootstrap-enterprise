<!DOCTYPE html>
<html>

    <head>

        <jsp:include page="/WEB-INF/jsp/common/include.jsp" />

        <!-- Page specific css -->
        <style type="text/css">



        </style>

        <!-- Page specific javascript -->
        <script type="text/javascript">

            $(function() {

            });

        </script>

    </head>

    <body class="body">
        <h1 class="body-header">Button Palette</h1>    
        <div class="body-content"> 



            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Search Form Buttons</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div>
                            <button class="button clear">Clear</button>
                            <div class="button search">Search</div>
                        </div>             

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->              



            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Table Buttons</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div>
                            <button class="button edit">Edit</button>
                            <button class="button copy">Copy</button>
                            <button class="button export">Export</button>
                        </div>              

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->  				



            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Creation Buttons</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div>
                            <button class="button edit">Edit</button>
                            <button class="button add">Add</button>
                            <button class="button remove">Remove</button>
                        </div>              

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->              



            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Confirm Edit Buttons</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div>
                            <button class="button confirm cancel">Cancel</button>
                            <button class="button confirm save">Save</button>
                        </div>              

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->    



            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Confirm Add Buttons</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div>
                            <button class="button confirm cancel">Cancel</button>
                            <button class="button confirm create">Create</button>
                        </div>              

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->    



            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Confirm Remove Buttons</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div>
                            <button class="button confirm cancel">Cancel</button>
                            <button class="button confirm delete">Delete</button>
                        </div>              

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->     



            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Data Lock Buttons</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div>
                            <button class="button unlocked">Unlocked</button>
                            <button class="button locked">Locked</button>									
                            <div class="buttonset unlocked-locked" id="radio">
                                <input class="button unlocked " type="radio" id="radio1" name="radio" /><label for="radio1">Unlocked</label>
                                <input class="button locked" type="radio" id="radio2" name="radio" checked="checked" /><label for="radio2">Locked</label>
                            </div>
                        </div>              

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->  



        </div>
    </body>

</html>
