package org.andidev.applicationname.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {
    //ConversionNotSupportedException	500 (Internal Server Error)
    //HttpMediaTypeNotAcceptableException	406 (Not Acceptable)
    //HttpMediaTypeNotSupportedException	415 (Unsupported Media Type)
    //HttpMessageNotReadableException	400 (Bad Request)
    //HttpMessageNotWritableException	500 (Internal Server Error)
    //HttpRequestMethodNotSupportedException	405 (Method Not Allowed)
    //MissingServletRequestParameterException	400 (Bad Request)
    //NoSuchRequestHandlingMethodException	404 (Not Found)
    //TypeMismatchException	400 (Bad Request)

//    @ExceptionHandler(Throwable.class)
//    protected String handleRuntimeException(RuntimeException ex, HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//        return "pages/error";
//    }

}
