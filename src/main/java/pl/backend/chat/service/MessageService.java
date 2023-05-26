package pl.backend.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.backend.chat.dto.request.AddMessageRequest;
import pl.backend.chat.model.Message;
import pl.backend.chat.repository.MessageRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessagesByChatName(String chatName) {
        return messageRepository.findAllByChat_Name(chatName);
    }
    public Message save(AddMessageRequest request) {
        Message message = Message.builder()
                .sender(request.sender())
                .content(request.content())
                .timestamp(LocalDate.now().toString())
                .build();

        messageRepository.save(message);
        return message;
    }

    public String generateTimeStamp() {

        return "TimeStamp todo";
    }
}
