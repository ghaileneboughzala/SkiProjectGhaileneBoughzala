package com.example.skighailene.aspects;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public Map<String, String> HandleException(Exception exception){

    }
}
