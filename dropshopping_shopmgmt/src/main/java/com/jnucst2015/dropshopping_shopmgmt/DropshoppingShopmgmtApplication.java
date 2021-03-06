package com.jnucst2015.dropshopping_shopmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jnucst2015.dropshopping", "com.jnucst2015.dropshopping_shopmgmt"})
public class DropshoppingShopmgmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DropshoppingShopmgmtApplication.class, args);
    }
}
