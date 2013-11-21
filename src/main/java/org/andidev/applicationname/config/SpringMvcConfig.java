package org.andidev.applicationname.config;

import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.config.format.UserDateTimeFormatAnnotationFormatterFactory;
import org.andidev.applicationname.config.interceptor.LocaleInterceptor;
import org.andidev.applicationname.config.interceptor.TimeZoneInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
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

    @Inject
    Environment environment;

    @Bean
    }
    
    @Bean
    }
    
    @Override
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Configure the list of HttpMessageConverters to use
    }

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(new UserDateTimeFormatAnnotationFormatterFactory());
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

    @Bean
    @Override
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = super.requestMappingHandlerAdapter();
        adapter.setIgnoreDefaultModelOnRedirect(true); // Makes sure url parameters are removed on a redirect
        return adapter;
    }
}
