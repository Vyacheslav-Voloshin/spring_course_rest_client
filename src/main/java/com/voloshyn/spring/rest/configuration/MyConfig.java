package com.voloshyn.spring.rest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.voloshyn.spring.rest")
public class MyConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
