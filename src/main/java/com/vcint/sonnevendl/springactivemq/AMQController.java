package com.vcint.sonnevendl.springactivemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.websocket.server.PathParam;

/**
 * AMQController
 *
 */
@RestController
@RequestMapping("send")
public class AMQController {

    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping(value = "{text}",method = RequestMethod.GET)
    public ResponseEntity<String> some(@PathVariable("text")final String text){
        MessageCreator messageCreator = session -> session.createTextMessage(text);
        jmsTemplate.send("mailbox-destination", messageCreator);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


}
