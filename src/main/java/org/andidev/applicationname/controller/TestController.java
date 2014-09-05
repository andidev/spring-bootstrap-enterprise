package org.andidev.applicationname.controller;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping({"/test"})
public String test(Model model) {
    Object viewModel = new Object();
    model.addAttribute("object", viewModel);
    return "pages/test";
}

//public static class Object {
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private DateTime currentDate = DateTime.now();
//    private List<NestedObject> nestedObjectInList = Arrays.asList(new NestedObject());
//    // ...Getters and Setters
//}
//
//public static class NestedObject {
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private DateTime nestedCurrentDate = DateTime.now().minus(1000);
//}


@Getter
@Setter
public static class Object {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private DateTime currentDate = DateTime.now();
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private List<DateTime> currentDateInList = Arrays.asList(DateTime.now());
    private NestedObject nestedObject = new NestedObject();
    private List<NestedObject> nestedObjectInList = Arrays.asList(new NestedObject());
    // ...Getters and Setters
}

@Getter
@Setter
public static class NestedObject {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private DateTime nestedCurrentDate = DateTime.now().minus(1000);
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private List<DateTime> nestedCurrentDateInList = Arrays.asList(DateTime.now());
}
}
