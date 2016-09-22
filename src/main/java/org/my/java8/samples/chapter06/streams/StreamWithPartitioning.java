package org.my.java8.samples.chapter06.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: Nipuni Perera
 * This class demonstrates the usage of partitionBy factory method.
 */
public class StreamWithPartitioning {

    public static void main(String []args) {
        List<Book> booksCatalogue = Arrays.asList(
                new Book("Jane Eyre", 1, Book.Type.NOVEL, false),
                new Book("Wuthering Heights", 1, Book.Type.NOVEL, false),
                new Book("Hitler's Last Days", 1, Book.Type.HISTORY, true),
                new Book("The Blind Owl", 1, Book.Type.NOVEL, false),
                new Book("Let It Snow", 3, Book.Type.NOVEL, false),
                new Book("Harry Potter and the Cursed Child", 4, Book.Type.NOVEL, true)
        );

        //this will partition the books in to 2 partiotions true/false
        Map<Boolean,List<Book>> booksByRecomendedForChildren = booksCatalogue.stream()
                .collect(Collectors.partitioningBy(Book::isRecommendedForChildren));

        List<Book> booksForChildren = booksByRecomendedForChildren.get(true);

        System.out.println(booksForChildren);
    }
}
