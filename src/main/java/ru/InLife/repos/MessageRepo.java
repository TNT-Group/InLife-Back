package ru.InLife.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.InLife.model.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {

}
