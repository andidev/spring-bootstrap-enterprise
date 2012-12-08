package org.andidev.config.appconfig;

//import net.bull.javamelody.MonitoredWithInterfacePointcut;
//import net.bull.javamelody.MonitoringSpringAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class JavaMelodyConfig {

//    // Pointcut
//    @Bean
//    public MonitoredWithInterfacePointcut facadeMonitoringAdvisorPointcut() throws ClassNotFoundException {
//        MonitoredWithInterfacePointcut facadeMonitoringAdvisorPointcut = new MonitoredWithInterfacePointcut();
//        facadeMonitoringAdvisorPointcut.setInterfaceName("org.andidev.service.*");
//        return facadeMonitoringAdvisorPointcut;
//    }
//
//    // Facade Monitor Advisor
//    @Bean
//    public MonitoringSpringAdvisor facadeMonitoringAdvisor() throws ClassNotFoundException {
//        MonitoringSpringAdvisor facadeMonitoringAdvisor = new MonitoringSpringAdvisor();
//        facadeMonitoringAdvisor.setPointcut(facadeMonitoringAdvisorPointcut());
//        return facadeMonitoringAdvisor;
//    }
}