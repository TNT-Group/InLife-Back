package ru.InLife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.InLife.model.Chat;
import ru.InLife.service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chats")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('permission:read')")
    public List<Chat> findAll(){
        return chatService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('permission:read')")
    public Chat findById(@PathVariable("id") Long id){
        return chatService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('permission:write')")
    public Chat saveChat(@RequestBody Chat chat){
        return chatService.saveChat(chat);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('permission:write')")
    public void deleteById(@PathVariable("id") Long id) {
        chatService.deleteById(id);
    }

}
