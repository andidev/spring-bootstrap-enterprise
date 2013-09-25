package org.andidev.applicationname.config;

import java.util.List;
import javax.inject.Inject;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@Import({ThymeleafConfig.class})
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    @Inject
    Environment environment;
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // Add formatters and/or converters
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new LocalInterceptor());
        //registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");
        
//    <!-- TODO: add support for locale, see below www -->
//    <!-- Configures Handler Interceptors 
//    http://www.openscope.net/2010/02/08/spring-mvc-3-0-and-jsr-303-aka-javax-validation/ -->  
//    <!--
//    <mvc:interceptors>   -->
//        <!-- Changes the locale when a 'locale' request parameter is sent -->  
//        <!--<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor"/>  
//    </mvc:interceptors>  
//    -->
//    <!-- Saves a locale change using a cookie -->  
//    <!--
//    <bean class="org.springframework.web.servlet.i18n.CookieLocaleResolver"  
//          id="localeResolver" />  
//        -->          
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Un-versioned resource url
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(31556926); // 31556926 equals one year
        // Versioned resource url
        registry.addResourceHandler("/resources-" + environment.getProperty("application.version") + "/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(31556926); // 31556926 equals one year
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Configure the list of HttpMessageConverters to use 
    }
}
