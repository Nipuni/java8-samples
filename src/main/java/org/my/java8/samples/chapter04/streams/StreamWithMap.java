package org.my.java8.samples.chapter04.streams;


import java.util.Arrays;
import java.util.List;

/**
 * User: Nipuni Perera
 * This example will demonstrates the usage of map() method in Streams API.
 */
public class StreamWithMap {
    public static void main(String args[]) {
        List<Book> booksCatalogue = Arrays.asList(
                new Book("Jane Eyre", 1, Book.Type.NOVEL, false),
                new Book("Wuthering Heights", 1, Book.Type.NOVEL, false),
                new Book("Hitler's Last Days", 1, Book.Type.HISTORY, true),
                new Book("The Blind Owl", 1, Book.Type.NOVEL, false),
                new Book("Let It Snow", 3, Book.Type.NOVEL, false),
                new Book("Harry Potter and the Cursed Child", 3, Book.Type.NOVEL, true)
        );
        booksCatalogue.stream()
                        .map(Book::getBookTitle)
                        .map(String::length)
                        .forEach(System.out::println);

    }
}
