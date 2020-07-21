package com.shu;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>一个Feign服务消费者接口</p>
 **/
@FeignClient(value = "service-hi", fallback = ServiceHiHystrix.class, configuration = MFeignConfig.class)
public interface ServiceHi {
    /**
     * <p>通过Feign伪Http客户端调用service-hi提供的服务</p>
     **/
    @GetMapping("/hi/{name}")
    String sayHiFromServiceHi(@PathVariable(value = "name") String name);
}
