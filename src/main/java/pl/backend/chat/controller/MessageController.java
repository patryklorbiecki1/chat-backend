package pl.backend.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.chat.service.MessageService;

@RestController
public class MessageController {
    private final MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
}
