package org.my.java8.samples.chapter04.streams;

import java.util.Arrays;
import java.util.List;

/**
 * User: Nipuni Perera
 * This example will demonstrates the usage of matching methods in Streams API.
 */
public class StreamWithMatchDemo {

    public static void main(String args[]) {
        List<Book> booksCatalogue = Arrays.asList(
                new Book("Jane Eyre", 1, Book.Type.NOVEL, false),
                new Book("Wuthering Heights", 1, Book.Type.NOVEL, false),
                new Book("Hitler's Last Days", 1, Book.Type.HISTORY, true),
                new Book("The Blind Owl", 1, Book.Type.NOVEL, false),
                new Book("Let It Snow", 3, Book.Type.NOVEL, false),
                new Book("Harry Potter and the Cursed Child", 3, Book.Type.NOVEL, true)
        );
        anyMatch(booksCatalogue);
        nonMatch(booksCatalogue);
    }

    public static void anyMatch( List<Book> booksCatalogue) {
        if(booksCatalogue.stream()
                .anyMatch(book -> book.getBookType()== Book.Type.HISTORY)) {
            System.out.println("The Catalogue has a history book");
        }
    }

    public static void nonMatch( List<Book> booksCatalogue) {
        if(booksCatalogue.stream()
                .noneMatch(book -> book.getBookType() == Book.Type.DICTIONARY)) {
            System.out.println("The Catalogue does not has any books with type Dictionary");
        }
    }
}
