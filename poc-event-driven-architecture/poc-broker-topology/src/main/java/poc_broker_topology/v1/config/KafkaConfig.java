package poc_broker_topology.v1.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJacksonJsonMessageConverter;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;
import org.springframework.messaging.Message;
import poc_broker_topology.v1.infra.amqp.dtos.NoteEventDto;

import java.util.HashMap;
import java.util.Map;

@Configuration
@AllArgsConstructor
@Slf4j
public class KafkaConfig {

    private final KafkaAdmin admin;

    @Bean
    public RecordMessageConverter messageConverter() {
        return new StringJacksonJsonMessageConverter();
    }

    @Bean
    public KafkaListenerErrorHandler topicErrorHandler() {
        return (m, e) -> {
            log.error("Error: {}; message: {}", e.getMessage(), m);
            log.error("Exception", e);
            return e.getMessage();
        };
    }

    @Bean
    public ConsumerFactory<String, NoteEventDto> consumerFactory() {
        Map<String, Object> props = new HashMap<>(admin.getConfigurationProperties());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JacksonJsonDeserializer.class);

        props.put(JacksonJsonDeserializer.VALUE_DEFAULT_TYPE, Message.class);
        props.put(JacksonJsonDeserializer.USE_TYPE_INFO_HEADERS, Boolean.FALSE);
        props.put(JacksonJsonDeserializer.TRUSTED_PACKAGES, "*");

        return new DefaultKafkaConsumerFactory<>(props);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, NoteEventDto> kafkaListenerContainer() {
        ConcurrentKafkaListenerContainerFactory<String, NoteEventDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


}
