package com.jnucst2015.dropshopping_cmdtmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jnucst2015.dropshopping", "com.jnucst2015.dropshopping_cmdtmgmt"})
public class DropshoppingCmdtmgmtApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DropshoppingCmdtmgmtApplication.class, args);
    }
}
