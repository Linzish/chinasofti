package com.chinasofti.postbar.audiosetup;

import com.chinasofti.postbar.audiosetup.basic.BasicController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableRedisHttpSession
public class AudioSetupApplication {

    public static void main(String[] args) {
        SpringApplication.run(AudioSetupApplication.class, args);
    }

}
