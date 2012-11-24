package org.andidev.config;

import org.andidev.config.appconfig.HsqlDatabaseConfig;
import org.andidev.config.appconfig.WebMvcConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan(basePackages = "org.andidev")
@PropertySource({"application.properties"})
@ImportResource({"/WEB-INF/spring-security.xml", "/WEB-INF/applicationContext.xml"})
@Import({WebMvcConfig.class, HsqlDatabaseConfig.class})
public class AppConfig {

    // Nedded for @PropertySource annotation, see https://jira.springsource.org/browse/SPR-8539
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer pspc =
                new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[]{new ClassPathResource("application.properties")};
        pspc.setLocations(resources);
        return pspc;
    }
}
