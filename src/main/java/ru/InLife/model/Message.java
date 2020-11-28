package ru.InLife.model;

import lombok.Data;

import javax.persistence.*;

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
    //TODO
    //Add data and integration with user table(add user table)
}
