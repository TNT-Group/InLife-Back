package ru.InLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.InLife.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
