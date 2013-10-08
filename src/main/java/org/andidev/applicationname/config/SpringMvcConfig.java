package org.andidev.applicationname.config;

import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@EnableWebMvc
@Slf4j
@Import({ThymeleafConfig.class})
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    @Inject
    Environment environment;

    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

    @Bean
    @Override
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = super.requestMappingHandlerAdapter();
        adapter.setIgnoreDefaultModelOnRedirect(true);
        return adapter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    @Override
    public HandlerMapping resourceHandlerMapping() {
        return super.resourceHandlerMapping(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if ("prod".equals(environment.getProperty("application.version"))) {
            registry.addResourceHandler("/resources-" + environment.getProperty("application.version") + "/**")
                    .addResourceLocations("/resources/")
                    .setCachePeriod(365*24*60*60); // 365*24*60*60 equals one year
        } else {
            registry.addResourceHandler("/resources-" + environment.getProperty("application.version") + "/**")
                    .addResourceLocations("/resources/")
                    .setCachePeriod(0); // Don't chache
        }
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Configure the list of HttpMessageConverters to use
    }
}
