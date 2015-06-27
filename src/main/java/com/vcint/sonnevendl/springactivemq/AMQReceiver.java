package com.vcint.sonnevendl.springactivemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by lorincsonnevend on 27/06/15.
 */
@Component
public class AMQReceiver {

    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    @JmsListener(destination = "mailbox-destination")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
