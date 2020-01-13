package com.chinasofti.postbar.pbpostmapper;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.chinasofti.postbar.pbpostmapper.mapper"})
@EnableDistributedTransaction
public class PbPostMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(PbPostMapperApplication.class, args);
    }

}
