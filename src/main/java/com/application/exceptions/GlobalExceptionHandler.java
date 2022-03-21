package com.application.exceptions;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        if (e.getMessage() != null && !e.getMessage().isEmpty()) {
            mav.addObject("messages", e.getMessage());
        } else {
            mav.addObject("messages",
                    Arrays.stream(e.getStackTrace()).map(StackTraceElement::toString).collect(Collectors.toList()));
        }
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
