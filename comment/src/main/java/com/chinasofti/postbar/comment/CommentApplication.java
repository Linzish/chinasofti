package com.chinasofti.postbar.comment;

import com.chinasofti.postbar.comment.basic.BasicController;
import com.chinasofti.postbar.comment.util.AudioSynthesis;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
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
@EnableDistributedTransaction
public class CommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class, args);
    }

}
