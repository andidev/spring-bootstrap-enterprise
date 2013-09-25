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
        <h1 class="body-header">Painter Editor</h1>    
        <div class="body-content"> 

            <form>

                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">Simple Inputs</h3>  
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Text Static</label> 
                                </div>              
                                <div class="content">
                                    <span class="data static-text">VALUE</span>                     
                                </div>              
                            </div>  

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Text</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text" name="TEXT_ID" value="VALUE" />                    
                                </div>              
                            </div>

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Text Autocomplete</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text-autocomplete" name="TEXTAUTOCOMPLETE_ID" value="VALUE" />                    
                                </div>           
                            </div> 

                            <div class="labeled-content">
                                <div class="label">
                                    <label>Select</label> 
                                </div>              
                                <div class="content">
                                    <select class="data select" name="SELECT_ID"> 
                                        <option>OPTIONS</option>
                                    </select> 
                                </div>              
                            </div>                      

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Select Autocomplete</label> 
                                </div>              
                                <div class="content">
                                    <select class="data select-autocomplete" name="SELECTAUTOCOMPLETE_ID"> 
                                        <option>OPTIONS</option>
                                    </select> 
                                </div>              
                            </div>   

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Range</label> 
                                </div>              
                                <div class="content">
                                    <input class="data range" name="RANGE_ID" type="range" />
                                </div> 
                            </div>                       

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Checkbox</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data checkbox">
                                        <li>
                                            <input class="data checkbox" id="CHECKBOX_ID-VALUE_1" name="CHECKBOX_ID-VALUE_1" type="checkbox" checked="checked" /><label for="CHECKBOX_ID-VALUE_1">VALUE_1</label>
                                        </li>
                                        <li>
                                            <input class="data checkbox" id="CHECKBOX_ID-VALUE_2" name="CHECKBOX_ID-VALUE_2" type="checkbox" checked="checked" /><label for="CHECKBOX_ID-VALUE_2">VALUE_2</label>
                                        </li>
                                        <li>
                                            <input class="data checkbox" id="CHECKBOX_ID-VALUE_ETC" name="CHECKBOX_ID-VALUE_ETC" type="checkbox" /><label for="CHECKBOX_ID-VALUE_ETC">VALUE_ETC</label>
                                        </li>
                                    </ul>
                                </div> 
                            </div>                     

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Radio</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data radio">
                                        <li>
                                            <input class="data radio" id="RADIO_ID-OPTION_1" name="RADIO_ID" type="radio" value="OPTION_1_VALUE" checked="checked" /><label for="RADIO_ID-OPTION_1">OPTION_1</label>
                                        </li>
                                        <li>
                                            <input class="data radio" id="RADIO_ID-OPTION_2" name="RADIO_ID" type="radio" value="OPTION_2_VALUE" /><label for="RADIO_ID-OPTION_2">OPTION_2</label>
                                        </li>
                                        <li>
                                            <input class="data radio" id="RADIO_ID-OPTION_ETC" name="RADIO_ID" type="radio" value="OPTION_ETC_VALUE" /><label for="RADIO_ID-OPTION_ETC">OPTION_ETC</label> 
                                        </li>
                                    </ul> 
                                </div> 
                            </div>                                    

                        </div><!-- Column -->  

                    </div> 
                </div><!-- Group -->   



                <div class="group">
                    <h3 class="group-header">Numbers</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Digits</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text digits" id="DIGITS_ID-value" name="DIGITS_ID" />                    
                                </div>               
                            </div>               

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Number</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text number" id="NUMBER_ID-value" name="NUMBER_ID" />                    
                                </div>              
                            </div>                          

                        </div>

                    </div>
                </div>     



                <div class="group">
                    <h3 class="group-header">Decisions</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Yes/No</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data radio yes-no">
                                        <li>
                                            <input class="data radio yes" id="RADIOYESNO_ID-yes" name="RADIOYESNO_ID" type="radio" checked="checked" /><label for="RADIOYESNO_ID-yes">Yes</label>
                                        </li>
                                        <li>
                                            <input class="data radio no" id="RADIOYESNO_ID-no" name="RADIOYESNO_ID" type="radio" /><label for="RADIOYESNO_ID-no">No</label>    
                                        </li>
                                    </ul>
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>On/Off</label> 
                                </div>              
                                <div class="content">                  
                                    <ul class="data radio on-off">
                                        <li>
                                            <input class="data radio on" id="RADIOONOFF_ID-on" name="RADIOONOFF_ID" type="radio" checked="checked" /><label for="RADIOONOFF_ID-on">On</label>
                                        </li>
                                        <li>
                                            <input class="data radio off" id="RADIOONOFF_ID-off" name="RADIOONOFF_ID" type="radio" /><label for="RADIOONOFF_ID-off">Off</label>                  
                                        </li>
                                    </ul>
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Enabled/Disabled</label> 
                                </div>              
                                <div class="content">    
                                    <ul class="data radio enabled-disabled">
                                        <li>
                                            <input class="data radio enabled" id="RADIOENABLEDDISABLED_ID_ENABLED" name="RADIOENABLEDDISABLED_ID" type="radio" checked="checked" /><label for="RADIOENABLEDDISABLED_ID_ENABLED">Enabled</label>
                                        </li>
                                        <li>
                                            <input class="data radio disabled" id="RADIOENABLEDDISABLED_ID_DISABLED" name="RADIOENABLEDDISABLED_ID" type="radio" /><label for="RADIOENABLEDDISABLED_ID_DISABLED">Disabled</label>                  
                                        </li>
                                    </ul>							
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Both</label> 
                                </div>              
                                <div class="content">     
                                    <ul class="data radio both">
                                        <li>
                                            <input class="data radio both" id="RADIOBOTH_ID_BOTH" name="RADIOBOTH_ID" type="radio" checked="checked" /><label for="RADIOBOTH_ID_BOTH">Both</label>
                                        </li>
                                        <li>
                                            <input class="data radio both" id="RADIOBOTH_ID_OPTION_1" name="RADIOBOTH_ID" type="radio" /><label for="RADIOBOTH_ID_OPTION_1">Option 1</label>
                                        </li>
                                        <li>
                                            <input class="data radio both" id="RADIOBOTH_ID_OPTION_2" name="RADIOBOTH_ID" type="radio" /><label for="RADIOBOTH_ID_OPTION_2">Option 2</label>   
                                        </li>
                                    </ul>							
                                </div>              
                            </div>             

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>All</label> 
                                </div>              
                                <div class="content">  
                                    <ul class="data radio all">
                                        <li>
                                            <input class="data radio all" id="RADIOALL_ID_ALL" name="RADIOALL_ID" type="radio" checked="checked" /><label for="RADIOALL_ID_ALL">All</label>
                                        </li>
                                        <li>
                                            <input class="data radio all" id="RADIOALL_ID_OPTION_1" name="RADIOALL_ID" type="radio" /><label for="RADIOALL_ID_OPTION_1">Option 1</label>                  
                                        </li>
                                        <li>
                                            <input class="data radio all" id="RADIOALL_ID_OPTION_2" name="RADIOALL_ID" type="radio" /><label for="RADIOALL_ID_OPTION_2">Option 2</label>                  
                                        </li>
                                        <li>
                                            <input class="data radio all" id="RADIOALL_ID_OPTION_ETC" name="RADIOALL_ID" type="radio" /><label for="RADIOALL_ID_OPTION_ETC">Option etc</label>                         
                                        </li>
                                    </ul>														
                                </div>              
                            </div>

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Enabled</label> 
                                </div>              
                                <div class="content">                  
                                    <ul class="data checkbox enable">
                                        <li>
                                            <input class="data checkbox enable" id="CHECKBOXENABLED_ID" name="CHECKBOXENABLED_ID" type="checkbox" checked="checked" /><label for="CHECKBOXENABLED_ID">Enabled</label>
                                        </li>
                                    </ul>							
                                </div>              
                            </div>          

                        </div>  

                    </div>
                </div>                     



                <div class="group">
                    <h3 class="group-header">Time Related</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Minutes</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text digits minutes">
                                        <li>
                                            <input class="data text digits minutes" id="MINUTES_ID-value" name="MINUTES_ID-value" value="45" />   
                                        </li>
                                        <li>
                                            minutes
                                        </li>
                                    </ul>
                                </div>              
                            </div>                         

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Hours</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text digits hours">
                                        <li>
                                            <input class="data text digits hours" id="HOURS_ID-value" name="HOURS_ID-value" value="2" />  
                                        </li>
                                        <li>
                                            hours
                                        </li>
                                    </ul>							
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Hours Minutes</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text digits hours-minutes">
                                        <li>
                                            <input class="data text digits hours" id="HOURSMINUTES_HOURS_ID-value" name="HOURSMINUTES_HOURS_ID-value" value="2" /> hours                    
                                        </li>
                                        <li>
                                            <input class="data text digits minutes" id="HOURSMINUTES_MINUTES_ID-value" name="HOURSMINUTES_MINUTES_ID-value" value="45" /> minutes                   
                                        </li>
                                    </ul>
                                </div>              
                            </div>                        

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Days</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text digits days">
                                        <li>
                                            <input class="data text digits days" id="DAYS_ID-value" name="DAYS_ID-value" value="12" />
                                        </li>
                                        <li>
                                            days
                                        </li>
                                    </ul>							             
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Days Hours Minutes</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text digits days-hours-minutes">
                                        <li>
                                            <input class="data text digits days" id="DAYSHOURSMINUTES_DAYS_ID-value" name="DAYSHOURSMINUTES_DAYS_ID-value" value="12" /> days                                    
                                        </li>
                                        <li>
                                            <input class="data text digits hours" id="DAYSHOURSMINUTES_HOURS_ID-value" name="DAYSHOURSMINUTES_HOURS_ID-value" value="2" /> hours                    
                                        </li>
                                        <li>
                                            <input class="data text digits minutes" id="DAYSHOURSMINUTES_MINUTES_ID-value" name="DAYSHOURSMINUTES_MINUTES_ID-value" value="45" /> minutes                   
                                        </li>									
                                    </ul>
                                </div>              
                            </div>                             

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Time</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text time" id="TIME_ID-value" name="TIME_ID-value" value="08:00" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Time Range</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text time range">
                                        <li>
                                            <input class="data text time range from" id="TIMERANGE_ID-from-value" name="TIMERANGE_ID-from-value" value="08:00" />                  
                                        </li>
                                        <li>
                                            -                   
                                        </li>							
                                        <li>
                                            <input class="data text time range to" id="TIMERANGE_ID-to-value" name="TIMERANGE_ID-to-value" value="17:00" />       
                                        </li>
                                    </ul>
                                </div>              
                            </div>                       

                        </div>  

                    </div>
                </div>     



                <div class="group">
                    <h3 class="group-header">Date Related</h3>   
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Week</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text digits week" id="WEEK_ID-value" name="WEEK_ID-value" value="52" />                    
                                </div>              
                            </div>                     

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Week Range</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text digits week range">
                                        <li>
                                            <input class="data text digits week range from" id="WEEKRANGE_ID-from-value" name="WEEKRANGE_ID-from-value" value="4" />                 
                                        </li>
                                        <li>
                                            -                   
                                        </li>							
                                        <li>
                                            <input class="data text digits week range to" id="WEEKRANGE_ID-to-value" name="WEEKRANGE_ID-to-value" value="52" />                    
                                        </li>
                                    </ul>
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Date</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text date" id="DATE_ID-value" name="DATE_ID-value" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Date Range</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text date-range" id="DATERANGE_ID-from-value" name="DATERANGE_ID-from-value" />
                                </div>      
                            </div>             

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Date Time</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text date-time" id="DATETIME_ID-value" name="DATETIME_ID-value" />                    
                                </div>            
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Date Time Range</label> 
                                </div>              
                                <div class="content">  
                                    <ul class="data date-time range">
                                        <li>
                                            <input class="data text date-time range from" id="DATETIMERANGE_ID-from-value" name="DATETIMERANGE_ID-from-value" />                    
                                        </li>
                                        <li>
                                            -
                                        </li>
                                        <li>
                                            <input class="data text date-time range to" id="DATETIMERANGE_ID-to-value" name="DATETIMERANGE_ID-to-value" />                         
                                        </li>
                                    </ul>								
                                </div>                
                            </div>                          

                        </div>  

                    </div>
                </div>          



                <div class="group">
                    <h3 class="group-header">Units</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Distance</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text digits distance" id="DISTANCE_ID-value" name="DISTANCE_ID-value" />                    
                                </div>              
                            </div>                

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Distance Range</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text digits distance range">
                                        <li>
                                            <input class="data text digits distance range from" id="DISTANCERANGE_ID-from-value" name="DISTANCERANGE_ID-from-value" />                    
                                        </li>
                                        <li>
                                            -
                                        </li>									
                                        <li>
                                            <input class="data text digits distance range to" id="DISTANCERANGE_ID-to-value" name="DISTANCERANGE_ID-to-value" />                         
                                        </li>
                                    </ul>
                                </div>                
                            </div>       

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Weight</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text number weight" id="WEIGHT_ID-value" name="WEIGHT_ID-value" />                    
                                </div>              
                            </div>         

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Weight Range</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text number weight range">
                                        <li>
                                            <input class="data text number weight range from" id="WEIGHTRANGE_ID-from-value" name="WEIGHTRANGE_ID-from-value" />                    
                                        </li>
                                        <li>
                                            -
                                        </li>									
                                        <li>
                                            <input class="data text number weight range to" id="WEIGHTRANGE_ID-to-value" name="WEIGHTRANGE_ID-to-value" />                         
                                        </li>
                                    </ul>							
                                </div>                
                            </div>   

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Volume</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text number volume" id="VOLUME_ID-value" name="VOLUME_ID-value" />                    
                                </div>

                            </div>

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Volume Range</label> 
                                </div>              
                                <div class="content">  
                                    <ul class="data text number volume range">
                                        <li>
                                            <input class="data text number volume range from" id="VOLUMERANGE_ID-from-value" name="VOLUMERANGE_ID-from-value" />                    
                                        </li>
                                        <li>
                                            -
                                        </li>									
                                        <li>
                                            <input class="data text number volume range to" id="VOLUMERANGE_ID-to-value" name="VOLUMERANGE_ID-to-value" />                         
                                        </li>
                                    </ul>
                                </div>                
                            </div>                         

                        </div>  

                    </div>
                </div>                      



                <div class="group">
                    <h3 class="group-header">Locale and Address Related</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Street</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text-autocomplete street" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>City</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text-autocomplete city" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Zip</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text-autocomplete zip" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content">
                                <div class="label">
                                    <label>Country</label> 
                                </div>              
                                <div class="content">
                                    <select class="data select language" name="SELECT_ID"> 
                                        <option>COUNTRY</option>
                                    </select> 								
                                </div>            
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Address</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text address">
                                        <li>
                                            <input class="data text address row-1" />                    
                                        </li>
                                        <li>
                                            <input class="data text address row-2" />
                                        </li>
                                        <li>
                                            <input class="data text address row-3" /> 
                                        </li>
                                    </ul>
                                </div>              
                            </div>  

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Language</label> 
                                </div>              
                                <div class="content">                
                                    <select class="data select language" name="SELECT_ID"> 
                                        <option>LANGUAGE</option>
                                    </select> 							                 
                                </div>              
                            </div>                     

                        </div>  

                    </div>
                </div>           



                <div class="group">
                    <h3 class="group-header">Contact</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Phone</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text phone" />                                         
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Mobile</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text mobile" />                                         
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Fax</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text fax" />                                         
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>E-mail</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text email" />                                         
                                </div>              
                            </div>                

                        </div>  

                    </div>
                </div>           



                <div class="group">
                    <h3 class="group-header">Customer Related</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Customer</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text customer" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Usename</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text username" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Password</label> 
                                </div>              
                                <div class="content"> 
                                    <input class="data text password" />                    
                                </div>              
                            </div>                         

                        </div> 

                    </div>

                </div>   



                <div class="group">
                    <h3 class="group-header">Carrier</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Carrier</label> 
                                </div>              
                                <div class="content">
                                    <select class="data select-autocomplete carrier" name="SELECT_ID"> 
                                        <option>CARRIER</option>
                                    </select> 
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Transport Product</label> 
                                </div>              
                                <div class="content">   
                                    <select class="data select-autocomplete transportproduct" name="SELECT_ID"> 
                                        <option>TRANSPORT_PRODUCT</option>
                                    </select> 							
                                </div>              
                            </div>                         

                        </div>

                    </div>
                </div> 



                <div class="group">
                    <h3 class="group-header">Other</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Node</label> 
                                </div>              
                                <div class="content">                  
                                    <select class="data select-autocomplete node" name="SELECT_ID"> 
                                        <option>NODE</option>
                                    </select> 
                                </div>              
                            </div>          

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Transport Mode</label> 
                                </div>              
                                <div class="content">                  
                                    <select class="data select-autocomplete transportmode" name="SELECT_ID"> 
                                        <option>TRANSPORT_MODE</option>
                                    </select>              
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Package</label> 
                                </div>              
                                <div class="content">                  
                                    <ul class="data custom package inline">
                                        <li>
                                            <input class="data text digits required" id="package-number" name="package-number" placeholder="Package Number"/>      
                                        </li>
                                        <li>
                                            <input class="data text number weight required" id="package-weight" name="package-weight" placeholder="Weight" />   
                                        </li>
                                        <li>
                                            <input class="data text number volume required" id="package-volume" name="package-volume" placeholder="Volume" />   								
                                        </li>
                                    </ul>
                                </div>              
                            </div>							


                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Test Validation</label> 
                                </div>              
                                <div class="content">                  
                                    <button class="button">Validate</button>
                                </div>              
                            </div>	



                        </div>


                    </div>
                </div>    

            </form>

        </div>
    </body>

</html>
