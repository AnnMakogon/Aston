package org.example.FirstHomework;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private String name;
    private MyLinkedList<Book> books;

    public Student(String name) {
        this.name = name;
        this.books = new MyLinkedList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
