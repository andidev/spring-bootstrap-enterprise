package org.andidev.applicationname.config;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.config.format.UserDateTimeFormatAnnotationFormatterFactory;
import org.andidev.applicationname.config.interceptor.LocaleInterceptor;
import org.andidev.applicationname.config.interceptor.TimeZoneInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@Slf4j
@Import({ThymeleafConfig.class})
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    @Value("${application.environment}")
    private String environment;
    @Value("${application.version}")
    private String version;

    @Bean
    public LocaleInterceptor localeInterceptor() {
        LocaleInterceptor localeInterceptor = new LocaleInterceptor();
        return localeInterceptor;
    }
    
    @Bean
    public TimeZoneInterceptor timeZoneInterceptor() {
        TimeZoneInterceptor timeZoneInterceptor = new TimeZoneInterceptor();
        return timeZoneInterceptor;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
        registry.addInterceptor(timeZoneInterceptor());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Configure the list of HttpMessageConverters to use
    }

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        // Configure the list of formatters to use
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if ("prod".equals(environment)) {
            registry.addResourceHandler("/resources-" + version + "/**")
                    .addResourceLocations("/resources/")
                    .setCachePeriod(365*24*60*60); // 365*24*60*60 equals one year
        } else {
            registry.addResourceHandler("/resources-" + version + "/**")
                    .addResourceLocations("/resources/")
                    .setCachePeriod(0); // Don't chache
        }
    }

    @Bean
    @Override
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = super.requestMappingHandlerAdapter();
        adapter.setIgnoreDefaultModelOnRedirect(true); // Makes sure url parameters are removed on a redirect
        return adapter;
    }
}
