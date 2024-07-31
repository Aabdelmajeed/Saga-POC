package com.common.shipping.service.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
//TODO jms

@Component
public class JmsConsumer {
    @JmsListener(destination = "test.queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
