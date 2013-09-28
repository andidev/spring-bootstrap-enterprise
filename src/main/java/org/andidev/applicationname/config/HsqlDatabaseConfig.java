package org.andidev.applicationname.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("local")
public class HsqlDatabaseConfig {

    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;

    // Data Source
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    // Jpa Vendor Adapter
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.HSQL);
        jpaVendorAdapter.setShowSql(false);
        jpaVendorAdapter.setGenerateDdl(false);
        return jpaVendorAdapter;
    }
    
//  @Bean
//  public DatabasePopulator databasePopulator(DataSource dataSource) {
//    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//    populator.setContinueOnError(true);
//    populator.setIgnoreFailedDrops(true);
//    // populator.addScript(new ClassPathResource("/sql/mydata-dml.sql"));
//    try {
//      populator.populate(dataSource.getConnection());
//    } catch (SQLException ignored) {}
//    return populator;
//  }  
  
//    http://stackoverflow.com/questions/9680286/spring-web-application-doing-something-on-startup-initialization
//    @PostConstruct
//public void init() {
//     //startup logic here
//}
}