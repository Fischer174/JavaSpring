package com.example.Buns.Mod2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UniLibrary {

    @Autowired
    private ApplicationContext context;

    public void getBook(Book book){
        System.out.println("Берём книгу из UniLibrary: " + book.getName()
                + "Автор: " + book.getAuthor() + ", Год: - " + book.getYearOfPublication());
        System.out.println("-------------------------------");
    }

    public void addBook(String name, String author, int year){
        Book book = context.getBean(Book.class);
        book.setName(name);
        book.setAuthor(author);
        book.setYearOfPublication(year);

        System.out.println("Добавляем книгу в UniLibrary: " + book.getName()
                + " Автор: " + book.getAuthor() + ", Год: - " + book.getYearOfPublication());
        System.out.println("-------------------------------");
    }

    public void returnBook(Book book){
        System.out.println("Возвращяем книгу в UniLibrary: " + book.getName()
                + " Автор: " + book.getAuthor() + ", Год: - " + book.getYearOfPublication());
        System.out.println("-------------------------------");
    }

}
