package com.shu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: shurunlong
 * @create: 2020-07-01 16:28
 */
@RestController
@RequestMapping
public class Controller {



    /**
     * @param name
     * @return
     */
    @GetMapping("/hi/{name}")
    public String home(@PathVariable String name) {
        return "hi , 访问成功:" +name+"--来自02_eureka_client";
    }
}
