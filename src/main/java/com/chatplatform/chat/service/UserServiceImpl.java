package com.chatplatform.chat.service;

import com.chatplatform.chat.Entity.User;
import com.chatplatform.chat.dto.UserRequest;
import com.chatplatform.chat.dto.UserResponse;
import com.chatplatform.chat.exception.ResourceNotFoundException;
import com.chatplatform.chat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setStatus("ACTIVE");

        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public UserResponse getUserById(Long id) {
         User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id"+ id));
        return mapToResponse(user);
    }

    private UserResponse mapToResponse(User user){
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setStatus(user.getStatus());
        return response;
    }
}
