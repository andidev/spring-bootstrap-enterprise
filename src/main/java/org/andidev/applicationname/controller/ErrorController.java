package org.andidev.applicationname.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ErrorController extends AbstractApplicationController {

    @RequestMapping(value = "/pagenotfound")
    public String pagenotfound(Model model, HttpServletRequest request) {
        model.addAttribute("errorCode", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        model.addAttribute("errorMessage", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));

        return "pages/pagenotfound";
    }

    @RequestMapping(value = "/error")
    public String error(Model model, HttpServletRequest request) {
        model.addAttribute("errorCode", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        model.addAttribute("errorMessage", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        model.addAttribute("errorException", ((Class) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE)).getName());
//        model.addAttribute("errorExceptionStackTrace", ExceptionUtils.getStackTrace((Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE)));
//        Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
//        if (throwable != null) {
////            model.addAttribute("errorExceptionStackTrace", throwable.getMessage());
//        }

        return "pages/error";
    }

    @RequestMapping("/throw")
    public String throwss(Model model, HttpServletRequest request) {
        throw new RuntimeException();
    }
}
