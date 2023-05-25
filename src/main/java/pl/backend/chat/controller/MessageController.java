package pl.backend.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.backend.chat.dto.request.AddMessageRequest;
import pl.backend.chat.model.Message;
import pl.backend.chat.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/{chatName}")
    public List<Message> getMessagesByChat(@PathVariable String chatName){
        return messageService.getMessagesByChatName(chatName);
    }

    @PostMapping("/new")
    public ResponseEntity<?> addNewMessage(@RequestBody AddMessageRequest request){
        return new ResponseEntity<>(messageService.save(request), HttpStatus.CREATED);
    }
}
