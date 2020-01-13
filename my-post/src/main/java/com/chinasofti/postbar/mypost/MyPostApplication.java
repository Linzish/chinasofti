package com.chinasofti.postbar.mypost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableRedisHttpSession
public class MyPostApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPostApplication.class, args);
    }

}
