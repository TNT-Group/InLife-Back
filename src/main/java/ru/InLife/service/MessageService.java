package ru.InLife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.InLife.model.Message;
import ru.InLife.model.Status;
import ru.InLife.repository.MessageRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

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

    public Message updateMessage(Long id, Map<String, Object> fields) {
        Message message = messageRepository.findById(id).orElse(null);
        if (message == null){
            return null;
        }
        fields.forEach((fieldName, fieldValue) -> {
            if (fieldName == "message") {
                message.setMessage((String)fieldValue);
//                Field field = ReflectionUtils.findField(Message.class, fieldName);
//                field.setAccessible(true);
//                ReflectionUtils.setField(field, message, fieldValue);
            }
        });
        message.setUpdatedTime(ZonedDateTime.now());
        message.setStatus(Status.UPDATED);
//        Field field = ReflectionUtils.findField(Message.class, "updatedTime");
//        field.setAccessible(true);
//        ReflectionUtils.setField(field, message, ZonedDateTime.now());
//        field = ReflectionUtils.findField(Message.class, "status");
//        field.setAccessible(true);
//        ReflectionUtils.setField(field, message, Status.UPDATED);
        saveMessage(message);
        return message;
    }

    public void deleteById(Long id){
        messageRepository.deleteById(id);
    }
}
