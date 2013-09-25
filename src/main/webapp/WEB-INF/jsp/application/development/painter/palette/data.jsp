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

                var $colorPicker = $('.body-header');
				
                /* color */
                /*
                                $colorPicker.ColorPicker({
                                        color: "#ffffff",
                                        onShow: function (colpkr) { $(colpkr).fadeIn(500); return false; },
                                        onHide: function (colpkr) { $(colpkr).fadeOut(500); return false; },
                                        onChange: function (hsb, hex, rgb) {
                                                $colorPicker.css('color', '#' + hex);
                                                l($('.group-content').css('color'));
                                        }
                                });
                 */
                /* background color */
                /*
                                $colorPicker.ColorPicker({
                                        color: "#ffffff",
                                        onShow: function (colpkr) { $(colpkr).fadeIn(500); return false; },
                                        onHide: function (colpkr) { $(colpkr).fadeOut(500); return false; },
                                        onChange: function (hsb, hex, rgb) {
                                                $colorPicker.css('background-color', '#' + hex);
                                                l($('.group-content').css('background-color'));
                                        }
                                });
                 */
                /* gradient top */
                /*
                                $colorPicker.ColorPicker({
                                        color: colorToHex($colorPicker.css('background-image').match(regExpColor)[0]),
                                        onShow: function (colpkr) { $(colpkr).fadeIn(500); return false; },
                                        onHide: function (colpkr) { $(colpkr).fadeOut(500); return false; },
                                        onChange: function (hsb, hex, rgb) {
                                                $colorPicker.css('background-image', "-webkit-linear-gradient(top, #" + hex + " 0%, " + colorToHex($colorPicker.css('background-image').match(regExpColor)[1]) + " 100%)");
                                                l($('.group-content').css('background-image'));
                                        }
                                });
                 */
                /* gradient bottom */
				
                $colorPicker.ColorPicker({
                    color: colorToHex($colorPicker.css('background-image').match(regExpColor)[1]),
                    onShow: function (colpkr) { $(colpkr).fadeIn(500); return false; },
                    onHide: function (colpkr) { $(colpkr).fadeOut(500); return false; },
                    onChange: function (hsb, hex, rgb) {
                        $colorPicker.css('background-image', "-webkit-linear-gradient(top, "+ colorToHex($colorPicker.css('background-image').match(regExpColor)[0]) + " 0%, #" + hex + " 100%)");
                        l($('.group-content').css('background-image'));
                    }
                });
				
                /* shaddow */
                /*
                                l($colorPicker.css('text-shadow'));
                                $colorPicker.ColorPicker({
                                        color: colorToHex(applyDefaultColor($colorPicker.css('text-shadow')).match(regExpColor)[0]),
                                        onShow: function (colpkr) { $(colpkr).fadeIn(500); return false; },
                                        onHide: function (colpkr) { $(colpkr).fadeOut(500); return false; },
                                        onChange: function (hsb, hex, rgb) {
                                                $colorPicker.css('text-shadow', $colorPicker.css('text-shadow').replace(regExpColor, '#' + hex));
                                                l($('.group-content').css('text-shadow'));
                                        }
                                });
                 */

            });

            function applyDefaultColor(color) {
                var DEFAULT_COLOR = '#ffffff';
                if(color == null) {
                    return DEFAULT_COLOR;
                } else {
                    return color;
                }
            };
						
            function colorToHex(color) {
                if (color.substr(0, 1) === '#') {
                    return color;
                }
                var digits = /(.*?)rgb\((\d+), (\d+), (\d+)\)/.exec(color);

                var red = parseInt(digits[2]);
                var green = parseInt(digits[3]);
                var blue = parseInt(digits[4]);

                var rgb = blue | (green << 8) | (red << 16);
                return digits[1] + '#' + rgb.toString(16);
            };
			
            regExpColor = /(#([0-9A-Fa-f]{3,6})\b)|(aqua)|(black)|(blue)|(fuchsia)|(gray)|(green)|(lime)|(maroon)|(navy)|(olive)|(orange)|(purple)|(red)|(silver)|(teal)|(white)|(yellow)|(rgb\(\s*\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\b\s*,\s*\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\b\s*,\s*\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\b\s*\))|(rgb\(\s*(\d?\d%|100%)+\s*,\s*(\d?\d%|100%)+\s*,\s*(\d?\d%|100%)+\s*\))/g;
			
        </script>

    </head>

    <body class="body">
        <h1 class="body-header">Form Data Palette</h1>    
        <div class="body-content"> 

            <form>

                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">Standard Inputs</h3>  
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Hidden Text</label> 
                                </div>              
                                <div class="content">
                                    <input class="data hidden-text" id="HIDDEN_TEXT_ID" name="HIDDEN_TEXT_ID" type="hidden" value="VALUE" />                    
                                </div>              
                            </div>

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Text Static</label> 
                                </div>              
                                <div class="content">
                                    <span class="data static-text" id="STATIC_TEXT_ID">VALUE</span>                     
                                    <!-- TODO: add hidden input so that value is submitted -->
                                </div>              
                            </div>  

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Text</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text" id="TEXT_ID" name="TEXT_ID" value="VALUE" />                    
                                </div>              
                            </div>

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Text Autocomplete</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text-autocomplete" id="TEXTAUTOCOMPLETE_ID" name="TEXTAUTOCOMPLETE_ID" value="VALUE" />                    
                                </div>           
                            </div> 

                            <div class="labeled-content">
                                <div class="label">
                                    <label>Select</label> 
                                </div>              
                                <div class="content">
                                    <select class="data select" id="SELECT_ID" name="SELECT_ID"> 
                                        <option>OPTIONS</option>
                                    </select> 
                                </div>              
                            </div>                      

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Select Autocomplete</label> 
                                </div>              
                                <div class="content">
                                    <select class="data select-autocomplete" id="SELECTAUTOCOMPLETE_ID" name="SELECTAUTOCOMPLETE_ID"> 
                                        <option>OPTIONS</option>
                                    </select> 
                                </div>              
                            </div>   

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Range</label> 
                                </div>              
                                <div class="content">
                                    <input class="data range" id="RANGE_ID" name="RANGE_ID" type="range" step="1" min="0" max="10" />
                                </div> 
                            </div>                       

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Checkbox</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data checkbox">
                                        <li>
                                            <input class="data checkbox" id="CHECKBOX_ID-VALUE_1" name="CHECKBOX_ID-VALUE_1" type="checkbox" checked="checked" />
                                            <label for="CHECKBOX_ID-VALUE_1">VALUE_1</label>
                                        </li>
                                        <li>
                                            <input class="data checkbox" id="CHECKBOX_ID-VALUE_2" name="CHECKBOX_ID-VALUE_2" type="checkbox" checked="checked" />
                                            <label for="CHECKBOX_ID-VALUE_2">VALUE_2</label>
                                        </li>
                                        <li>
                                            <input class="data checkbox" id="CHECKBOX_ID-VALUE_ETC" name="CHECKBOX_ID-VALUE_ETC" type="checkbox" />
                                            <label for="CHECKBOX_ID-VALUE_ETC">VALUE_ETC</label>
                                        </li>
                                    </ul>
                                </div> 
                            </div>                     

                            <!-- Group -->
                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Radio</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data radio">
                                        <li>
                                            <input class="data radio" id="RADIO_ID-OPTION_1" name="RADIO_ID" type="radio" value="OPTION_1_VALUE" checked="checked" />
                                            <label for="RADIO_ID-OPTION_1">OPTION_1</label>
                                        </li>
                                        <li>
                                            <input class="data radio" id="RADIO_ID-OPTION_2" name="RADIO_ID" type="radio" value="OPTION_2_VALUE" />
                                            <label for="RADIO_ID-OPTION_2">OPTION_2</label>
                                        </li>
                                        <li>
                                            <input class="data radio" id="RADIO_ID-OPTION_ETC" name="RADIO_ID" type="radio" value="OPTION_ETC_VALUE" />
                                            <label for="RADIO_ID-OPTION_ETC">OPTION_ETC</label> 
                                        </li>
                                    </ul> 
                                </div> 
                            </div>
<!--
                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Checkbox Toggle</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data checkbox-toggle">
                                        <li>
                                            <input class="data checkbox-toggle" id="CHECKBOXTOGGLE_ID" name="CHECKBOXTOGGLE_ID" type="checkbox" checked="checked" />
                                            <label for="CHECKBOXTOGGLE_ID">VALUE_1</label>
                                            <label for="CHECKBOXTOGGLE_ID">VALUE_2</label>
                                        </li>
                                    </ul>
                                </div> 
                            </div>

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Radio Toggle</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data radio-toggle">
                                        <li>
                                            <input class="data radio-toggle option-1" id="RADIOTOGGLE_ID-OPTION_1" name="RADIOTOGGLE_ID" type="radio" checked="checked" />
                                            <label for="RADIOTOGGLE_ID-OPTION_1">OPTION_1</label>
                                        </li>
                                        <li>
                                            <input class="data radio-toggle option-2" id="RADIOTOGGLE_ID-OPTION_2" name="RADIOTOGGLE_ID" type="radio" />
                                            <label for="RADIOTOGGLE_ID-OPTION_2">OPTION_2</label>    
                                        </li>
                                    </ul>
                                </div>              
                            </div>
-->
                        </div><!-- Column -->  


                    </div> 
                </div><!-- Group -->   



                <!-- Group -->
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
                                    <input class="data text digits" id="DIGITS_ID" name="DIGITS_ID" value="123" />                    
                                </div>               
                            </div>               

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Number</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text number" id="NUMBER_ID" name="NUMBER_ID" value="123.45" />                    
                                </div>              
                            </div>                          

                        </div><!-- Column -->  

                    </div>
                </div> <!-- Group -->



                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">Choice Related</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Yes No</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data radio-toggle yes-no">
                                        <li>
                                            <input class="data radio-toggle yes" id="RADIOTOGGLEYESNO_ID-yes" name="RADIOTOGGLEYESNO_ID" type="radio" checked="checked" />
                                            <label for="RADIOTOGGLEYESNO_ID-yes">Yes</label>
                                        </li>
                                        <li>
                                            <input class="data radio-toggle no" id="RADIOTOGGLEYESNO_ID-no" name="RADIOTOGGLEYESNO_ID" type="radio" />
                                            <label for="RADIOTOGGLEYESNO_ID-no">No</label>    
                                        </li>
                                    </ul>
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>On Off</label> 
                                </div>              
                                <div class="content">                  
                                    <ul class="data radio-toggle on-off">
                                        <li>
                                            <input class="data radio-toggle on" id="RADIOTOGGLEONOFF_ID-on" name="RADIOTOGGLEONOFF_ID" type="radio" checked="checked" />
                                            <label for="RADIOTOGGLEONOFF_ID-on">On</label>
                                        </li>
                                        <li>
                                            <input class="data radio-toggle off" id="RADIOTOGGLEONOFF_ID-off" name="RADIOTOGGLEONOFF_ID" type="radio" />
                                            <label for="RADIOTOGGLEONOFF_ID-off">Off</label>                  
                                        </li>
                                    </ul>
                                </div>              
                            </div>

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Enabled Disabled</label> 
                                </div>              
                                <div class="content">    
                                    <ul class="data radio-toggle enabled-disabled">
                                        <li>
                                            <input class="data radio-toggle enabled" id="RADIOTOGGLEENABLEDDISABLED_ID_ENABLED" name="RADIOTOGGLEENABLEDDISABLED_ID" type="radio" checked="checked" />
                                            <label for="RADIOTOGGLEENABLEDDISABLED_ID_ENABLED">Enabled</label>
                                        </li>
                                        <li>
                                            <input class="data radio-toggle disabled" id="RADIOTOGGLEENABLEDDISABLED_ID_DISABLED" name="RADIOTOGGLEENABLEDDISABLED_ID" type="radio" />
                                            <label for="RADIOTOGGLEENABLEDDISABLED_ID_DISABLED">Disabled</label>                  
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
                                            <input class="data radio both" id="RADIOBOTH_ID_BOTH" name="RADIOBOTH_ID" type="radio" checked="checked" />
                                            <label for="RADIOBOTH_ID_BOTH">Both</label>
                                        </li>
                                        <li>
                                            <input class="data radio both" id="RADIOBOTH_ID_OPTION_1" name="RADIOBOTH_ID" type="radio" />
                                            <label for="RADIOBOTH_ID_OPTION_1">Option 1</label>
                                        </li>
                                        <li>
                                            <input class="data radio both" id="RADIOBOTH_ID_OPTION_2" name="RADIOBOTH_ID" type="radio" />
                                            <label for="RADIOBOTH_ID_OPTION_2">Option 2</label>   
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
                                            <input class="data radio all" id="RADIOALL_ID_ALL" name="RADIOALL_ID" type="radio" checked="checked" />
                                            <label for="RADIOALL_ID_ALL">All</label>
                                        </li>
                                        <li>
                                            <input class="data radio all" id="RADIOALL_ID_OPTION_1" name="RADIOALL_ID" type="radio" />
                                            <label for="RADIOALL_ID_OPTION_1">Option 1</label>                  
                                        </li>
                                        <li>
                                            <input class="data radio all" id="RADIOALL_ID_OPTION_2" name="RADIOALL_ID" type="radio" />
                                            <label for="RADIOALL_ID_OPTION_2">Option 2</label>                  
                                        </li>
                                        <li>
                                            <input class="data radio all" id="RADIOALL_ID_OPTION_ETC" name="RADIOALL_ID" type="radio" />
                                            <label for="RADIOALL_ID_OPTION_ETC">Option etc</label>                         
                                        </li>
                                    </ul>														
                                </div>              
                            </div>          

                        </div><!-- Column -->    

                    </div>
                </div><!-- Group -->                    



                <!-- Group -->
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
                                            <input class="data text digits minutes" id="MINUTES_ID" name="MINUTES_ID" value="45" />   
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
                                            <input class="data text digits hours" id="HOURS_ID" name="HOURS_ID" value="2" />  
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
                                            <input class="data text digits hours" id="HOURSMINUTES_HOURS_ID" name="HOURSMINUTES_HOURS_ID" value="2" /> hours                    
                                        </li>
                                        <li>
                                            <input class="data text digits minutes" id="HOURSMINUTES_MINUTES_ID" name="HOURSMINUTES_MINUTES_ID" value="45" /> minutes                   
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
                                            <input class="data text digits days" id="DAYS_ID" name="DAYS_ID" value="12" />
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
                                            <input class="data text digits days" id="DAYSHOURSMINUTES_DAYS_ID" name="DAYSHOURSMINUTES_DAYS_ID" value="12" /> days                                    
                                        </li>
                                        <li>
                                            <input class="data text digits hours" id="DAYSHOURSMINUTES_HOURS_ID" name="DAYSHOURSMINUTES_HOURS_ID" value="2" /> hours                    
                                        </li>
                                        <li>
                                            <input class="data text digits minutes" id="DAYSHOURSMINUTES_MINUTES_ID" name="DAYSHOURSMINUTES_MINUTES_ID" value="45" /> minutes                   
                                        </li>									
                                    </ul>
                                </div>              
                            </div>                             

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Time</label> 
                                </div>              
                                <div class="content">
                                    <input class="data text time" id="TIME_ID" name="TIME_ID" value="08:00" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Time Range</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text time range">
                                        <li>
                                            <input class="data text time range from" id="TIMERANGE_ID-from" name="TIMERANGE_ID-from" value="08:00" />                  
                                        </li>
                                        <li>
                                            -                   
                                        </li>							
                                        <li>
                                            <input class="data text time range to" id="TIMERANGE_ID-to" name="TIMERANGE_ID-to" value="17:00" />       
                                        </li>
                                    </ul>
                                </div>              
                            </div>                       

                        </div> <!-- Column -->   

                    </div>
                </div> <!-- Group -->    



                <!-- Group -->
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
                                    <input class="data text digits week" id="WEEK_ID" name="WEEK_ID" value="52" />                    
                                </div>              
                            </div>                     

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Week Range</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text digits week range">
                                        <li>
                                            <input class="data text digits week range from" id="WEEKRANGE_ID-from" name="WEEKRANGE_ID-from" value="4" />                 
                                        </li>
                                        <li>
                                            -                   
                                        </li>							
                                        <li>
                                            <input class="data text digits week range to" id="WEEKRANGE_ID-to" name="WEEKRANGE_ID-to" value="52" />                    
                                        </li>
                                    </ul>
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Date</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text date" id="DATE_ID" name="DATE_ID" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Date Range</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text date-range" id="DATERANGE_ID" name="DATERANGE_ID" />
                                </div>      
                            </div>             

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Date Time</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text date-time" id="DATETIME_ID" name="DATETIME_ID" />                    
                                </div>            
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Date Time Range</label> 
                                </div>              
                                <div class="content">  
                                    <ul class="data date-time range">
                                        <li>
                                            <input class="data text date-time range from" id="DATETIMERANGE_ID-from" name="DATETIMERANGE_ID-from" />                    
                                        </li>
                                        <li>
                                            -
                                        </li>
                                        <li>
                                            <input class="data text date-time range to" id="DATETIMERANGE_ID-to" name="DATETIMERANGE_ID-to" />                         
                                        </li>
                                    </ul>								
                                </div>                
                            </div>                          

                        </div><!-- Column -->    

                    </div>
                </div> <!-- Group -->          



                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">Unit Related</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Distance</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text digits distance" id="DISTANCE_ID" name="DISTANCE_ID" />                    
                                </div>              
                            </div>                

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Distance Range</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text digits distance range">
                                        <li>
                                            <input class="data text digits distance range from" id="DISTANCERANGE_ID-from" name="DISTANCERANGE_ID-from" />                    
                                        </li>
                                        <li>
                                            -
                                        </li>									
                                        <li>
                                            <input class="data text digits distance range to" id="DISTANCERANGE_ID-to" name="DISTANCERANGE_ID-to" />                         
                                        </li>
                                    </ul>
                                </div>                
                            </div>       

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Weight</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text number weight" id="WEIGHT_ID" name="WEIGHT_ID" />                    
                                </div>              
                            </div>         

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Weight Range</label> 
                                </div>              
                                <div class="content">
                                    <ul class="data text number weight range">
                                        <li>
                                            <input class="data text number weight range from" id="WEIGHTRANGE_ID-from" name="WEIGHTRANGE_ID-from" />                    
                                        </li>
                                        <li>
                                            -
                                        </li>									
                                        <li>
                                            <input class="data text number weight range to" id="WEIGHTRANGE_ID-to" name="WEIGHTRANGE_ID-to" />                         
                                        </li>
                                    </ul>							
                                </div>                
                            </div>   

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Volume</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text number volume" id="VOLUME_ID" name="VOLUME_ID" />                    
                                </div>

                            </div>

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Volume Range</label> 
                                </div>              
                                <div class="content">  
                                    <ul class="data text number volume range">
                                        <li>
                                            <input class="data text number volume range from" id="VOLUMERANGE_ID-from" name="VOLUMERANGE_ID-from" />                    
                                        </li>
                                        <li>
                                            -
                                        </li>									
                                        <li>
                                            <input class="data text number volume range to" id="VOLUMERANGE_ID-to" name="VOLUMERANGE_ID-to" />                         
                                        </li>
                                    </ul>
                                </div>                
                            </div>                         

                        </div><!-- Column -->    

                    </div>
                </div> <!-- Group -->           



                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">User Related</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

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

                        </div><!-- Column -->    

                    </div>
                </div> <!-- Group -->                      



                <!-- Group -->
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
                                    <input class="data text-autocomplete street" id="street" name="street" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>City</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text-autocomplete city" id="city" name="city" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Zip</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text-autocomplete zip" id="zip" name="zip" />                    
                                </div>              
                            </div> 

                            <div class="labeled-content">
                                <div class="label">
                                    <label>Country</label> 
                                </div>              
                                <div class="content">
                                    <select class="data select language" id="country" name="country"> 
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
                                            <input class="data text address row-1" id="address-row-1" name="address-row-1" />                    
                                        </li>
                                        <li>
                                            <input class="data text address row-2" id="address-row-2" name="address-row-2" />
                                        </li>
                                        <li>
                                            <input class="data text address row-3" id="address-row-3" name="address-row-3" /> 
                                        </li>
                                    </ul>
                                </div>              
                            </div>  

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Language</label> 
                                </div>              
                                <div class="content">                
                                    <select class="data select language" id="language" name="language"> 
                                        <option>LANGUAGE</option>
                                    </select> 							                 
                                </div>              
                            </div>                     

                        </div> <!-- Column -->   

                    </div>
                </div> <!-- Group -->           



                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">Contact Related</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Phone</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text phone" id="phone" name="phone" />                                         
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Mobile</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text mobile" id="mobile" name="mobile" />                                         
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Fax</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text fax" id="fax" name="fax" />                                         
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>E-mail</label> 
                                </div>              
                                <div class="content">                  
                                    <input class="data text email" id="email" name="email" />                                         
                                </div>              
                            </div>                

                        </div><!-- Column -->    

                    </div>
                </div> <!-- Group -->          



                <!-- Group -->
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
                </div> <!-- Group -->  



                <!-- Group -->
                <div class="group">
                    <h3 class="group-header">Carrier Related</h3>
                    <div class="group-content">   

                        <!-- Column -->
                        <div class="column">

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Carrier</label> 
                                </div>              
                                <div class="content">
                                    <select class="data select-autocomplete carrier" id="carrier" name="carrier"> 
                                        <option>CARRIER</option>
                                    </select> 
                                </div>              
                            </div> 

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Transport Product</label> 
                                </div>              
                                <div class="content">   
                                    <select class="data select-autocomplete transportproduct" id="transportproduct" name="transportproduct"> 
                                        <option>TRANSPORT_PRODUCT</option>
                                    </select> 							
                                </div>              
                            </div>                         

                        </div><!-- Column -->  

                    </div>
                </div> <!-- Group --> 



                <!-- Group -->
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
                                    <select class="data select-autocomplete node" id="node" name="node"> 
                                        <option>NODE</option>
                                    </select> 
                                </div>              
                            </div>          

                            <div class="labeled-content"> 
                                <div class="label">
                                    <label>Transport Mode</label> 
                                </div>              
                                <div class="content">                  
                                    <select class="data select-autocomplete transportmode" id="transportmode" name="transportmode"> 
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
                                            <input class="data text digits package-number required" id="package-number" name="package-number" placeholder="Package Number"/>      
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

                        </div><!-- Column -->  

                    </div>
                </div> <!-- Group -->   

            </form>

        </div>
    </body>

</html>
