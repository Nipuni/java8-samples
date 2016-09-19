package org.my.java8.samples.chapter04.streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Nipuni Perera
 * This example demonstrates the usage of distinct() operation in Streams API.
 */
public class StreamWithDistinct {
    public static void main(String args[]) {
        List<String> names = new ArrayList<>();
        names.add("Adrian");
        names.add("Lizy");
        names.add("Darek");
        names.add("Adrian");
        names.add("Nipuni");
        names.add("Shasi");
        names.add("Boni");
        names.add("Nipuni");
        names.add("Victoria");


        //This will print all distinct values from the names list.
        names.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
