package com.example.demo.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Developer {

    private final Computer computer;

    public Developer(@Qualifier("laptop") Computer computer) {
        this.computer = computer;
    }

    public String build() {
        return computer.compile();
    }
}