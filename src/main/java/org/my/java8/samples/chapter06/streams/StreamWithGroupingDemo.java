package org.my.java8.samples.chapter06.streams;


import java.util.*;
import java.util.stream.Collectors;

/**
 * User: Nipuni Perera
 * This class demonstrates the usage of grouping factory method from Collectors.
 */
public class StreamWithGroupingDemo {

    public static void main(String []args) {
        List<Book> booksCatalogue = Arrays.asList(
                new Book("Jane Eyre", 1, Book.Type.NOVEL, false),
                new Book("Wuthering Heights", 1, Book.Type.NOVEL, false),
                new Book("Hitler's Last Days", 1, Book.Type.HISTORY, true),
                new Book("The Blind Owl", 1, Book.Type.NOVEL, false),
                new Book("Let It Snow", 3, Book.Type.NOVEL, false),
                new Book("Harry Potter and the Cursed Child", 4, Book.Type.NOVEL, true)
        );

        //Collectors.groupingBy will group the stream elements based on the given function.
        //We call this function a classification function.
        Map<Book.Type, List<Book>> booksByType = booksCatalogue.stream()
                .collect(Collectors.groupingBy(Book::getBookType));

        System.out.println(booksByType);

        //passing a lambda expression for groupBy function
        Map<String, List<Book>> booksByTypeAndAuthors = booksCatalogue.stream()
                .collect(Collectors.groupingBy(book -> { if(book.getNoOfAuthors() > 1) return "more authors";
                else if(book.getBookType()== Book.Type.NOVEL) return "novel";
                else return "default";}));

        System.out.println(booksByTypeAndAuthors);

        //multi level grouping.
        Map<Book.Type, Map<String, List<Book>>> multiLevelGroupedBooks = booksCatalogue.stream()
                .collect(Collectors.groupingBy(Book::getBookType, Collectors.groupingBy(
                        book -> {if(book.getNoOfAuthors() < 2) return "1";
                        else return "multiple";}
                )));

        System.out.println(multiLevelGroupedBooks);

        //counting elements per each group with multi level grouping
        Map<Book.Type, Long> countOfGroups = booksCatalogue.stream()
                .collect(Collectors.groupingBy(Book::getBookType, Collectors.counting()));

        System.out.println(countOfGroups);


        //collectingAndThen factory method will adapt the result of collector function of first argument
        //performing the second function
        Map<Book.Type, Book> booksByNoOfAuthors = booksCatalogue.stream()
                .collect(Collectors.groupingBy(Book::getBookType,
                        Collectors.collectingAndThen(Collectors.maxBy(
                                Comparator.comparingInt(Book::getNoOfAuthors)),
                                Optional::get)));

        System.out.println(booksByNoOfAuthors);
    }
}
