package com.chinasofti.postbar.postbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableRedisHttpSession
public class PostbarApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostbarApplication.class, args);
    }

}
