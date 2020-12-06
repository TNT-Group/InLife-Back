package ru.InLife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.InLife.model.Message;
import ru.InLife.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message findById(Long id){
        return messageRepository.findById(id).orElse(null);
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public Message saveMessage(Message message){
        return messageRepository.save(message);
    }

    public void deleteById(Long id){
        messageRepository.deleteById(id);
    }
}
