package org.andidev.applicationname.config.springsecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

@Slf4j
public class CustomWebAndMethodSecurityExpressionRoot extends WebAndMethodSecurityExpressionRoot {

    @Value("${application.environment}")
    private String applicationEnvironment;

    public CustomWebAndMethodSecurityExpressionRoot(Authentication a) {
        super(a);
    }

    public CustomWebAndMethodSecurityExpressionRoot(Authentication a, FilterInvocation fi) {
        super(a, fi);
    }

    public boolean isLocalhostEnvironment() {
        return "localhost".equals(applicationEnvironment);
    }

    public boolean isDevelopmentEnvironment() {
        return "development".equals(applicationEnvironment);
    }

    public boolean isTestEnvironment() {
        return "test".equals(applicationEnvironment);
    }

    public boolean isProductionEnvironment() {
        return "production".equals(applicationEnvironment);
    }
}
