package com.example.Buns.Mod1.Case4;

import org.springframework.stereotype.Component;

@Component
public class Dog4 implements Pet4 {
    @Override
    public void say() {
        System.out.println("Dog4: Bow-wow");
    }
}
