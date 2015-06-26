/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcint.sonnevendl.springactivemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import java.net.URI;

/**
 * @author Gergely Jakab
 */
@SpringBootApplication
public class WebApplication {

    public static final String BROKER_URL = "broker:tcp://localhost:61616";

    @Bean
    public BrokerService broker() throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.addConnector(new URI(BROKER_URL));
        brokerService.setPersistent(false);
        return brokerService;
    }

    @Bean
    public ActiveMQConnectionFactory amqConnectionFactory() {
        return new ActiveMQConnectionFactory("tcp://HN5NWX1:61616");
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(amqConnectionFactory());
    }

    @Bean
    public ActiveMQQueue defaultDestination() {
        return new ActiveMQQueue("Send2Recv");
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestination(defaultDestination());
        return jmsTemplate;
    }

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder().sources(WebApplication.class).showBanner(false).run();
    }

}

