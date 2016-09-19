package org.my.java8.samples.chapter04.streams.excersises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * User: Nipuni Perera
 *
 */
public class TraderDemo {

    public static void main(String[]args) {
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

        //Find all transactions in the year 2011 and sort them by value (small to high).
        test1(transactions);

        //What are all the unique cities where the traders work?
        test2(transactions);

        //Find all traders from Cambridge and sort them by name.
        test3(transactions);

        //Return a string of all traders’ names sorted alphabetically.
        test4(transactions);

        //Are any traders based in Milan?
        test5(transactions);

        //Print all transactions’ values from the traders living in Cambridge.
        test6(transactions);

        //What’s the highest value of all the transactions?
        test7(transactions);

        //Find the transaction with the smallest value.
        test8(transactions);
    }

    private static void test1(List<Transaction> transactions ){
        List<Transaction> filteredTransactions = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    private static void test2(List<Transaction> transactions ){
        List<String> uniqueCities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

    private static void test3(List<Transaction> transactions ){
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    private static void test4(List<Transaction> transactions ){
        List<String> traders = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean test5(List<Transaction> transactions ){
        Optional<Trader> traderFromMilan = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .findAny();
        return traderFromMilan.isPresent();
    }

    private static void test6(List<Transaction> transactions ){
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    private static void test7(List<Transaction> transactions ){
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("Max is " + max.orElse(new Integer(0)));
    }

    private static void test8(List<Transaction> transactions ){
        Optional<Integer> min = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println("Max is " + min.orElse(new Integer(0)));
    }
}
