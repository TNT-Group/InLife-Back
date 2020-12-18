package ru.InLife.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Autowired
    @Transient
    @JsonIgnore
    private PasswordEncoder passwordEncoder;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role_name")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
    private ZonedDateTime createdTime = ZonedDateTime.now();
    private ZonedDateTime updatedTime = createdTime;

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }

    public User(){}

    public User(PasswordEncoder passwordEncoder, Long id, String username, String password, String email, String firstname, String lastname, Role role, Status status) {
        this.passwordEncoder = passwordEncoder;
        this.id = id;
        this.username = username;
        this.password = passwordEncoder.encode(password);
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.status = status;
    }
}
