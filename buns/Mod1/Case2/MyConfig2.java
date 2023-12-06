package com.example.Buns.Mod1.Case2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.Buns.Case2")
public class MyConfig2 {
    @Bean
    public Pet2 dog2() {
        return new Dog2();
    }
}
