package com.example.Buns.Mod1.Case4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myApplication4.properties")
public class MyConfig4 {
    @Value("${pet4.name}")
    private String petName;

    @Bean
    public Pet4 dog4() {
        return new Dog4();
    }

    @Bean
    public Person4 person4() {
        return new Person4(dog4());
    }

    @Bean(name = "myPet4")
    public Pet4 myPet4() {
        Pet4 pet4;
        if (petName.equalsIgnoreCase("dog")) {
            pet4 = dog4();
        } else {
            throw new RuntimeException("Unknown pet: " + petName);
        }
        return pet4;
    }
}
