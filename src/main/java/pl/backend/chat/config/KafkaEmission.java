package pl.backend.chat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pl.backend.chat.model.Message;
import pl.backend.chat.repository.ChatMessageBus;

@Component
public class KafkaEmission implements ChatMessageBus {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    @Autowired
    public KafkaEmission(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void emit(Message message) {
        kafkaTemplate.send("chat",message);
    }
}
