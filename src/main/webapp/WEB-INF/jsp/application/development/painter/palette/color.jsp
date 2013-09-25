<!DOCTYPE html>
<html>

    <head>

        <jsp:include page="/WEB-INF/jsp/common/include.jsp" />

        <!-- Page specific css -->
        <style type="text/css">

            span.data.static-text {
                border: 1px solid #aaa;
            }



            /* Text */
            span.data.static-text.disabled {
                color: #aaa;
            }

            span.data.static-text.information {
                color: #33b;
            }

            span.data.static-text.ok {
                color: #3b3;
            }

            span.data.static-text.error {
                color: #b33;
            }



            /* Table Backgound */
            span.data.static-text.even-row {
                background-color: #fff;
            }

            span.data.static-text.odd-row {
                background-color: #eee;
            }

            span.data.static-text.update-row {
                background-color: #cce;
            }

            span.data.static-text.add-row {
                background-color: #cec;
            }

            span.data.static-text.remove-row {
                background-color: #ecc;
            }

            span.data.static-text.updated-row {
                background-color: #88e;
            }

            span.data.static-text.added-row {
                background-color: #8e8;
            }

            span.data.static-text.removed-row {
                background-color: #e88;
            }

        </style>

        <!-- Page specific javascript -->
        <script type="text/javascript">

            $(function() {

            });

        </script>

    </head>

    <body class="body">
        <h1 class="body-header">Color Palette</h1>    
        <div class="body-content"> 

            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Text</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>disabled</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text disabled">disabled</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>information</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text information">information</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>ok</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text ok">ok</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>error</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text error">error</span>                    
                            </div>              
                        </div>

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->

            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Table Background</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>even-row</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text even-row">even row</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>odd-row</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text odd-row">odd row</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>update-row</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text update-row">update row</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>add-row</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text add-row">add row</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>remove-row</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text remove-row">remove row</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>updated-row</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text updated-row">updated row</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>added-row</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text added-row">added row</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>removed-row</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text removed-row">removed row</span>                    
                            </div>              
                        </div>

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->

            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Greyscale</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>color-black</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text black">black</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>color-grey-dark</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text color-grey-dark">grey dark</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>color-grey</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text color-grey">grey</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>color-grey-light</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text color-grey-light">grey light</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>color-white</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text color-white">white</span>                    
                            </div>              
                        </div>	

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->

            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Colorscale</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>color-red</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text color-red">red</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>color-orange</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text color-orange">orange</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>color-yellow</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text color-yellow">yellow</span>                    
                            </div>              
                        </div>		

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>color-green</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text color-green">green</span>                    
                            </div>              
                        </div>

                        <div class="labeled-content"> 
                            <div class="label">
                                <label>color-blue</label> 
                            </div>              
                            <div class="content">
                                <span class="data static-text color-blue">blue</span>                    
                            </div>              
                        </div>	

                    </div><!-- Column -->  

                </div> 
            </div><!-- Group --> 

            <!-- Group -->
            <div class="group">
                <h3 class="group-header">Test Area</h3>  
                <div class="group-content">   

                    <!-- Column -->
                    <div class="column">



                    </div><!-- Column -->  

                </div> 
            </div><!-- Group -->

        </div>
    </body>

</html>
