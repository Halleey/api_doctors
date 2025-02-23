package com.hosp.doctors.configs;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

@Configuration
public class JsonProducerConfig {

    private final KafkaProperties properties;

    public JsonProducerConfig(KafkaProperties properties) {
        this.properties = properties;
    }

    @Bean
    ProducerFactory jsonProducerFactory() {
        var configs = new HashMap<String, Object>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return  new DefaultKafkaProducerFactory(configs, new StringSerializer(), new org.springframework.kafka.support.serializer.JsonSerializer());
    }

    @Bean
    KafkaTemplate<String, Serializer> kafkaTemplate(ProducerFactory jsonProducerFactory) {
       return new KafkaTemplate<>(jsonProducerFactory);
    }
}
