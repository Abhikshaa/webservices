package com.example.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;



@Component
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    
   

    @Override
    public void sendEmail(String toAddress,String emailsubject,String emailbody) {
       
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setSubject(emailsubject);
        message.setText(emailbody);
        
        javaMailSender.send(message);
        
    }
}

