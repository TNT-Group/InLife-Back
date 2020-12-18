package ru.InLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.InLife.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
