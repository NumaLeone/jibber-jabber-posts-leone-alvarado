package com.ingsis.jibberjabberposts.Model;

import javax.persistence.*;

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
    private String userId;
    private String message;
    private int length;
    private int maxLength = 140;

    public Post(Long id, String userId, String message) {
        this.id = id;
        this.userId = userId;
        this.message = message;
    }

    public Post(String message, String userId) {
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

    public String getUserId() {
        return userId;
    }

    public int getLength() {return length;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLength(int length) {this.length = length;}
}
