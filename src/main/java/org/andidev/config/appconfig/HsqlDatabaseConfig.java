package org.andidev.config.appconfig;

import javax.inject.Inject;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//@ComponentScan(basePackages="org.andidev.???")
public class HsqlDatabaseConfig {

    @Inject
    Environment environment;

}
