package com.togo.login_rf.component;

import com.togo.login_rf.config.EmailRabbitConfig;
import com.togo.login_rf.record.email_record.EmailObjRecord;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailQueueListener {

    @Autowired
    private JavaMailSender mailSender;

    @RabbitListener(queues = EmailRabbitConfig.QUEUE_NAME)
    public void handleEmailQueue(EmailObjRecord payload){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(payload.recipient());
        message.setSubject(payload.subject());
        message.setText(payload.body());
        mailSender.send(message);
    }

}
