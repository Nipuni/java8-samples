package org.my.java8.samples.chapter06.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: Nipuni Perera
 * This class demonstrates the different usages of collect method of Steams API
 */
public class StreamWithCollectDemo {

    public static void main(String []args) {
        List<Book> booksCatalogue = Arrays.asList(
                new Book("Jane Eyre", 1, Book.Type.NOVEL, false),
                new Book("Wuthering Heights", 1, Book.Type.NOVEL, false),
                new Book("Hitler's Last Days", 1, Book.Type.HISTORY, true),
                new Book("The Blind Owl", 1, Book.Type.NOVEL, false),
                new Book("Let It Snow", 3, Book.Type.NOVEL, false),
                new Book("Harry Potter and the Cursed Child", 4, Book.Type.NOVEL, true)
        );

        //group the books based on the book type
        Map<Book.Type, List<Book>> booksByType =
                booksCatalogue.stream().collect(Collectors.groupingBy(Book::getBookType));

        //count the elements of a stream
        long numberOfBooks = booksCatalogue
                .stream()
                .count();

        //filter a stream element based on a comparator
        Optional<Book> bookWithMaxAuthors = booksCatalogue
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Book::getNoOfAuthors)));
    }
}
