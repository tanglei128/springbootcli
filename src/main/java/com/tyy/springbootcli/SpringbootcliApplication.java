package com.tyy.springbootcli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.tyy.springbootcli.mapper")
@SpringBootApplication
public class SpringbootcliApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootcliApplication.class, args);
    }

}
