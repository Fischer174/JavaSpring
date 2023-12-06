package com.example.Buns.Mod1.Case4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig4.class);

        Person4 person4 = context.getBean("person4", Person4.class);
        person4.callYourPet();
        System.out.println("Surname: " + person4.getSurname());
        System.out.println("Age: " + person4.getAge());

        Pet4 myPet4 = context.getBean("myPet4", Pet4.class);
        myPet4.say();

        context.close();
    }
}
