package br.com.microservices.user.msmail.receiver;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import br.com.microservices.user.msmail.datatransferobject.UserDTO;
import br.com.microservices.user.msmail.service.EmailService;

public class Receiver
{
    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private EmailService emailService;


    @KafkaListener(topics = "${spring.kafka.topic.userCreated}")
    public void receive(UserDTO payload)
    {
        this.emailService.sendSimpleMessage(payload);
        this.latch.countDown();
    }
}
