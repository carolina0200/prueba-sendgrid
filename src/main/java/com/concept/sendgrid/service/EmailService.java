package com.concept.sendgrid.service;

import com.concept.sendgrid.model.EmailRequest;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    SendGrid sendGrid;

    public Response sendEmail(EmailRequest emailRequest) {
        Content content = new Content("text/plain", emailRequest.getBody());
        Mail mail = new Mail(new Email("caroliina20003@gmail.com"), emailRequest.getSubject(), new Email(emailRequest.getTo()), content);
        mail.setReplyTo(new Email("caroliina20003@gmail.com"));
        Request request = new Request();
        Response response = null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = this.sendGrid.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return response;
    }
}
