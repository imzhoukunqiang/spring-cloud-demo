package top.zkq.springcloud.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author zkq
 * @version 1.0
 * @date 2019/3/7 11:19
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
