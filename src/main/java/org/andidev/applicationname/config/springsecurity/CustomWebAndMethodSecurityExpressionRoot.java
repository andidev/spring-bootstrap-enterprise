package org.andidev.applicationname.config.springsecurity;

import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.util.ApplicationEnvironmentUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

@Slf4j
public class CustomWebAndMethodSecurityExpressionRoot extends WebAndMethodSecurityExpressionRoot {

    public CustomWebAndMethodSecurityExpressionRoot(Authentication a) {
        super(a);
    }

    public CustomWebAndMethodSecurityExpressionRoot(Authentication a, FilterInvocation fi) {
        super(a, fi);
    }

    public boolean isLocalhostEnvironment() {
        return ApplicationEnvironmentUtils.isLocalhostEnvironment();
    }

    public boolean isDevelopmentEnvironment() {
        return ApplicationEnvironmentUtils.isDevelopmentEnvironment();
    }

    public boolean isTestEnvironment() {
        return ApplicationEnvironmentUtils.isTestEnvironment();
    }

    public boolean isProductionEnvironment() {
        return ApplicationEnvironmentUtils.isProductionEnvironment();
    }
}
