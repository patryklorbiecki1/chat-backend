package pl.backend.chat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import pl.backend.chat.model.Message;

@Component
public class KafkaEventHandler {
    private SimpMessagingTemplate template;

    @Autowired
    public KafkaEventHandler(SimpMessagingTemplate template) {
        this.template = template;
    }
    @KafkaListener(topics = "chat",id = "chat-backend")
    public void listen(){
        Message message = Message.builder()
                .sender("bla")
                .content("text")
                .build();
        template.convertAndSend("/chat",message);
    }
}
