package ru.InLife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.InLife.model.Chat;
import ru.InLife.repository.ChatRepository;

import java.util.List;

@Service
public class ChatService {

    private final ChatRepository chatRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat findById(Long id) {
        return chatRepository.findById(id).orElse(null);
    }

    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    public Chat saveChat(Chat chat) {
        return chatRepository.save(chat);
    }

    public void deleteById(Long id) {
        chatRepository.deleteById(id);
    }

//    public Chat updateById(Long id, Map<String, Object> fields) {
//        Chat chat = chatRepository.findById(id).orElse(null);
//        if (chat == null){
//            return null;
//        }
//        fields.forEach((fieldName, fieldValue) -> {
//            if (fieldName.equals(""))
//        });
//    }
}
