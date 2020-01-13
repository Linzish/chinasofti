package com.chinasofti.postbar.pbregistermapper;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.chinasofti.postbar.pbregistermapper.mapper"})
@EnableDistributedTransaction
public class PbRegisterMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(PbRegisterMapperApplication.class, args);
    }

}
