package org.andidev.applicationname.config;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.config.interceptor.LocaleInterceptor;
import org.andidev.applicationname.config.interceptor.TimeZoneInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@Slf4j
@Import({ThymeleafConfig.class})
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    @Value("${application.environment}")
    private String applicationEnvironment;
    @Value("${application.version}")
    private String version;
    @Inject
    EntityManagerFactory entityManagerFactory;

    @Bean
    public LocaleInterceptor localeInterceptor() {
        return new LocaleInterceptor("locale");
    }

    @Bean
    public TimeZoneInterceptor timeZoneInterceptor() {
        return new TimeZoneInterceptor("timezone");
    }

    @Bean
    public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
        OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor = new OpenEntityManagerInViewInterceptor();
        openEntityManagerInViewInterceptor.setEntityManagerFactory(entityManagerFactory);
        return openEntityManagerInViewInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
        registry.addInterceptor(timeZoneInterceptor());
        registry.addWebRequestInterceptor(openEntityManagerInViewInterceptor());
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
        if (applicationEnvironment.equals("production")) {
            registry.addResourceHandler("/resources-" + version + "/**")
                    .addResourceLocations("/resources/")
                    .setCachePeriod(365 * 24 * 60 * 60); // 365*24*60*60 equals one year
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

    // TODO: Start using @PathVariable in Controllers or remove from configuration
    // for an example see http://refcardz.dzone.com/refcardz/core-spring-data#refcard-download-social-buttons-display
    @Bean
    public DomainClassConverter<?> domainClassConverter() {
        return new DomainClassConverter<FormattingConversionService>(mvcConversionService());
    }

    // TODO: Start using Pageable objects in Controllers or remove from configuration
    // for an example see http://refcardz.dzone.com/refcardz/core-spring-data#refcard-download-social-buttons-display
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new SortHandlerMethodArgumentResolver());
        argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
    }
}
