package com.example.Buns.Mod1.Case2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig2.class);

        Person2 person2 = context.getBean("myPerson2", Person2.class);
        person2.callYourPet();

        context.close();
    }
}
