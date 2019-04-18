package com.example.scheduledtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className ErrorController
 * @Description
 * @Date 2019/4/16 13:32
 * @Author shenguang
 * @Version 1.0
 **/
@RestController("/welcome")
public class ErrorController {
    @GetMapping("/myindex")
    public String getIndex(){
        return "index";
    }
}
