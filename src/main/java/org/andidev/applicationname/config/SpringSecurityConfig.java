package org.andidev.applicationname.config;

import javax.inject.Inject;
import org.andidev.applicationname.config.springsecurity.UserDetailsServiceAnonymousAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SpringSecurityConfig {

//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        List<AuthenticationProvider> authenticationProviders = new ArrayList<AuthenticationProvider>();
//        authenticationProviders.add(null);
//        return new ProviderManager();
//    }
//
//    @Bean
//    public AuthenticationProvider anonymousAuthenticationProvider() throws Exception {
//        AnonymousAuthenticationProvider anonymousAuthenticationProvider = new AnonymousAuthenticationProvider();
//        return anonymousAuthenticationProvider;
//    }
    @Inject
    UserDetailsService userDetailService;

    @Bean
    public UserDetailsServiceAnonymousAuthenticationFilter anonymousAuthenticationFilter() {
        UserDetailsServiceAnonymousAuthenticationFilter anonymousAuthenticationFilter = new UserDetailsServiceAnonymousAuthenticationFilter(userDetailService);
        return anonymousAuthenticationFilter;
    }
}
