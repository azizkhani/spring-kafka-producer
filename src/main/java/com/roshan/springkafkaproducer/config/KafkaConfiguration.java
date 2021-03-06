package com.roshan.springkafkaproducer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ali akbar azizkhani
 */
@Configuration
public class KafkaConfiguration {

    @Bean
    public ProducerFactory defaultKafkaProducerFactory(){

        Map<String, Object> config=new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return new DefaultKafkaProducerFactory(config);
    }


    @Bean
    public KafkaTemplate kafkaTemplate(){
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(defaultKafkaProducerFactory());
        kafkaTemplate.setMessageConverter(new StringJsonMessageConverter());
        kafkaTemplate.setDefaultTopic("Kafka_Example");
        return kafkaTemplate;
    }

}
