package pl.backend.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.backend.chat.dto.request.CreateUserRequest;
import pl.backend.chat.dto.response.MessageResponse;
import pl.backend.chat.model.Role;
import pl.backend.chat.model.User;
import pl.backend.chat.repository.UserRepository;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String name){
        return userRepository.findByUsername(name);
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public MessageResponse add(CreateUserRequest request){
       if(Boolean.TRUE.equals(userRepository.existsByUsername(request.getUsername()))){
           return MessageResponse.builder()
                   .message("[ERROR] Username: " + request.getUsername() + " is already taken!").build();
       }
       if(Boolean.TRUE.equals(userRepository.existsByEmail(request.getEmail()))){
           return MessageResponse.builder()
                   .message("[ERROR] Email: " + request.getEmail() + " is already taken!").build();
       }
       User user = User.builder()
               .username(request.getUsername())
               .email(request.getEmail())
               .number(request.getNumber())
               .password(request.getPassword())
               .roles(Set.of(Role.ROLE_USER))
               .build();
        userRepository.save(user);
        return MessageResponse.builder()
                .message("User: " + user.getUsername() + " created successfully")
                .build();
    }
    public User updateUser(User user){
        User existing = userRepository.findByUsername(user.getUsername());
        existing.setNumber(user.getNumber());
        existing.setPassword(user.getPassword());
        return userRepository.save(existing);
    }
    public void removeUser(String username){
        User existing = userRepository.findByUsername(username);
        userRepository.delete(existing);
    }
//    public User findByUserToken(){
//
//    }

}
