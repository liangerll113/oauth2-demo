package com.xwdx.oauth2demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author metinkong
 * @date 2022/4/7 10:15
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/read")
    public String read(){
        return "read";
    }

    @RequestMapping("/write")
    public String write(){
        return "write";
    }

}
