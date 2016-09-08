package org.my.java8.samples.chapter03.lambdaexpressions.composinglambdaexpressions;


import org.my.java8.samples.chapter03.lambdaexpressions.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * User: NIpuni Perera
 * This class will demonstrate how to chain 2 or more functions to build another function object.
 */
public class ComposedFunctionDemo {
    public static void main (String [] args) {
        Employee john = new Employee("123", 34, "Male");
        Employee denis = new Employee("124", 29, "Male");
        Employee nipuni = new Employee("125", 27, "Female");
        Employee leon = new Employee("126", 23, "Female");
        Employee darak = new Employee("127", 45, "Male");

        List<Employee> inventory = new ArrayList<>();
        inventory.add(john);
        inventory.add(denis);
        inventory.add(nipuni);
        inventory.add(leon);
        inventory.add(darak);

        //We have used lambda expressions when passing function to filterEmployee() method.
        //We pass an employee object and get an integer in return.
        //Function interface has 2 default methods "andThen" and "compose" to use for combine functions.
        Function<Employee, Integer> getAge = Employee::getAge;
        Function<Integer, Boolean>  checkAgeLessThanThirty = (Integer age) -> age < 30 ;
        //getAge.andThen(checkAgeLessThanThirty) will return boolean value true if the age is less than 30 and false otherwise.
        System.out.println(filterEmployee(inventory, getAge.andThen(checkAgeLessThanThirty)));

    }

    //we have simplified the filter method to accept a predicate. So that we don't need multiple filter methods.
    //we can pass different implementations of EmployeePredicate interface to filter method below.
    //We can use lambdas in place where a functional interface is needed.
    public static <T,R> List<R> filterEmployee(List<T> employees, Function<T,R> function) {
        List<R> ageList = new ArrayList<>();
        for (T employee : employees) {
            ageList.add(function.apply(employee));
        }
        return ageList;
    }
}
