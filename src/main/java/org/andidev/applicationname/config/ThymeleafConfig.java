package org.andidev.applicationname.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Value("${application.environment}")
    private String environment;

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setOrder(1);
//        thymeleafViewResolver.setViewClass(ThymeleafTilesView.class) ;
        return thymeleafViewResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.addDialect(new TilesDialect()); 
        return templateEngine;
    }

    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/thymeleaf/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setOrder(1);
        if ("dev".equals(environment)) {
            templateResolver.setCacheable(false);
        }
        return templateResolver;
    }

//    see https://github.com/patelm5/atmosphere-rabbitmq-example/blob/master/src/main/java/spikes/mikeyp/configuration/WebMvcConfig.java
//    @Bean
//    public TilesConfigurer tilesConfigurer() {
//        TilesConfigurer configurer = new ThymeleafTilesConfigurer();
//        configurer.setDefinitions(new String[]{
//            "/WEB-INF/templates/layouts/tiles.xml",
//            "/WEB-INF/templates/views/tiles.xml"
//        });
//        configurer.setCheckRefresh(true);
//        return configurer;
//    }
}