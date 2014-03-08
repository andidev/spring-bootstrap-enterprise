package org.andidev.applicationname.config;

import javax.inject.Inject;
import org.andidev.applicationname.config.springsecurity.SpringDataTokenRepositoryImpl;
import org.andidev.applicationname.config.springsecurity.UserDetailsServiceAnonymousAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    String REMEMBER_ME_KEY = "78780c25-1849-4796-a79c-0f4326f32dfd";

    @Inject
    UserDetailsService userDetailService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
           .ignoring()
           .antMatchers("/resources/**")
           .antMatchers("/resources-*/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requiresChannel()
                .anyRequest().requiresSecure()
                .and()
            .authorizeRequests()
                .antMatchers("/monitoring").hasRole("ADMIN")
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/login/failure")
                .defaultSuccessUrl("/")
                .and()
            .logout()
                .logoutUrl("/normallogout")
                .logoutSuccessUrl("/logout/success")
                .invalidateHttpSession(true)
                .and()
            .rememberMe()
                .userDetailsService(userDetailService)
                .tokenRepository(springDataTokenRepository())
                .and()
            .exceptionHandling()
                .accessDeniedPage("/accessdenied")
                .and()
            .anonymous().disable()
            .addFilterBefore(anonymousAuthenticationFilter(), AnonymousAuthenticationFilter.class)
            .addFilter(switchUserFilter())
            .authorizeRequests()
                .antMatchers("/switchuser").hasRole("ROOT")
                .and()
            .csrf().disable()
            .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    @Bean
    public UserDetailsServiceAnonymousAuthenticationFilter anonymousAuthenticationFilter() {
        UserDetailsServiceAnonymousAuthenticationFilter anonymousAuthenticationFilter = new UserDetailsServiceAnonymousAuthenticationFilter(userDetailService);
        return anonymousAuthenticationFilter;
    }

    @Bean
    public SwitchUserFilter switchUserFilter() {
        SwitchUserFilter switchUserFilter = new SwitchUserFilter();
        switchUserFilter.setUserDetailsService(userDetailService);
        switchUserFilter.setTargetUrl("/");
        switchUserFilter.setSwitchUserUrl("/switchuserto");
        switchUserFilter.setUsernameParameter("username");
        switchUserFilter.setExitUserUrl("/switchuserlogout");
        return switchUserFilter;
    }

    @Bean
    public SpringDataTokenRepositoryImpl springDataTokenRepository() {
        SpringDataTokenRepositoryImpl springDataTokenRepository = new SpringDataTokenRepositoryImpl();
        return springDataTokenRepository;
    }

    @Bean
    public RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
        RememberMeAuthenticationProvider rememberMeAuthenticationProvider = new RememberMeAuthenticationProvider(REMEMBER_ME_KEY);
        return rememberMeAuthenticationProvider;
    }
}
