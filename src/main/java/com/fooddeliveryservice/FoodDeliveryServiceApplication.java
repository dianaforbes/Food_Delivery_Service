package com.fooddeliveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, SecurityAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.fooddeliveryservice.fooddeliveryservice.Config", "com.fooddeliveryservice.fooddeliveryservice.Controller", "com.fooddeliveryservice.fooddeliveryservice.Entity", "com.fooddeliveryservice.fooddeliveryservice.Repository", "com.fooddeliveryservice.fooddeliveryservice.Service"})
public class FoodDeliveryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodDeliveryServiceApplication.class, args);
    }

}
