package com.concept.sendgrid.controller;

import com.concept.sendgrid.model.EmailRequest;
import com.concept.sendgrid.service.EmailService;
import com.sendgrid.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<Response> send(@RequestBody EmailRequest request) {
        return new ResponseEntity<>(emailService.sendEmail(request), HttpStatus.ACCEPTED);
    }
}
