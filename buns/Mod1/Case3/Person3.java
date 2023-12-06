package com.example.Buns.Mod1.Case3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myPerson3")
public class Person3 {
    private Pet3 pet3;

    @Autowired
    public Person3(@Qualifier("dog3") Pet3 pet3) {
        this.pet3 = pet3;
        System.out.println("Person is created");
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet3.say();
    }
}
