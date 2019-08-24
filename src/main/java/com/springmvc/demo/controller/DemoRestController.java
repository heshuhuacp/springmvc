package com.springmvc.demo.controller;

import com.springmvc.demo.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getJson", produces = "application/json;charset=UTF-8")
    public DemoObj getJson(@RequestBody DemoObj obj){
        return new DemoObj(obj.getId()+1, obj.getName());
    }
}
