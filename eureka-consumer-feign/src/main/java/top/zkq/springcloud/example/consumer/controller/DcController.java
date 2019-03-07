package top.zkq.springcloud.example.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zkq.springcloud.example.consumer.client.DcClient;

import javax.annotation.Resource;

@RestController
public class DcController {

    @Resource
    DcClient dcClient;

    @GetMapping("/consumer")
    public String dc() {
         return dcClient.hello();
    }
}
