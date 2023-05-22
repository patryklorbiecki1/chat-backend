package pl.backend.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.backend.chat.model.Chat;
import pl.backend.chat.repository.ChatRepository;

@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserService userService;
    @Autowired
    public ChatService(ChatRepository chatRepository, UserService userService) {
        this.chatRepository = chatRepository;
        this.userService = userService;
    }

    public Chat getChatByName(String name){
        return chatRepository.findByName(name);
    }

    public Chat createOrGetChat(String name) {
        Chat chat = chatRepository.findByName(name);
         if(chat !=null){
             return chat;
         }  else{
             Chat newChat = new Chat();
             newChat.setName(name);
             newChat.setOrigin(userService.findByUsername(name.split("&")[0]));
             newChat.setDest(userService.findByUsername(name.split("&")[1]));
             return chatRepository.save(newChat);
         }
    }

}
