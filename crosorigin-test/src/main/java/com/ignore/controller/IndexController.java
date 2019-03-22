package com.ignore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-03-22
 **/
@Controller
public class IndexController {
    @GetMapping(value = "/index")
    public String test(){
        return "index";
    }
}
