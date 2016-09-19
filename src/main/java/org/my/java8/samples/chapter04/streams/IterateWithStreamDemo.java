package org.my.java8.samples.chapter04.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Nipuni Perera
 * This class demonstrate the use of java 8 Streams API.
 */
public class IterateWithStreamDemo {

    public static void main(String args[]) {
        List<Book> booksCatalogue = Arrays.asList(
                new Book("Jane Eyre", 1, Book.Type.NOVEL, false),
                new Book("Wuthering Heights", 1, Book.Type.NOVEL, false),
                new Book("Hitler's Last Days", 1, Book.Type.HISTORY, true),
                new Book("The Blind Owl", 1, Book.Type.NOVEL, false),
                new Book("Let It Snow", 3, Book.Type.NOVEL, false),
                new Book("Harry Potter and the Cursed Child", 3, Book.Type.NOVEL, true)
        );

        //with java 8 we use internal iteration
        List<Book> multipleAuthorBooks = booksCatalogue.stream()
                .filter(book -> book.getNoOfAuthors()>1)
                .collect(Collectors.toList());
        System.out.println(multipleAuthorBooks.size());
    }
}
