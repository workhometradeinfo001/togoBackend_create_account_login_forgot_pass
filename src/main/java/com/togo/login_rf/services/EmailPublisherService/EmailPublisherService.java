package com.togo.login_rf.services.EmailPublisherService;

import com.togo.login_rf.config.EmailRabbitConfig;
import com.togo.login_rf.record.email_record.EmailObjRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailPublisherService {

    private final AmqpTemplate amqpTemplate;

    public void queueEmail(String recipient, String subject, String body){
        EmailObjRecord emailObjRecord = new EmailObjRecord(recipient, subject, body);
        amqpTemplate.convertAndSend(
                EmailRabbitConfig.EXCHANGE_NAME,
                EmailRabbitConfig.ROUTING_KEY,
                emailObjRecord
        );
    }

}
