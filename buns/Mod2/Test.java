package com.example.Buns.Mod2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);

        uniLibrary.addBook("Бегущий по Лезвию 2147 ", "Рожков С.В", 2023);
        uniLibrary.returnBook(book);
        uniLibrary.getBook(book);

        context.close();
    }
}
