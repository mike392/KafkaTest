package com.study.kafkatest.snapshot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractResourceBasedMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by Tanyusha on 16.08.2017.
 */
@Configuration
public class AppConfig {

    @Bean
    public AbstractResourceBasedMessageSource getMessageBundle(){
        AbstractResourceBasedMessageSource resource = new ResourceBundleMessageSource();
        resource.setBasename("application");
        return resource;
    }
}
