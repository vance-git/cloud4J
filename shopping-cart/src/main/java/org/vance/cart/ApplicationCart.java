package org.vance.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@EnableScheduling
@SpringBootApplication
public class ApplicationCart {
    public void main(String[] args){
        SpringApplication.run(ApplicationCart.class, args);
    }
//    /**
//     * 向Spring容器中定义RestTemplate对象
//     * @return
//     */
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

}
