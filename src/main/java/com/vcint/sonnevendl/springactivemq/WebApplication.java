/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcint.sonnevendl.springactivemq;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author Lorinc Sonnevend
 */
@SpringBootApplication
@EnableJms
public class WebApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder().sources(WebApplication.class).showBanner(false).run();
    }

}

