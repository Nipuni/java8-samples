package org.my.java8.samples.chapter04.streams;

import org.my.java8.samples.chapter04.streams.excersises.Trader;
import org.my.java8.samples.chapter04.streams.excersises.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * User: denis
 * This class demonstrates the use of IntStream to process primitive types efficiently.
 */
public class IntStreamDemo {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        findSum(transactions);
        findMax(transactions);

        long count = IntStream.rangeClosed(1,100)
                .filter(n->n%2==0)
                .count();

        System.out.println("Number of even numbers :" + count);
    }

    private static void findSum(List<Transaction> transactions){
        int sum = transactions.stream()
                .mapToInt(Transaction::getValue)
                .sum();

        System.out.println("Sum is " + sum);
    }

    private static void findMax(List<Transaction> transactions){
        OptionalInt sum = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();

        System.out.println("Max is " + sum.getAsInt());
    }
}
