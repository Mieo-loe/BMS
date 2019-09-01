package com.tencent.util.expection;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ErrorExpectionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ErrorExpection errorExpection =null;
        if(ex instanceof ErrorExpection){
            errorExpection = (ErrorExpection) ex;
        }else {
            ex=new ErrorExpection("系统维护中");
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error/error");
        modelAndView.addObject("msg", ex);
        return modelAndView;
    }
}
