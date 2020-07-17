package com.shu.aoptest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class AopTestController {

    @Autowired
    AopTestService aopTestService;

    @RequestMapping("/aoptest")
    public void test(){
        aopTestService.a();

        System.out.println("=========");
        aopTestService.b();
    }
}
