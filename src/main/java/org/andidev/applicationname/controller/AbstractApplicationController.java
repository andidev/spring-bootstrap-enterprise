package org.andidev.applicationname.controller;

import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public abstract class AbstractApplicationController {

    @Inject
    private MessageSource messageSource;

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
}