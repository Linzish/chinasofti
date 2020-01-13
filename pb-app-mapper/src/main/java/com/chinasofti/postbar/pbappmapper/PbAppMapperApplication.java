package com.chinasofti.postbar.pbappmapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.chinasofti.postbar.pbappmapper.mapper"})
public class PbAppMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(PbAppMapperApplication.class, args);
    }

}
