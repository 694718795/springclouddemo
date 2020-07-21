package com.shu.feign;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: shurunlong
 * @create: 2020-06-30 17:43
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableAsync
public class feignApplication {

    public static void main(String[] args) {
        SpringApplication.run(feignApplication.class, args);
    }

    @Bean(name="restTemplateRibbon")
    @Qualifier("restTemplateRibbon")
    @LoadBalanced
    RestTemplate restTemplateRibbon() {
        return new RestTemplate();
    }

    @Bean(name="restTemplate")
    @Qualifier("restTemplate")
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
