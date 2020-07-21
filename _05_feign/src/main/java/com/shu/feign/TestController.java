package com.shu.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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


    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("restTemplateRibbon")
    private RestTemplate restTemplateRibbon;



    @GetMapping("/feigntest")
    public String feigntest() {
        String result = feignClientInter.home("feign调用");
        return "调用返回值:" +result;
    }

    @GetMapping("/ribbontest")
    public String ribbontest() {
      ResponseEntity<String> responseEntity= restTemplateRibbon.getForEntity("http://SERVICE-HI/hi/name={1}",String.class,"asdf");
        String body = responseEntity.getBody();

        return "调用返回值:" +body;
    }

    @GetMapping("/noribbontest")
    public String test() {
        ResponseEntity<String> responseEntity= restTemplate.getForEntity("http://SERVICE-HI/hi/name={1}",String.class,"asdf");
//        ResponseEntity<String> responseEntity= restTemplate.getForEntity("http://127.0.0.1:8764/hi/name={1}",String.class,"asdf");
        String body = responseEntity.getBody();

        return "调用返回值:" +body;
    }
}
