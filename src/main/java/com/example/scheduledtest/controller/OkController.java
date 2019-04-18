package com.example.scheduledtest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className OkController
 * @Description
 * @Date 2019/4/16 13:32
 * @Author shenguang
 * @Version 1.0
 **/
@RestController
public class OkController {
    @RequestMapping(value = "/getsomething",method = RequestMethod.POST)
    public String getsomething(){
        return "getsomething";
    }
}
