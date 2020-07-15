package com.shu.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: shurunlong
 * @create: 2020-07-02 14:54
 */
@RestController
@RequestMapping
public class TestController {



    @Autowired
    private FeignClientInter feignClientInter;


    @GetMapping("/feigntest")
    public String feigntest() {
        String result = feignClientInter.home("feign调用");
        return "调用返回值:" +result;
    }
}
