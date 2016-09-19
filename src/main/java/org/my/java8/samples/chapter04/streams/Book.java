package org.my.java8.samples.chapter04.streams;

/**
 * User: Nipuni Perera
 * This is a model class for Book.
 */
public class Book {

    private String bookTitle;
    private int noOfAuthors;
    private Type bookType;
    private boolean isRecommendedForChildren;

    public Book(String title, int noOfAuthors, Type type, boolean isRecommendedForChildren) {
        this.bookTitle = title;
        this.noOfAuthors = noOfAuthors;
        this.bookType = type;
        this.isRecommendedForChildren = isRecommendedForChildren;
    }
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getNoOfAuthors() {
        return noOfAuthors;
    }

    public void setNoOfAuthors(int noOfAuthors) {
        this.noOfAuthors = noOfAuthors;
    }

    public Type getBookType() {
        return bookType;
    }

    public void setBookType(Type bookType) {
        this.bookType = bookType;
    }

    public boolean isRecommendedForChildren() {
        return isRecommendedForChildren;
    }

    public void setRecommendedForChildren(boolean isRecommendedForChildren) {
        this.isRecommendedForChildren = isRecommendedForChildren;
    }

    public static enum  Type {
         NOVEL, TRAVEL_GUIDE, MATH, HISTORY, DICTIONARY
    }
}
