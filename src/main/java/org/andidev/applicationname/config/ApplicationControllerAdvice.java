package org.andidev.applicationname.config;

import org.andidev.applicationname.util.ApplicationEnvironmentUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @Value("${application.name}")
    private String applicationName;
    @Value("${application.version}")
    private String applicationVersion;
    @Value("${application.environment}")
    private String applicationEnvironment;

    @ModelAttribute("applicationName")
    public String getApplicationName() {
        return applicationName;
    }

    @ModelAttribute("applicationVersion")
    public String getApplicationVersion() {
        return applicationVersion;
    }

    @ModelAttribute("applicationEnvironment")
    public String getApplicationEnvironment() {
        return applicationEnvironment;
    }

    @ModelAttribute("isLocalhostEnvironment")
    public boolean isLocalhostEnvironment() {
        return ApplicationEnvironmentUtils.isLocalhostEnvironment();
    }

    @ModelAttribute("isDevelopmentEnvironment")
    public boolean isDevelopmentEnvironment() {
        return ApplicationEnvironmentUtils.isDevelopmentEnvironment();
    }

    @ModelAttribute("isTestEnvironment")
    public boolean isTestEnvironment() {
        return ApplicationEnvironmentUtils.isTestEnvironment();
    }

    @ModelAttribute("isProductionEnvironment")
    public boolean isProductionEnvironment() {
        return ApplicationEnvironmentUtils.isProductionEnvironment();
    }
}
