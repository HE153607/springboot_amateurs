package com.boot.springboot.model;

import org.springframework.context.annotation.Bean;

//@NoArgsConstructor
//@AllArgsConstructor
//@Component
public class Record {
public String name;
    @Bean
    Record record1(){
        System.out.println("come");
        return new Record();
    }
}
