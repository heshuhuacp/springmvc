package com.springmvc.demo.controller;

import com.springmvc.demo.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj demoObj) throws Exception{

        throw new IllegalAccessException("非常抱歉， 参数有误/" + "来自@ModelAttribute："
                + msg);


    }
}
