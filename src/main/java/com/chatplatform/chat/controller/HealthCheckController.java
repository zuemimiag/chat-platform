package com.chatplatform.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/api/healthCheck")
    public String healthCheck(){
        return "Chat Platform is running.!";
    }
}
