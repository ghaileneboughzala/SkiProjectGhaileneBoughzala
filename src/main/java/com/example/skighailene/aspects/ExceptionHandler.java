package com.example.skighailene.aspects;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public Map<String, String> HandleException(Exception exception){

        Map map = new HashMap<>();
        map.put("Erreur ya fathi", exception.getMessage());
        return map;

    }
}
