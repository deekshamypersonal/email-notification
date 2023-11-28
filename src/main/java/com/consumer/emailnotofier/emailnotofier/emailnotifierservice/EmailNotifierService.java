package com.consumer.emailnotofier.emailnotofier.emailnotifierservice;

import com.consumer.emailnotofier.emailnotofier.RequestModel.EmailNotifierModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.*;

@Service
public class EmailNotifierService {

    @Autowired
    private JavaMailSender mailSender;

    public static final String SYSTEM_EMAIL = "deekshautrip@gmail.com";

    @RabbitListener(queues = {"emailNotificationQueue1"})
    public void consumeJsonMessage(EmailNotifierModel emailNotifierModel) throws InterruptedException {

        sendEmailToAdmin(emailNotifierModel.getReceiverMail(),emailNotifierModel.getSubject(),
                emailNotifierModel.getMessage());

    }

    public void sendEmailToAdmin(String email,String subject,String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SYSTEM_EMAIL);
        message.setTo(email);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }







}
