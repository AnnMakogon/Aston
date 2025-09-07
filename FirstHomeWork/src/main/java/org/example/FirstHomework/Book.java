package org.example.FirstHomework;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;
}
