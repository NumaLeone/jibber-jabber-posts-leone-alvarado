package com.ingsis.jibberjabberposts.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long id;
    private UUID userId;
    private String message;
    private int length;

    public Post(Long id, UUID userId, String message) {
        this.id = id;
        this.userId = userId;
        this.message = message;
    }

    public Post(String message, UUID userId) {
        this.message = message;
        this.userId = userId;
    }

    public Post() {

    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public UUID getUserId() {
        return userId;
    }

    public int getLength() {return length;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setLength(int length) {this.length = length;}
}
