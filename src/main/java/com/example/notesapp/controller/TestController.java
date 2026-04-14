package com.example.notesapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Аннотация Spring Framework
public class TestController {

    @GetMapping("/test") //(Аннотация)какой URL и какой тип запроса вызывает этот метод
    public String test() {
        return "HalloTest";
    }
}