package com.tqsm.life;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@MapperScan(basePackages = "com.tqsm.life.mapper")
@SpringBootApplication(scanBasePackages = "com.tqsm.life")
public class LifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeApplication.class, args);
    }

}
