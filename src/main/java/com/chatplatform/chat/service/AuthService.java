package com.chatplatform.chat.service;

import com.chatplatform.chat.dto.AuthRequest;
import com.chatplatform.chat.dto.AuthResponse;

public interface AuthService {

    AuthResponse login(AuthRequest request);
}