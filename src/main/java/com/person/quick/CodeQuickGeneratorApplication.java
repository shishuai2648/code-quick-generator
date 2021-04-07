package com.person.quick;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.person.quick.mapper"})
public class CodeQuickGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeQuickGeneratorApplication.class, args);
    }

}
