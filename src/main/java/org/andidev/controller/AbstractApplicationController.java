package org.andidev.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public abstract class AbstractApplicationController {

    @Value("${application.name}")
    private String applicationName;
    @Value("${application.version}")
    private String applicationVersion;

    @ModelAttribute("applicationName")
    public String getApplicationName() {
        return applicationName;
    }

    @ModelAttribute("applicationVersion")
    public String getApplicationVersion() {
        return applicationVersion;
    }
}