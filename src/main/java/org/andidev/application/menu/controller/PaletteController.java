package org.andidev.application.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/development/painter/palette")
public class PaletteController {

    @RequestMapping
    public String getDefaultPage() {
        return "application/development/painter/palette/overview";
    }

    @RequestMapping(value = "/overview")
    public String getOverviewPage() {
        return "application/development/painter/palette/overview";
    }

    @RequestMapping(value = "/button")
    public String getButtonPage() {
        return "application/development/painter/palette/button";
    }

    @RequestMapping(value = "/color")
    public String getColorPage() {
        return "application/development/painter/palette/color";
    }

    @RequestMapping(value = "/data")
    public String getDataPage() {
        return "application/development/painter/palette/data";
    }

    @RequestMapping(value = "/label")
    public String getLabelPage() {
        return "application/development/painter/palette/label";
    }

    @RequestMapping(value = "/layout")
    public String getLayoutPage() {
        return "application/development/painter/palette/layout";
    }

    @RequestMapping(value = "/menu")
    public String getMenuPage() {
        return "application/development/painter/palette/menu";
    }

    @RequestMapping(value = "/notification")
    public String getNotificationPage() {
        return "application/development/painter/palette/notification";
    }

    @RequestMapping(value = "/size")
    public String getSizePage() {
        return "application/development/painter/palette/size";
    }
}