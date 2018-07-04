package br.com.microservices.user.msuser.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import br.com.microservices.user.msuser.domainobject.UserDO;

public class Sender
{

    @Autowired
    private KafkaTemplate<String, UserDO> kafkaTemplate;


    public void send(String topic, UserDO payload)
    {
        this.kafkaTemplate.send(topic, payload);
    }
}
