package org.andidev.application.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/development/painter")
public class PainterController {
    
    @RequestMapping
    public String getDefaultPage() {
        return "development/painter/editor";
    }
    
    @RequestMapping(value = "/editor")
    public String getEditorPage() {
        return "development/painter/editor";
    }
}
