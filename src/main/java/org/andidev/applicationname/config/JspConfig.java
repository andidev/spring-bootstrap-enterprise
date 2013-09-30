package org.andidev.applicationname.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class JspConfig {

    @Value("${application.environment}")
    private String environment;

    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setViewClass(JstlView.class);
        jspViewResolver.setOrder(2);
        jspViewResolver.setPrefix("/WEB-INF/views/jsp/");
        jspViewResolver.setSuffix(".jsp");
        jspViewResolver.setViewNames(new String[]{"*jsp"});
        return jspViewResolver;
    }
}