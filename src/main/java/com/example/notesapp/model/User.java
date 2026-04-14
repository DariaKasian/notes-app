package com.example.notesapp.model;

import jakarta.persistence.*; //--инстр. для раб. с бд.
//Это часть JPA (Java Persistence API)

//@Entity → класс = таблица (энтити
//@Id → первичный ключ
//@GeneratedValue → ID генерируется автоматически (дженэрейтед вэлью
//@Column → настройка колонки (колэм
//@Table → имя таблицы

@Entity //→ создаётся таблица user
@Table(name = "users")
public class User {
    @Id //→ уникальный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID генерируется автоматически
    //strategy = ... → как именно генерируется
    private Long id;
    //👉 эти переменные = данные, которые будут храниться в базе
    private String username;
    private String password;

    public User() {}
    //@Entity → ВСЕГДА добавляй пустой конструктор


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


//Getter --> wenn man Private Feld benutzen
//Setter-->diese Method setzt eine neue Wert, braucht die Parametr