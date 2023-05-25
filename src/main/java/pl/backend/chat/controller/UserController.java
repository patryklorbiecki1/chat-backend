package pl.backend.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.backend.chat.dto.request.CreateUserRequest;
import pl.backend.chat.model.User;
import pl.backend.chat.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request){
        return new ResponseEntity<>(userService.add(request), HttpStatus.CREATED);
    }
}
