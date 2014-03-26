package org.andidev.applicationname.config;

import java.util.Properties;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackages = {"org.andidev"})
@EnableTransactionManagement
@EnableJpaRepositories("org.andidev.applicationname.repository")
@EnableMBeanExport
@EnableAspectJAutoProxy
public class ApplicationConfig {

    @Value("${application.environment}")
    private String applicationEnvironment;
    @Inject
    private JpaVendorAdapter jpaVendorAdapter;
    @Inject
    private DataSource dataSource;

    // Load environment specific application properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(Environment environment) {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        ClassPathResource[] resources = {
            new ClassPathResource("application_" + environment.getProperty("application.environment") + ".properties")
        };
        pspc.setLocations(resources);
        return pspc;
    }

    // Jdbc Template
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    // persistence.xml Properties
    Properties persistenceXmlProperties() {
        return new Properties() {
            {  // Hibernate
                setProperty("hibernate.hbm2ddl.auto", "create-drop");
                setProperty("hibernate.globally_quoted_identifiers", "true");

                // Hibernate Envers
                setProperty("org.hibernate.envers.auditTablePrefix", "");
                setProperty("org.hibernate.envers.auditTableSuffix", "_AUD");
                setProperty("org.hibernate.envers.storeDataAtDelete", "true");

                // Use Joda Time
                setProperty("jadira.usertype.autoRegisterUserTypes", "true");
                setProperty("jadira.usertype.javaZone", "jvm");
                setProperty("jadira.usertype.databaseZone", "jvm");
            }
        };
    }

    // Entity Manager Factory
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setJpaProperties(persistenceXmlProperties());
        entityManagerFactory.setPackagesToScan("org.andidev.applicationname.entity");

        return entityManagerFactory;
    }

    // Exception Translation
    @Bean
    public HibernateExceptionTranslator exceptionTranslation() {
        return new HibernateExceptionTranslator();
    }

    // Transaction Manager
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    // JSR-303 Validation
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource reloadableMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("/WEB-INF/messages/messages");
        if (applicationEnvironment.equals("localhost")) {
            messageSource.setCacheSeconds(1);
        }
        return messageSource;
    }

    @Bean
    public ImportSql importSql() {
        return new ImportSql();
    }
}
