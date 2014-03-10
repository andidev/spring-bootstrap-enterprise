package org.andidev.applicationname.config;

import org.andidev.applicationname.config.auditing.AuditorProvider;
import org.andidev.applicationname.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    @Bean
    public AuditorAware<User> auditorProvider() {
        return new AuditorProvider();
    }
}
