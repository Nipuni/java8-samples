package org.my.java8.samples.chapter04.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Nipuni Perera
 * This class will give a sample demonstration of filtering books in java 7 way.
 */
public class IterateBooksDemo {

    public static void main(String args[]) {
        List<Book> booksCatalogue = Arrays.asList(
                new Book("Jane Eyre",1, Book.Type.NOVEL, false),
                new Book("Wuthering Heights",1, Book.Type.NOVEL, false),
                new Book("Hitler's Last Days", 1, Book.Type.HISTORY, true),
                new Book("The Blind Owl", 1, Book.Type.NOVEL, false),
                new Book("Let It Snow", 3, Book.Type.NOVEL, false),
                new Book("Harry Potter and the Cursed Child", 3, Book.Type.NOVEL, true)
        );
        List<Book> multipleAuthorBooks = filterNoOfAuthors(booksCatalogue);
        System.out.println(multipleAuthorBooks.size());
    }

    public static List<Book> filterNoOfAuthors(List<Book> books) {
        List<Book> multipleAuthorBooks = new ArrayList<>();
        //till java 7 we used external iteration of elements.
        for(Book book: books) {
            if(book.getNoOfAuthors()>1){
                multipleAuthorBooks.add(book);
            }
        }
        return multipleAuthorBooks;
    }
}
