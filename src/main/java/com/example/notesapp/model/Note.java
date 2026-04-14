package com.example.notesapp.model;

import jakarta.persistence.*;

@Entity //Entity (сущность), — это аннотация,
public class Note {

    public Note() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Long userId;

    public Note(String content, Long userId) {
        this.content = content;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
