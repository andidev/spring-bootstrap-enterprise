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
        model.addAttribute("errorStatusCode", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        model.addAttribute("errorMessage", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        model.addAttribute("errorRequestUri", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
        model.addAttribute("errorServletName", request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME));

        return "pages/pagenotfound";
    }

    @RequestMapping(value = "/error")
    public String error(Model model, HttpServletRequest request) {
        model.addAttribute("errorStatusCode", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        model.addAttribute("errorMessage", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        if (exceptionWasThrown(request)) {
            model.addAttribute("errorExceptionType", ((Class) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE)).getName());
            model.addAttribute("errorExceptionStackTrace", ExceptionUtils.getStackTrace((Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION)));
        }

        return "pages/error";
    }

    @RequestMapping("/throw")
    public String throwss(Model model, HttpServletRequest request) {
        throw new RuntimeException();
    }

    private static boolean exceptionWasThrown(HttpServletRequest request) {
        if (request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE) != null) {
            return true;
        } else {
            return false;
        }
    }
}
