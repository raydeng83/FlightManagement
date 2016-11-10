package com.flightmanagement.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by z00382545 on 11/10/16.
 */

@Service
public class SenderService {

    @Autowired
    private RabbitMessagingTemplate template;

    @Bean
    Queue queue() {
        return new Queue("SearchQ", false);
    }

    @Bean
    Queue queue1() {
        return new Queue("CheckINQ", false);
    }

    public void send(Object message) {
        template.convertAndSend("SearchQ", message);
    }



}
