package com.springmvc.demo.controller;

import com.springmvc.demo.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    /**
     * produsces可定制返回的response的媒体类型和字符集
     *
     * @param request
     * @return
     */
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access";
    }

    /**
     * @PathVariable接受路径参数
     *
     * @param str
     * @param request
     * @return
     */
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathvar(@PathVariable String str,
                                            HttpServletRequest request){

        return "url:" + request.getRequestURL() + "can access, str:" +str;

    }

    /**
     * 常规request参数获取，/anno/requestParam?id=1
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access, id: " +id;
    }

    /**
     * 演示解释参数到对象；
     *
     * @param obj
     * @param request
     * @return
     */
    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access, obj id:"
                + obj.getId() +" obj name:" +obj.getName();

    }

    /**
     * 映射不同的路径到相同的方法
     *
     * @param request
     * @return
     */
    @RequestMapping(value = {"/name1", "/name2"}
    , produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request){

        return "url:" + request.getRequestURL() + " can access";
    }

}
