package com.dangui.namrata;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.dangui.namrata.model.*;



@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private CustomerRepository repository;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {


        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            //repository.deleteAll();
            //repository.save(new Customer("Alice", "Smith"));
            //repository.save(new Customer("Bob", "Smith"));

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
