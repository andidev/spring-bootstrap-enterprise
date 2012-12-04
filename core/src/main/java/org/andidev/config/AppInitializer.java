package org.andidev.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer { // implements WebApplicationInitializer {

//    @Override
//    public void onStartup(ServletContext servletContext) {
//        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//        appContext.setConfigLocation("org.andidev.config.AppConfig");
//        appContext.scan("org.andidev.config");
//        appContext.getEnvironment().setDefaultProfiles("dev");
//
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        // Load application context
//        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//        appContext.register(ApplicationContext.class);
//        appContext.setDisplayName("Spring Thymeleaf Tutorial");
//
//        // Context Loader Listener 
//        servletContext.addListener(new ContextLoaderListener(appContext));
//
//        // Dispatcher Servlet
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
}