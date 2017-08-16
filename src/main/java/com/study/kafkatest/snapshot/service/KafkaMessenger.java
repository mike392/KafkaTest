package com.study.kafkatest.snapshot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractResourceBasedMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Locale;

/**
 * Created by Tanyusha on 17.08.2017.
 */
public class KafkaMessenger {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private AbstractResourceBasedMessageSource messageSource;
    private String topic = messageSource.getMessage("topic.name", null, Locale.getDefault());


    public void sendMessage(String msg) {
        kafkaTemplate.send(topic, msg);
    }

    @KafkaListener(topics = "somename", group = "1")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }
}
