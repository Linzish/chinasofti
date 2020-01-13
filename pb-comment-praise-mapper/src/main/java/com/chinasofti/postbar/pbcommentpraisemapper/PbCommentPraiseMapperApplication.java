package com.chinasofti.postbar.pbcommentpraisemapper;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.chinasofti.postbar.pbcommentpraisemapper.mapper"})
@EnableDistributedTransaction
public class PbCommentPraiseMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(PbCommentPraiseMapperApplication.class, args);
    }

}
