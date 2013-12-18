package org.andidev.applicationname.config;

import com.github.dandelion.datatables.thymeleaf.dialect.DataTablesDialect;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Value("${application.environment}")
    private String applicationEnvironment;

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setOrder(1);
        return thymeleafViewResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.addDialect(new LayoutDialect());
        templateEngine.addDialect(new SpringSecurityDialect());
        templateEngine.addDialect(new DataTablesDialect());
        return templateEngine;
    }

    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/thymeleaf/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setOrder(1);
        if (applicationEnvironment.equals("localhost") || applicationEnvironment.equals("development")) {
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