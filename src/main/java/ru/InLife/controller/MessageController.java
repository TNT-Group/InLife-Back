package ru.InLife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.InLife.model.Message;
import ru.InLife.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> findAll(){
        return messageService.findAll();
    }

    @GetMapping("/{id}")
    public Message findById(@PathVariable("id") Long id){
        return messageService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message saveMessage(@RequestBody Message message){
        return messageService.saveMessage(message);
    }

    //DANGER
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        messageService.deleteById(id);
    }
}
