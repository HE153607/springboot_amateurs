package com.boot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {

    ApplicationContext context= SpringApplication.run(SpringbootApplication.class, args);
//    System.out.println("repository ="+context.getBean(UserRespository.class));
    }
}
