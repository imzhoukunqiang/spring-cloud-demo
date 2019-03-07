package top.zkq.springcloud.example.consumer;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zkq
 * @version 1.0
 * @date 2019/3/7 11:19
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerFeignApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class, args);
    }

    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
