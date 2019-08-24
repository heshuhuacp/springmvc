package com.springmvc.demo.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalhandlerAdvice {

    /**
     * @ExceptionHandler用于全局处理控制器里的异常
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler
    public ModelAndView exception(Exception exception, WebRequest request){

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    /**
     * @ModelAttribute注解将键值对添加到全局
     *
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg", "额外信息");
    }

    /**
     *通过@InitBinder注解定制WebDataBinder，此处演示忽略request中的id
     *
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){

        webDataBinder.setDisallowedFields("id");
    }


}
