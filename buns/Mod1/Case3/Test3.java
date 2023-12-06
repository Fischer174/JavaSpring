package com.example.Buns.Mod1.Case3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig3.class);

        Person3 person3 = context.getBean("myPerson3", Person3.class);
        person3.callYourPet();

        context.close();
    }
}
