package com.jzh.cq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.jzh")
@SpringBootApplication
public class SpringCQApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringCQApplication.class, args);

        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
            System.out.println(applicationContext.getBean(name));
        }
    }

}
