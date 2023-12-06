package com.example.Buns.Mod1.Case2;

import org.springframework.stereotype.Component;

@Component
public class Dog2 implements Pet2 {
    @Override
    public void say() {
        System.out.println("Bow-wow");
    }
}
