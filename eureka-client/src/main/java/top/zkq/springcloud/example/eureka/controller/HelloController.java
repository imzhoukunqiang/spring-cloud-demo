package top.zkq.springcloud.example.eureka.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;

/**
 * @author zkq
 * @version 1.0
 * @date 2019/3/7 10:46
 */
@RestController
public class HelloController {

    @Resource
    private DiscoveryClient discoveryClient;


    @RequestMapping("/hello")
    public String name() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        System.out.println("requestAttributes = " + requestAttributes);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println("services = " + services);
        return services;
    }

}
