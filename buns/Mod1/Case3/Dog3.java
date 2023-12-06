package com.example.Buns.Mod1.Case3;

import org.springframework.stereotype.Component;

@Component
public class Dog3 implements Pet3 {
    @Override
    public void say() {
        System.out.println("Dog3: Bow-wow");
    }
}
