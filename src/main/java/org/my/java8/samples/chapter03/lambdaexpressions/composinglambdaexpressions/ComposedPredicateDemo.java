package org.my.java8.samples.chapter03.lambdaexpressions.composinglambdaexpressions;


import org.my.java8.samples.chapter03.lambdaexpressions.Employee;

import java.util.function.Predicate;

/**
 * User: Nipuni Perera
 * This class will demonstrate how to chain 2 or more predicates to build another predicate object.
 */
public class ComposedPredicateDemo {
    public static void main (String [] args) {
        Employee john = new Employee("123", 34, "Male");

        //We have used lambda expressions when passing predicates to filterEmployee() method.
        Predicate<Employee> testAgePredicate = (Employee employee) -> employee.getAge() > 30 ;
        //Predicate functional interface support few default methods that can be used to get predicates as below.
        //testAgePredicate.negate() will give the inverse result of the predicate testAgePredicate
        //similarly there are many other methods such as and, or etc.
        System.out.println("Is employee is not aged greater than 30 ? : " + filterEmployee(john, testAgePredicate.negate()));
        System.out.println("Is employee is Male AND aged greater than 30? : " + filterEmployee(john,
                testAgePredicate.and((Employee employee) -> employee.getGender().equals("Male"))));

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
