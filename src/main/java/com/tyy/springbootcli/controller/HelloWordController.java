package com.tyy.springbootcli.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HelloWordController {
    @RequestMapping("/helloworld")
    public String helloWord(){
        return "hello world";
    }
}
