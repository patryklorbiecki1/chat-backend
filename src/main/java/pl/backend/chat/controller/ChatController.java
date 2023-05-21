package pl.backend.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.chat.service.ChatService;

@RestController
public class ChatController {
    private final ChatService chatService;
    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
}
