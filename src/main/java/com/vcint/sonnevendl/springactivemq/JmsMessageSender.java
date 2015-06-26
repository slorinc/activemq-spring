package com.vcint.sonnevendl.springactivemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * JmsMessageSender
 *
 * @author <a href="mailto:lorinc.sonnevend@betvictor.com">Lorinc Sonnevend</a>
 *         6/26/2015
 */
@Service
public class JmsMessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;


    /**
     * send text to default destination
     * @param text
     */
    public void send(final String text) {

        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(text);
                return message;
            }
        });
    }

    /**
     * Simplify the send by using convertAndSend
     * @param text
     */
    public void sendText(final String text) {
        this.jmsTemplate.convertAndSend(text);
    }

    /**
     * Send text message to a specified destination
     * @param text
     */
    public void send(final Destination dest,final String text) {

        this.jmsTemplate.send(dest, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(text);
                return message;
            }
        });
    }

    public String get(final Destination dest){
                //this.jmsTemplate.receive(dest);
        return null;
    }
}