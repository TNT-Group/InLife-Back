package ru.InLife.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "Empty message")
    @Size(min = 1, max = 255, message = "Wrong size of message")
    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    private String message;
    //TODO
    //Add data and integration with user table(add user table)
}
