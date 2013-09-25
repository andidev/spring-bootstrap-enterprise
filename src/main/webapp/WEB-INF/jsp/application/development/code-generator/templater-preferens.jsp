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
				/* Class Name */
				init('code');
				init('description');
				init('svc-code');
				init('data-type');
				init('max-ppl-code');
				init('cust-modified');
				init('prefvalue');

				/* Method Name */
				function init(name) {
					$('span.'+name+'.upper-case').text($('input.'+name+'').val());
					$('span.'+name+'.upper-case').text($('input.'+name+'').val().toUpperCase());
					$('span.'+name+'.lower-case').text($('input.'+name+'').val().toLowerCase());
					$('span.'+name+'.camel-case').text($('input.'+name+'').val());
					$('span.'+name+'.camel-case-lower').text($('input.'+name+'').val());
					$('input.'+name+'').keyup(function(){
						$('span.'+name+'').text($(this).val().toUpperCase());
						$('span.'+name+'.upper-case').text($(this).val().toUpperCase());
						$('span.'+name+'.lower-case').text($(this).val().toLowerCase());
						$('span.'+name+'.camel-case').text($(this).val());
						$('span.'+name+'.camel-case-lower').text($(this).val());
					});
				}
				
            });

			
			
        </script>
		
	</head>

	<body class="body">
		<h1 class="body-header">Preference Generator</h1>    
		<div class="body-content"> 
			
			<!-- Group -->
			<div class="group">
				<h3 class="group-header">Inputs</h3>  
				<div class="group-content">   
					
					<!-- Column -->
					<div class="column">

						<div class="labeled-content"> 
							<div class="label">
								<label>Code</label> 
							</div>              
							<div class="content">
								<input class="data text code" name="code" value="" />                    
							</div>              
						</div>	

						<div class="labeled-content"> 
							<div class="label">
								<label>Description</label> 
							</div>              
							<div class="content">
								<input class="data text description" name="description" value="" />                    
							</div>              
						</div>		

						<div class="labeled-content"> 
							<div class="label">
								<label>Service Code</label> 
							</div>              
							<div class="content">
								<input class="data text svc-code" name="svc-code" value="" />                    
							</div>              
						</div>			

						<div class="labeled-content"> 
							<div class="label">
								<label>Data Type</label> 
							</div>              
							<div class="content">
								<input class="data text data-type" name="data-type" value="STRING" />                    
							</div>              
						</div>			

						<div class="labeled-content"> 
							<div class="label">
								<label>max-ppl-code</label> 
							</div>              
							<div class="content">
								<input class="data text max-ppl-code" name="max-ppl-code" value="CUSTOMER" />                    
							</div>              
						</div>				

						<div class="labeled-content"> 
							<div class="label">
								<label>Customer</label> 
							</div>              
							<div class="content">
								<input class="data text cust-modified" name="cust-modified" value="Y" />                    
							</div>              
						</div>				

						<div class="labeled-content"> 
							<div class="label">
								<label>prefvalue</label> 
							</div>              
							<div class="content">
								<input class="data text prefvalue" name="prefvalue" value="Y/N" />                    
							</div>              
						</div>							
						
					</div><!-- Column -->  
					
				</div> 
			</div><!-- Group -->   
			
			<!-- Group -->
			<div class="group">
				<h3 class="group-header">Result</h3>  
				<div class="group-content">   
					
					<!-- Column -->
					<div class="column">

						<div class="labeled-content"> 
							<div class="label">
								<label>PL_PREFERENCE</label> 
							</div>              
							<div class="content">
								
<pre class="ref-class brush: java;">
-- PL_PREFERENCES
INSERT INTO pl_preferences (code, description, data_type, owner, cust_modified, reg_user, reg_time, max_ppl_code, prefvalue)
VALUES ('<span class="code upper-case" />', '<span class="description" />', '<span class="data-type upper-case" />', NULL, '<span class="cust-modified upper-case" />', 'andste', TO_DATE (SYSDATE), '<span class="max-ppl-code upper-case" />', '<span class="prefvalue upper-case" /> );
</pre>

								
							</div>              
						</div>							
						

						<div class="labeled-content"> 
							<div class="label">
								<label>PL_SERVICE_PREFERENCES</label> 
							</div>              
							<div class="content">
								
<pre class="ref-class brush: java;">
-- PL_SERVICE_PREFERENCES
INSERT INTO pl_service_preferences (ID, prf_code, svc_code, description)
VALUES (primelog_seq.NEXTVAL, '<span class="code upper-case" />', '<span class="svc-code upper-case" />', '<span class="description" />');
</pre>

								
							</div>              
						</div>							
						

						<div class="labeled-content"> 
							<div class="label">
								<label>PL_CUSTOMERPREFERENCES</label> 
							</div>              
							<div class="content">
								
<pre class="ref-class brush: java;">
-- PL_CUSTOMERPREFERENCES
INSERT INTO pl_customerpreferences (ID, plc_id, trb_id, prf_code, VALUE, reg_user, reg_time, msc_id, ppl_code, usr_username)
VALUES (primelog_seq.NEXTVAL, 124, NULL, '<span class="code upper-case" />', 'Y', 'andste', TO_DATE(sysdate), NULL, 'CUSTOMER', '');	
</pre>

								
							</div>              
						</div>							
						
					</div><!-- Column -->  
					
				</div> 
			</div><!-- Group -->   
				

		</div>
	</body>

</html>
