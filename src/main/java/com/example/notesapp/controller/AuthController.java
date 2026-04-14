package com.example.notesapp.controller;

import com.example.notesapp.model.User;
import com.example.notesapp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
//Das ist ein Paket von Spring Boot, das dir hilft:
//HTTP-Anfragen zu verarbeiten (Web API bauen)

//Это класс, который принимает HTTP-запросы (API).
//“Этот класс — REST API, он обрабатывает HTTP-запросы и возвращает данные (обычно JSON)”
//“Этот класс принимает запросы с интернета и отвечает данными”
@RestController
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Sie speichert einen neuen Benutzer in der Datenbank.
    @PostMapping("/register")
    public User register (@RequestBody User user) {//@RequestBody-->“Возьми то, что пришло от пользователя, и запихни в объект User”
        return userRepository.save(user);
    }

    //“Если кто-то отправил запрос на /login — выполняй этот метод”
    @PostMapping("/login")
    public User Login(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername())
                .orElse(null);

        if (existingUser == null) {
            throw  new RuntimeException("User not found");
        }

        if(!existingUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        return existingUser;
    }


}

//import org.springframework.web.bind.annotation.*;
//🔧 Wofür genau?
//
//Mit diesem Import benutzt du Dinge wie:
//
//@RestController → macht deine Klasse zur API
//@PostMapping("/login") → reagiert auf Login-Request
//@GetMapping("/notes") → holt Daten fürs Frontend
//@RequestBody → nimmt JSON vom Frontend