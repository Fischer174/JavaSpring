package com.example.Buns.Mod1.Case4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myPerson4")
public class Person4 {
    private Pet4 pet4;

    @Value("${person4.surname}")
    private String surname;

    @Value("${person4.age}")
    private int age;

    @Autowired
    public Person4(@Qualifier("dog4") Pet4 pet4) {
        this.pet4 = pet4;
        System.out.println("Person is created");
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet4.say();
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
