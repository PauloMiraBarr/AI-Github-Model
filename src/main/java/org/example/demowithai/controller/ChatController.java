package org.example.demowithai.controller;

import org.example.demowithai.dto.ChatRequest;
import org.example.demowithai.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public String prompt(@RequestBody ChatRequest request) {
        return chatService.chat(request.getPrompt(), request.getModel());
    }
}
