package org.andidev.applicationname.controller;

import org.andidev.applicationname.controller.AbstractApplicationController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/development/painter")
public class PainterController extends AbstractApplicationController {
    
    @RequestMapping
    public String getDefaultPage() {
        return "development/painter/editor";
    }
    
    @RequestMapping(value = "/editor")
    public String getEditorPage() {
        return "development/painter/editor";
    }
}
