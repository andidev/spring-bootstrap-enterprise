package org.andidev.applicationname.config;

import ch.qos.logback.access.servlet.TeeFilter;
import ch.qos.logback.classic.ViewStatusMessagesServlet;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.jminix.console.servlet.MiniConsoleServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4JServletContextListener;

public class WebXmlConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {



        /* Logback */

        // Enable RequestContextHolder in MDCInsertingServletFilter
        servletContext.addListener(new RequestContextListener());

        // Add data to Logback MDC
        FilterRegistration.Dynamic mdcInsertingServletFilter =
                servletContext.addFilter("mdcInsertingServletFilter", MDCInsertingServletFilter.class);
        mdcInsertingServletFilter.addMappingForUrlPatterns(null, false, "/*");
        

        // Enable Logback Access Request-Response
        FilterRegistration.Dynamic teeFilter =
                servletContext.addFilter("teeFilter", TeeFilter.class);
        teeFilter.addMappingForUrlPatterns(null, false, "/*");

        // Handling System.out and System.err
        servletContext.addListener(new SysOutOverSLF4JServletContextListener());

        // Providing URL for Logback Status with OnStatusConsoleListener
        ServletRegistration.Dynamic viewStatusMessages =
                servletContext.addServlet("viewStatusMessages", new ViewStatusMessagesServlet());
        viewStatusMessages.addMapping("/admin/logback");

        
        // Set Java Melody settings
        servletContext.setInitParameter("javamelody.monitoring-path", "/monitoring");
        servletContext.setInitParameter("javamelody.storage-directory", "logs/javamelody");
        servletContext.setInitParameter("javamelody.resolution-seconds", "60");
        servletContext.setInitParameter("javamelody.disabled", "false");

        // Create Application Context
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        //appContext.scan("org.andidev.applicationname.config");
        appContext.setDisplayName("Application Name");
//        appContext.setDisplayName(appContext.getEnvironment().getProperty("application.name"));// TODO: Investigate if possible
        appContext.getEnvironment().setDefaultProfiles("dev"); // TODO: Investigate

        // Enable Application Context with Context Loader Listner
        servletContext.addListener(new ContextLoaderListener(appContext));

        // Register Dispatcher Servlet
        ServletRegistration.Dynamic dispatcherServlet =
                servletContext.addServlet("dispatcherServlet", new DispatcherServlet(appContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");


        // Register Spring Security Filter
        FilterRegistration.Dynamic springSecurityFilterChain =
                servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");

        // Register UTF-8 Encoding Filter, see http://developers-blog.org/blog/default/2010/08/17/Spring-MVC-and-UTF-8-Encoding-with-CharacterEncodingFilter
        FilterRegistration.Dynamic encodingFilter =
                servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");

        // Register REST GET, PUT, POST, and DELETE Support Filter, see http://static.springsource.org/spring/docs/current/spring-framework-reference/html/view.html#rest-method-conversion
        FilterRegistration.Dynamic httpMethodFilter =
                servletContext.addFilter("httpMethodFilter", HiddenHttpMethodFilter.class);
        httpMethodFilter.addMappingForUrlPatterns(null, false, "/*");

        // Register jMiniX Console Servlet
        ServletRegistration.Dynamic jminixConsoleServlet =
                servletContext.addServlet("jMiniXConsoleServlet", new MiniConsoleServlet());
        jminixConsoleServlet.addMapping("/admin/jminix/*");

    }
}