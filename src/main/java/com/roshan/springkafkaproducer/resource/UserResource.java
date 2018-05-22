package com.roshan.springkafkaproducer.resource;

import com.roshan.springkafkaproducer.model.User;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ali akbar azizkhani
 */
@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    private final String TOPIC = "Kafka_Example";

    @GetMapping("/publish/{username}")
    public String publishMessage(@PathVariable("username") String username) {

        User user = new User(username, "Baharan", 1000L);
        //kafkaTemplate.send(TOPIC, user);
        Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC,TOPIC).build();
        //kafkaTemplate.send(message);

        kafkaTemplate.send(new GenericMessage<>(user));

        return username;
    }
}
