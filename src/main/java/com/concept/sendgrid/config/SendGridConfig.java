package com.concept.sendgrid.config;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendGridConfig {

    @Value("${sendgrid.key}")
    private String sendgridKey;

    @Bean
    public SendGrid getSendgrid() {
        return new SendGrid(sendgridKey);
    }
}
