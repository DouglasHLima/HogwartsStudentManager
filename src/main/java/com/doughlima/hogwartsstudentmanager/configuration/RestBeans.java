package com.doughlima.hogwartsstudentmanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;


@Configuration
public class RestBeans {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders httpHeaders(){
        return new HttpHeaders();
    }

}
