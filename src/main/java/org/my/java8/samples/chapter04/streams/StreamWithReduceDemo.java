package org.my.java8.samples.chapter04.streams;


import java.util.ArrayList;
import java.util.List;

/**
 * User: Nipuni Perera
 * This example will demonstrates the usage of reduce() method in Streams API.
 */
public class StreamWithReduceDemo {

    public static void main(String args[]) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(5);
        numbers.add(8);

        //reduce a list of numbers to an int
        int multiplication = numbers.stream()
                .reduce(1,(a,b) -> a*b);

        System.out.println(multiplication);
    }
}
