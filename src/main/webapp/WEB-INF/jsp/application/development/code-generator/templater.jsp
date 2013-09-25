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
				$('span.class-name.upper-case').text($('input.class-name').val().toUpperCase());
				$('span.class-name.lower-case').text($('input.class-name').val().toLowerCase());
				$('span.class-name.camel-case').text($('input.class-name').val());
				$('span.class-name.camel-case-lower').text($('input.class-name').val());
				$('input.class-name').keyup(function(){
					$('span.class-name.lower-case').text($(this).val().toLowerCase());
					$('span.class-name.camel-case').text($(this).val());
					$('span.class-name.camel-case-lower').text($(this).val());
				});

				/* Method Name */
				$('span.method-name.upper-case').text($('input.method-name').val().toUpperCase());
				$('span.method-name.lower-case').text($('input.method-name').val().toLowerCase());
				$('span.method-name.camel-case').text($('input.method-name').val());
				$('span.method-name.camel-case-lower').text($('input.method-name').val());
				$('input.method-name').keyup(function(){
					$('span.method-name.upper-case').text($(this).val().toUpperCase());
					$('span.method-name.lower-case').text($(this).val().toLowerCase());
					$('span.method-name.camel-case').text($(this).val());
					$('span.method-name.camel-case-lower').text($(this).val());
				});
            });

			
			
        </script>
		
	</head>

	<body class="body">
		<h1 class="body-header">Template Genarator</h1>    
		<div class="body-content"> 
			
			<!-- Group -->
			<div class="group">
				<h3 class="group-header">Names</h3>  
				<div class="group-content">   
					
					<!-- Column -->
					<div class="column">

						<div class="labeled-content"> 
							<div class="label">
								<label>Class Name</label> 
							</div>              
							<div class="content">
								<input class="data text class-name" name="class-name" value="ClassName" />                    
							</div>              
						</div>	

						<div class="labeled-content"> 
							<div class="label">
								<label>Method Name</label> 
							</div>              
							<div class="content">
								<input class="data text method-name" name="method-name" value="MethodName" />                    
							</div>              
						</div>							
						
					</div><!-- Column -->  
					
				</div> 
			</div><!-- Group -->   
			
			<!-- Group -->
			<div class="group">
				<h3 class="group-header">Ref Class Generation</h3>  
				<div class="group-content">   
					
					<!-- Column -->
					<div class="column">

						<div class="labeled-content"> 
							<div class="label">
								<label>Ref Class</label> 
							</div>              
							<div class="content">
								
<pre class="ref-class brush: java;">
package com.primelog.utils.access;

/*
 * Accessclass for <span class="class-name camel-case"></span>
 *
 * Copyright (c) 2000 Primelog AB
 *
 */

import com.primelog.ejb.session.<span class="class-name lower-case"></span>.<span class="class-name camel-case"></span>;
import com.primelog.ejb.session.<span class="class-name lower-case"></span>.<span class="class-name camel-case"></span>Home;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.primelog.framework.WebEJBAccess;

import com.primelog.framework.PrimelogException;

/**
 * Java Bean used for accessing the <span class="class-name camel-case"></span> EJB from JSP-pages and servlets
 * @author Mikael Beermann, Primelog AB
 * @see ReportManager.java
 */

public class <span class="class-name camel-case"></span>Ref extends WebEJBAccess  {

    private <span class="class-name camel-case"></span>Handler <span class="class-name camel-case-lower"></span>Handler;
    private boolean initialized;


    public <span class="class-name camel-case"></span>Ref() {
        initialized = false;
    }

    public void finalize() {
    }

    public void init() throws PrimelogException {
        if (initialized) return;
        initialized = true;
        try {
            InitialContext ic = getInitialContext();

            Object object = ic.lookup("<span class="class-name lower-case"></span>handler.<span class="class-name camel-case"></span>HandlerHome");
            <span class="class-name camel-case"></span>HandlerHome home = (<span class="class-name camel-case"></span>HandlerHome)PortableRemoteObject.narrow(object,<span class="class-name camel-case"></span>HandlerHome.class);
            <span class="class-name camel-case-lower"></span>Handler = home.create();
        } catch (javax.naming.NamingException e) {
            throw new PrimelogException(8001, this, "<span class="class-name camel-case"></span>Ref", e);
        } catch (javax.ejb.CreateException ce) {
            throw new PrimelogException(8003, this, "<span class="class-name camel-case"></span>Ref", ce);
        } catch (java.rmi.RemoteException re) {
            throw new PrimelogException(8002, this, "<span class="class-name camel-case"></span>Ref", re);
        }
    }

    public String <span class="method-name camel-case-lower"></span>(String xml) throws PrimelogException {
        try {
            init();
            return <span class="class-name camel-case-lower"></span>Handler.<span class="method-name camel-case-lower"></span>(xml);
        } catch (java.rmi.RemoteException e) {
            throw new PrimelogException(8002,this,"<span class="method-name camel-case-lower"></span>", e);
        }
    }




}
</pre>

								
							</div>              
						</div>							
						
					</div><!-- Column -->  
					
				</div> 
			</div><!-- Group -->   
			
			<!-- Group -->
			<div class="group">
				<h3 class="group-header">DB Access Bean Generation</h3>  
				<div class="group-content">   
					
					<!-- Column -->
					<div class="column">

						<div class="labeled-content"> 
							<div class="label">
								<label>JNDINames0</label> 
							</div>              
							<div class="content">
								
