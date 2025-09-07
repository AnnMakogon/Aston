package org.example.FirstHomework;

import lombok.extern.slf4j.Slf4j;
import org.example.Executor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service("firstExecutorService")
public class ExecutorService implements Executor {

    public static void processStudents(Collection<Student> students) {
        students.stream()
                .peek(System.out::println)
                .flatMap(student ->
                        Stream.iterate(0, i -> i < student.getBooks().size(), i -> i + 1)
                                .map(i -> student.getBooks().get(i))
                )
                .distinct()
                .sorted(Comparator.comparingInt(Book::getPages))
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Year of publication of the book found: " + year),
                        () -> System.out.println("There is no such book")
                );
    }

    @Override
    public void execution() {
        Book book1 = new Book("Java Programming", "James Gosling", 2015, 450);
        Book book2 = new Book("Effective Java", "Joshua Bloch", 2018, 412);
        Book book3 = new Book("Clean Code", "Robert Martin", 2008, 320);
        Book book4 = new Book("Design Patterns", "Erich Gamma", 1999, 395);
        Book book5 = new Book("Head First Java", "Kathy Sierra", 2003, 688);
        Book book6 = new Book("Java Concurrency", "Brian Goetz", 2006, 352);
        Book book7 = new Book("Spring in Action", "Craig Walls", 2020, 560);
        Book book8 = new Book("Test Driven Development", "Kent Beck", 2002, 240);
        Book book9 = new Book("Refactoring", "Martin Fowler", 2018, 455);
        Book book10 = new Book("Algorithms", "Robert Sedgewick", 2011, 976);

        Student student1 = new Student("Ivan Ivanov");
        student1.addBook(book1);
        student1.addBook(book2);
        student1.addBook(book3);
        student1.addBook(book4);
        student1.addBook(book5);

        Student student2 = new Student("Petr Petrov");
        student2.addBook(book2);
        student2.addBook(book6);
        student2.addBook(book7);
        student2.addBook(book8);
        student2.addBook(book9);

        Student student3 = new Student("Maria Sidorova");
        student3.addBook(book1);
        student3.addBook(book3);
        student3.addBook(book5);
        student3.addBook(book7);
        student3.addBook(book10);

        Student student4 = new Student("Anna Smirnova");
        student4.addBook(book4);
        student4.addBook(book6);
        student4.addBook(book8);
        student4.addBook(book9);
        student4.addBook(book10);

        Student student5 = new Student("Sergey Kuznetsov");
        student5.addBook(book1);
        student5.addBook(book2);
        student5.addBook(book7);
        student5.addBook(book9);
        student5.addBook(book10);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);

        log.info("=== Processing students with stream ===");
        processStudents(students);

        log.info("=== Testing MyHashSet ===");
        MyHashSet<String> set = new MyHashSet<>();
        log.info("Add 'hello': {}", set.insert("hello"));
        log.info("Add 'world': {}", set.insert("world"));
        log.info("Add 'hello' (duplicate): {}", set.insert("hello"));
        log.info("Size: {}", set.size());
        log.info("Contains 'world': {}", set.contains("world"));
        log.info("Removal 'hello': {}", set.remove("hello"));
        log.info("Size after removal: {}", set.size());

        log.info("=== Testing MyLinkedList ===");
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        log.info("Element by index 1: {}", list.get(1));
        log.info("Delete item 20: {}", list.remove(Integer.valueOf(20)));
        log.info("Size after removal: {}", list.size());

        List<Integer> numbers = Arrays.asList(40, 50, 60);
        list.addAll(numbers);
        log.info("Size after addAll: {}", list.size());
    }
}
