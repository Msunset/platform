package com.platform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PayController {
    @RequestMapping("/result")
    public String result(){
        return "支付回调成功";
    }
}
