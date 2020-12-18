package ru.InLife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.InLife.model.Message;
import ru.InLife.model.Role;
import ru.InLife.model.Status;
import ru.InLife.model.User;
import ru.InLife.repository.UserRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateById(Long id, Map<String, Object> fields) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            return null;
        }
        fields.forEach((fieldName, fieldValue) -> {

            if (fieldName.equals("username")){
                user.setUsername((String)fieldValue);
            }
            if (fieldName.equals("password")){
                user.setPassword((String)fieldValue);
            }
            if (fieldName.equals("email")){
                user.setEmail((String)fieldValue);
            }
            if (fieldName.equals("firstname")){
                user.setFirstname((String)fieldValue);
            }
            if (fieldName.equals("lastname")){
                user.setLastname((String)fieldValue);
            }
            if (fieldName.equals("role")){
                user.setRole(Role.valueOf((String)fieldValue));
            }
            if (fieldName.equals("status")) {
                user.setStatus(Status.valueOf((String)fieldValue));
            }
        });
        user.setUpdatedTime(ZonedDateTime.now());
        saveUser(user);
        return user;
    }
}
