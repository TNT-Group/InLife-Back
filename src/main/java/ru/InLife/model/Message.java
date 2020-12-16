package ru.InLife.model;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    private String message;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private User author;
    private String author;
    @Enumerated(EnumType.STRING)
    private Status status;
    private ZonedDateTime createdTime = ZonedDateTime.now();
    private ZonedDateTime updatedTime = createdTime;
}
