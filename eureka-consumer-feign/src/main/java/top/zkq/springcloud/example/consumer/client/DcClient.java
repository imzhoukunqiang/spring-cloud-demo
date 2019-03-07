package top.zkq.springcloud.example.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zkq
 * @version 1.0
 * @date 2019/3/7 14:22
 */
@FeignClient("eureka-client")
public interface DcClient {
    @GetMapping("hello")
    String hello();
}
