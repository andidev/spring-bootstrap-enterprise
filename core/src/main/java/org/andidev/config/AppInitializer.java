package org.andidev.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer { // implements WebApplicationInitializer {

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        // Load Application Context
//        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//        //appContext.register(ApplicationContext.class); // TODO: Remove if not needed, from krams
//        //appContext.setConfigLocation("org.andidev.config.AppConfig"); // TODO: Investigate if usable, old config
//        appContext.scan("org.andidev.config"); // TODO: Remove if not needed, from old setup
//        appContext.setDisplayName(appContext.getEnvironment().getProperty("application.name"));
//        appContext.getEnvironment().setDefaultProfiles("dev"); // TODO: Investigate if needed
//
//        // Context Loader Listener 
//        // servletContext.addListener(new ContextLoaderListener(appContext)); // Investigate why this is used by krams
//
//        // Dispatcher Servlet
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
}