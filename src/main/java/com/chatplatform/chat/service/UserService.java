package com.chatplatform.chat.service;

import com.chatplatform.chat.Entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

    User getUserById(Long id);
}
