package com.example.demo.service;



import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    @Override
    public String compile() {
        return "Compiling and building project on Laptop...";
    }
}