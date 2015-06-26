package com.vcint.sonnevendl.springactivemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * AMQController
 *
 * @author <a href="mailto:lorinc.sonnevend@betvictor.com">Lorinc Sonnevend</a>
 *         6/26/2015
 */
@RestController
@RequestMapping("test")
public class AMQController {

    @Autowired
    JmsMessageSender jmsMessageSender;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> some(){
        jmsMessageSender.send("hello JMS");
        Queue queue = new ActiveMQQueue("AnotherDest");
        jmsMessageSender.send(queue, "hello Another Message");

        return new ResponseEntity<>("AAAA", HttpStatus.OK);
    }


}
