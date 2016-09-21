package org.my.java8.samples.chapter06.streams;


import java.util.*;
import java.util.stream.Collectors;

/**
 * User: Nipuni Perera
 * This class demonstrates the symmetrization functionalities available in the Streams API.
 */
public class StreamsWithSummarizationDemo {

    public static void main(String []args) {
        List<Book> booksCatalogue = Arrays.asList(
                new Book("Jane Eyre", 1, Book.Type.NOVEL, false),
                new Book("Wuthering Heights", 1, Book.Type.NOVEL, false),
                new Book("Hitler's Last Days", 1, Book.Type.HISTORY, true),
                new Book("The Blind Owl", 1, Book.Type.NOVEL, false),
                new Book("Let It Snow", 3, Book.Type.NOVEL, false),
                new Book("Harry Potter and the Cursed Child", 4, Book.Type.NOVEL, true)
        );

        //joining method will combine the result strings with the given delimiter
        System.out.println(booksCatalogue.stream()
                .map(Book::getBookTitle)
                .collect(Collectors.joining(",")));

        //This will sum up the number of authors in the catalogue and print the result.
        System.out.println("Number of authors involved in books: "+booksCatalogue.stream()
                .collect(Collectors.summingInt(Book::getNoOfAuthors)));
    }
}
