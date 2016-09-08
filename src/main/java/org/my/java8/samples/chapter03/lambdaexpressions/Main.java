package org.my.java8.samples.chapter03.lambdaexpressions;


import java.util.ArrayList;
import java.util.List;

/**
 * User: Nipuni Perera
 * This class shows how we can pass predicates as lambda expressions.
 */
public class Main {
    public static void main (String [] args) {
        Employee john = new Employee("123", 34, "Male");
        Employee denis = new Employee("124", 29, "Male");
        Employee nipuni = new Employee("125", 27, "Female");
        Employee leon = new Employee("126", 23, "Female");
        Employee darak = new Employee("127", 45, "Male");

        List<Employee> inventory = new ArrayList<Employee>();
        inventory.add(john);
        inventory.add(denis);
        inventory.add(nipuni);
        inventory.add(leon);
        inventory.add(darak);

        //We have used lambda expressions when passing predicates to filterEmployee() method.
        System.out.println("The number of employees with age less than 30 is : " + filterEmployee(inventory,
                (Employee e) -> e.getAge() > 30).size());
        System.out.println("The number Male employees : " + filterEmployee(inventory,
                (Employee e) -> e.getGender().equals("Male")).size());

    }

    //we have simplified the filter method to accept a predicate. So that we don't need multiple filter methods.
    //we can pass different implementations of EmployeePredicate interface to filter method below.
    //We can use lamdas in place where a functional interface is needed.
    //Even in this approach we have to define our own functional interfaces to insert the function. eg: EmployeePredicate.
    //But java 8 has new java functional interfaces (eg: Predicate, Consumer) introduced.
    public static List<Employee> filterEmployee( List<Employee> employees, EmployeePredicate predicate) {
        List<Employee> result = new ArrayList<>();
        for( Employee employee : employees) {
            if(predicate.test(employee)){
                result.add(employee);
            }
        }
        return result;
    }

}
