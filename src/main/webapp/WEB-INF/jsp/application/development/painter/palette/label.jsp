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
        <h1 class="body-header">Form Data Palette</h1>    
        <div class="body-content"> 

            <form>

                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">Label Alignment</h3>  
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content align-left"> 
                                <div class="label">
                                    <label>align-left (default)</label> 
                                </div>              
                                <div class="content">
                                    <span class="data static-text" id="STATIC_TEXT_ID">VALUE</span>   
                                </div>              
                            </div>

                            <div class="labeled-content align-right"> 
                                <div class="label">
                                    <label>align-right</label> 
                                </div>              
                                <div class="content">
                                    <span class="data static-text" id="STATIC_TEXT_ID">VALUE</span>   
                                </div>              
                            </div>

                            <div class="labeled-content align-new-line"> 
                                <div class="label">
                                    <label>align-new-line</label> 
                                </div>              
                                <div class="content">
                                    <span class="data static-text" id="STATIC_TEXT_ID">VALUE</span>   
                                </div>              
                            </div>

                        </div><!-- Column -->  

                    </div> 
                </div><!-- Group -->

                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">Align Left on Column (default)</h3>  
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column align-left">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>First Name</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text firstname" id="firstname" name="firstname" />                                         
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Last Name</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text lastname" id="lastname" name="lastname" />                                         
                                </div>              
                            </div>   
                            
                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Street</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text-autocomplete street" id="street" name="street" />                    
                                </div>              
                            </div> 

                        </div><!-- Column -->  

                    </div> 
                </div><!-- Group -->

                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">Align Right on Column</h3>  
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column align-right">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>First Name</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text firstname" id="firstname" name="firstname" />                                         
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Last Name</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text lastname" id="lastname" name="lastname" />                                         
                                </div>              
                            </div>   
                            
                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Street</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text-autocomplete street" id="street" name="street" />                    
                                </div>              
                            </div> 

                        </div><!-- Column -->  

                    </div> 
                </div><!-- Group -->

                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">Align New Line on Column</h3>  
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column align-new-line">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Customer</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text customer" id="customer" name="customer" />                    
                                </div>              
                            </div> 
                                
                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Username</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text username" id="username" name="username" />                    
                                </div>              
                            </div> 
                                
                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Password</label> 
                                </div>              
                                <div class="content"> 
                                    <input class="data text password" id="password" name="password" />                    
                                </div>              
                            </div> 

                        </div><!-- Column -->  

                    </div> 
                </div><!-- Group -->

            </form>

        </div>
    </body>

</html>
