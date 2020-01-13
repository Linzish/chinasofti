package com.chinasofti.postbar.txlcntm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagerServer    //开启分布式事务管理
public class TxlcnTmApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxlcnTmApplication.class, args);
    }

}
