package org.my.java8.samples.chapter04.streams;

import java.util.stream.Stream;

/**
 * User: Nipuni Perera
 * This class demonstrates the generation of streams from functions.
 */
public class InfiniteStreamsDemo {

    public static void main(String[] args) {
        Stream.iterate(0,n-> n+2)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0,1},t -> new int[]{t[1],t[1]+t[0]})
                .limit(20)
                .map(t->t[0])
                .forEach(System.out::println);
    }
}
