package org.my.java8.samples.chapter03.lambdaexpressions;


import java.util.function.Predicate;

/**
 * User: Nipuni Perera
 * This class demonstrate the usage of lambda expressions to define java 8 functional interface Predicate
 */
public class PredicateDemo {
    public static void main (String [] args) {
        Employee john = new Employee("123", 34, "Male");

        //We have used lambda expressions when passing predicates to filterEmployee() method.
        Predicate<Employee> testAgePredicate = (Employee employee) -> employee.getAge() > 30 ;
        System.out.println("Is employee is aged that 30 ? : " + filterEmployee(john, testAgePredicate));

    }

    //we have simplified the filter method to accept a predicate. So that we don't need multiple filter methods.
    //we can pass different implementations of EmployeePredicate interface to filter method below.
    //We can use lamdas in place where a functional interface is needed.
    public static boolean filterEmployee(Employee employee, Predicate predicate) {
        if(predicate.test(employee)) {
            return true;
        }
        return false;
    }
}
