package com.example.Buns.Mod1.Case3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.Buns.Case3")
public class MyConfig3 {
    @Bean
    public Pet3 dog3() {
        return new Dog3();
    }
}