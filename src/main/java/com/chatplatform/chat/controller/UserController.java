package com.chatplatform.chat.controller;

import com.chatplatform.chat.Entity.User;
import com.chatplatform.chat.dto.UserRequest;
import com.chatplatform.chat.dto.UserResponse;
import com.chatplatform.chat.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@Valid @RequestBody UserRequest request){
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> getAllUsers(){

        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){

        return userService.getUserById(id);
    }
}
