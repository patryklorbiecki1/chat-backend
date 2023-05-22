package pl.backend.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.backend.chat.model.User;
import pl.backend.chat.repository.UserRepository;

import java.util.List;

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
    public User add(User user){
       userRepository.save(user);
       return user;
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
