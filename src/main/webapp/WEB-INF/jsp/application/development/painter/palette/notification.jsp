<!DOCTYPE html>
<html>

    <head>

        <jsp:include page="/WEB-INF/jsp/common/include.jsp" />

        <!-- Page specific css -->
        <style type="text/css">

            .button {
                width: 160px;
            }

        </style>

        <!-- Page specific javascript -->
        <script type="text/javascript">
            
            $(function() {
                $('button').button();
            });

        </script>

    </head>

</head>

<body class="body">
    <h1 class="body-header">Notification Palette</h1>    
    <div class="body-content"> 




        <!-- Group -->
        <div class="group">
            <h3 class="group-header">Search Form Buttons</h3>  
            <div class="group-content">   

                <!-- Column -->
                <div class="column">

                    <div>
                        <button class="button error">Error!</button>
                        <button class="button alert">Alert!</button>
                        <button class="button info">Info!</button>
                        <button class="button loading">Loading...</button>
                        <button class="button loading-success">Loading Success!</button>
                        <button class="button loading-failed">Loading Failed!</button>
                    </div>             

                </div><!-- Column -->  

            </div> 
        </div><!-- Group -->              



    </div>
</body>

</html>
