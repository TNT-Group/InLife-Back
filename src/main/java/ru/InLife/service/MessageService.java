package ru.InLife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.InLife.model.Message;
import ru.InLife.repos.MessageRepo;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public Message findById(Long id){
        return messageRepo.findById(id).orElse(null);
    }

    public List<Message> findAll(){
        return messageRepo.findAll();
    }

    public Message saveMessage(Message message){
        return messageRepo.save(message);
    }

    public void deleteById(Long id){
        messageRepo.deleteById(id);
    }
}
