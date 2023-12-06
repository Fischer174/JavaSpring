package com.example.Buns.Mod1.Case2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myPerson2")
public class Person2 {
    private Pet2 pet2;

    @Autowired
    public Person2(@Qualifier("dog2") Pet2 pet2) {
        this.pet2 = pet2;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet2.say();
    }
}
