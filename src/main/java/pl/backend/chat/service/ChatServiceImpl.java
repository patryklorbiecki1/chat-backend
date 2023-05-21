package pl.backend.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.backend.chat.repository.ChatRepository;

@Service
public class ChatServiceImpl implements ChatService{
    private final ChatRepository chatRepository;
    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }



}
