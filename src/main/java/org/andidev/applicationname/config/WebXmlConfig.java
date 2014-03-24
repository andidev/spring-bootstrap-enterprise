package org.andidev.applicationname.config;

import org.andidev.applicationname.config.logging.MDCInsertingServletFilter;
import ch.qos.logback.access.servlet.TeeFilter;
import ch.qos.logback.classic.ViewStatusMessagesServlet;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import lombok.extern.slf4j.Slf4j;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.join;
import org.h2.server.web.WebServlet;
import org.jminix.console.servlet.MiniConsoleServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

@Slf4j
public class WebXmlConfig implements WebApplicationInitializer {
    
    final String TARGET_FOLDER = getClass().getClassLoader().getResource(".").getPath().replaceAll("/classes/$", "");

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Load Application Properties
        String applicationEnvironment = getApplicationEnvironment();
        Properties applicationProperties = loadApplicationProperties(applicationEnvironment);

        // Set Java Melody settings
        servletContext.setInitParameter("javamelody.monitoring-path", "/javamelody");
        servletContext.setInitParameter("javamelody.storage-directory", TARGET_FOLDER + "/logs/javamelody");
        servletContext.setInitParameter("javamelody.resolution-seconds", "60");
        servletContext.setInitParameter("javamelody.disabled", "false");

        // Create Application Context
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(ApplicationConfig.class);
        appContext.setDisplayName(applicationProperties.getProperty("application.name"));
        appContext.getEnvironment().setActiveProfiles(applicationEnvironment);
        log.info("Starting up Application with the following active profiles: " + join(appContext.getEnvironment().getActiveProfiles(), ", "));

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


        // Register Database Manager Web Servlet
        ServletRegistration.Dynamic databaseManagerWebServlet =
                servletContext.addServlet("databaseManagerWebServlet", new WebServlet());
        databaseManagerWebServlet.setInitParameter("webAllowOthers", "");
        databaseManagerWebServlet.setLoadOnStartup(1);
        databaseManagerWebServlet.addMapping("/system/database/*");

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

        // Providing URL for Logback Status with OnStatusConsoleListener
        ServletRegistration.Dynamic viewStatusMessages =
                servletContext.addServlet("viewStatusMessages", new ViewStatusMessagesServlet());
        viewStatusMessages.addMapping("/admin/logback");

    }

    private String getApplicationEnvironment() {
        String applicationEnvironment = System.getProperty("application.environment");
        if (isBlank(applicationEnvironment)) {
            // No application environment provided, use localhost as default
            log.info("No application.environment set in System Properties, setting default application.environment = localhost");
            System.setProperty("application.environment", "localhost");
            return "localhost";
        }
        return applicationEnvironment;
    }
    private Properties loadApplicationProperties(String applicationEnvironment) {
        Properties properties = new Properties();
        String applicationPropertiesPath = "application_" + applicationEnvironment + ".properties";
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(applicationPropertiesPath));
        } catch (NullPointerException ex) {
            throw new RuntimeException("Did not find application_" + applicationEnvironment + ".properties file in src/main/resources folder for application.environment = " + applicationEnvironment, ex);
        } catch (IOException ex) {
            throw new RuntimeException("Could not read application_" + applicationEnvironment + ".properties file in src/main/resources folder", ex);
        }
        return properties;
    }
}
