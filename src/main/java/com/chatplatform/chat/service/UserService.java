package com.chatplatform.chat.service;

import com.chatplatform.chat.Entity.User;
import com.chatplatform.chat.dto.UserRequest;
import com.chatplatform.chat.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest user);

    List<UserResponse> getAllUser();

    UserResponse getUserById(Long id);
}
