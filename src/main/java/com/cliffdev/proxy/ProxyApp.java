package com.cliffdev.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProxyApp {
    public static void main(String [] args){
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProxyApp.class,args);
        applicationContext.registerShutdownHook();
        ProxyManager proxyManager = applicationContext.getBean(ProxyManager.class);
        proxyManager.execute();
    }
}