<pre class="ref-class brush: java;">
    public static final
        String <span class="class-name upper-case"></span>_DB_JNDI_NAME = "<span class="class-name lower-case"></span>.<span class="class-name camel-case"></span>DBHome";      
</pre>

								
							</div>              
						</div>	


						<div class="labeled-content"> 
							<div class="label">
								<label>EJB0Util</label> 
							</div>              
							<div class="content">
								
<pre class="ref-class brush: java;">
import com.primelog.ejb.database.customobjects.<span class="class-name lower-case"></span>.<span class="class-name camel-case"></span>DB;
import com.primelog.ejb.database.customobjects.<span class="class-name lower-case"></span>.<span class="class-name camel-case"></span>DBHome;
    /* <span class="class-name camel-case"></span>DB */
    static public <span class="class-name camel-case"></span>DBHome get<span class="class-name camel-case"></span>DBHome() throws PrimelogException
    {
        Object o = getInitialContextAndLookup(JNDINames0.<span class="class-name upper-case"></span>_DB_JNDI_NAME);
        return (<span class="class-name camel-case"></span>DBHome)PortableRemoteObject.narrow(o, <span class="class-name camel-case"></span>DBHome.class);
    }
    static public <span class="class-name camel-case"></span>DB create<span class="class-name camel-case"></span>DB() throws PrimelogException
    {
        try {
            return (<span class="class-name camel-case"></span>DB)PortableRemoteObject.narrow(get<span class="class-name camel-case"></span>DBHome().create(), 
                                       <span class="class-name camel-case"></span>DB.class);
        } catch (CreateException ce) {
            System.out.println("CreateException: " + ce.getMessage());
            throw new PrimelogException(3, "EJB0Util", "create<span class="class-name camel-case"></span>DB", ce);
        } catch (RemoteException re) {
            System.out.println("RemoteException: " + re.getMessage());
            throw new PrimelogException(17, "EJB0Util", "create<span class="class-name camel-case"></span>DB", re);
        }
    }
</pre>

								
							</div>              
						</div>							
						
					</div><!-- Column -->  
					
				</div> 
			</div><!-- Group -->   
			
			<!-- Group -->
			<div class="group">
				<h3 class="group-header">Handler Access Bean Generation</h3>  
				<div class="group-content">   
					
					<!-- Column -->
					<div class="column">

						<div class="labeled-content"> 
							<div class="label">
								<label>JNDINames</label> 
							</div>              
							<div class="content">
								
<pre class="ref-class brush: java;">
    public static final
    String <span class="class-name upper-case"></span>_HANDLER_JNDI_NAME = "<span class="class-name lower-case"></span>handler.<span class="class-name camel-case"></span>Home";      
</pre>

								
							</div>              
						</div>		


						<div class="labeled-content"> 
							<div class="label">
								<label>EJBUtil</label> 
							</div>              
							<div class="content">
								
<pre class="ref-class brush: java;">
import com.primelog.ejb.session.<span class="class-name lower-case"></span>handler.<span class="class-name camel-case"></span>Handler;
import com.primelog.ejb.session.<span class="class-name lower-case"></span>handler.<span class="class-name camel-case"></span>HandlerHome;
    static public <span class="class-name camel-case"></span>HandlerHome get<span class="class-name camel-case"></span>HandlerHome() throws PrimelogException
    {
        Object o = getInitialContextAndLookup(JNDINames.<span class="class-name upper-case"></span>_HANDLER_JNDI_NAME);
        return (<span class="class-name camel-case"></span>HandlerHome)PortableRemoteObject.narrow(o, <span class="class-name camel-case"></span>HandlerHome.class);
    }
    
    static public <span class="class-name camel-case"></span>Handler create<span class="class-name camel-case"></span>Handler() throws PrimelogException
    {
        try {
            return (<span class="class-name camel-case"></span>Handler)PortableRemoteObject.narrow(get<span class="class-name camel-case"></span>HandlerHome().create(), 
                                       <span class="class-name camel-case"></span>Handler.class);
        } catch (CreateException ce) {
            System.out.println("CreateException: " + ce.getMessage());
            throw new PrimelogException(3, "EJBUtil", "create<span class="class-name camel-case"></span>Handler", ce);
        } catch (RemoteException re) {
            System.out.println("RemoteException: " + re.getMessage());
            throw new PrimelogException(17, "EJBUtil", "create<span class="class-name camel-case"></span>Handler", re);
        }
    }    
</pre>

								
							</div>              
						</div>							
						
						
						
						
						
						
						
						
						
				


    
		
						
						
						
						
						
						
						
						
						
						
					</div><!-- Column -->  
					
				</div> 
			</div><!-- Group -->   
			
		</div>
	</body>

</html>
