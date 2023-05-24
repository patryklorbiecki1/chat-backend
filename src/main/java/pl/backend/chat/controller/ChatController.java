package pl.backend.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.chat.model.Chat;
import pl.backend.chat.model.Message;
import pl.backend.chat.service.ChatService;
import pl.backend.chat.service.MessageService;
import pl.backend.chat.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/")
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;
    private final MessageService messageService;
    private final UserService userService;
    @Autowired
    public ChatController(SimpMessagingTemplate messagingTemplate, ChatService chatService, MessageService messageService, UserService userService) {
        this.messagingTemplate = messagingTemplate;
        this.chatService = chatService;
        this.messageService = messageService;
        this.userService = userService;
    }
    @GetMapping("chat/{to}")
    public void sendMessage(String to, Message message){
        Chat chat = chatService.createOrGetChat(to);
        message.setChat(chat);
        message.setTimestamp(messageService.generateTimeStamp());
        message = messageService.save(message);
        messagingTemplate.convertAndSend("/topic/messages/" + to, message);

    }
    @GetMapping("/getMessages")
    public ResponseEntity<List<Message>> getMessages(@RequestParam String chatName){
        Chat chat = chatService.getChatByName(chatName);
        if(chat!=null){
            return ResponseEntity.ok(messageService.getMessagesByChatName(chatName));
        }
        return ResponseEntity.ok(new ArrayList<>());
    }
}
