package org.andidev.applicationname.config.springsecurity;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

public class UserDetailsServiceAnonymousAuthenticationFilter extends AnonymousAuthenticationFilter {

    private UserDetailsService userDetailsService;
    private AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new WebAuthenticationDetailsSource();
    private String key;
    private String username;
    private Object principal;
    private List<GrantedAuthority> authorities;

    public UserDetailsServiceAnonymousAuthenticationFilter(UserDetailsService userDetailsService) {
        this(userDetailsService, "anonymousKey");
    }

    public UserDetailsServiceAnonymousAuthenticationFilter(UserDetailsService userDetailsService, String key) {
        this(userDetailsService, key, "anonymousUser");
    }

    public UserDetailsServiceAnonymousAuthenticationFilter(UserDetailsService userDetailsService, String key, String username) {
        this.userDetailsService = userDetailsService;
        this.key = key;
        this.username = username;
    }

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(userDetailsService, "userDetailsService must be specified");
        Assert.hasLength(key);
        Assert.notNull(username, "Anonymous username must be set");
    }

    @Transactional(readOnly = true)
    @Override
    protected Authentication createAuthentication(HttpServletRequest request) {
        // Get principal and authorities from UserDetailSertvice
        if (principal == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            principal = userDetails;
            authorities = new ArrayList(userDetails.getAuthorities());
        }

        AnonymousAuthenticationToken auth = new AnonymousAuthenticationToken(key, principal, authorities);
        auth.setDetails(authenticationDetailsSource.buildDetails(request));

        return auth;
    }

    @Override
    public void setAuthenticationDetailsSource(AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource) {
        super.setAuthenticationDetailsSource(authenticationDetailsSource);
        this.authenticationDetailsSource = authenticationDetailsSource;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
