package org.my.java8.samples.chapter02.behaviourparameterization;


import java.util.ArrayList;
import java.util.List;

/**
 * User: Nipuni Perera
 * This class shows how we can pass predicates to methods and parametrize method behaviours.
 */
public class NewMain {
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
        System.out.println("The number of employees with age less than 30 is : " + filterEmployee(inventory,
                new EmployeeAgePredicate()).size());
        System.out.println("The number Male employees : " + filterEmployee(inventory,
                new EmployeeGenderPredicate()).size());
    }

    //we have simplified the filter method to accept a predicate. So that we don't need multiple filter methods.
    //we can pass different implementations of EmployeePredicate interface to filter method below.
    //Anyway we still have to wrap the behaviour inside a predicate object. This can be avoided using lambda expressions.
    public static List<Employee> filterEmployee( List<Employee> employees, EmployeePredicate predicate) {
        List<Employee> result = new ArrayList<Employee>();
        for( Employee employee : employees) {
            if(predicate.test(employee)){
                result.add(employee);
            }
        }
        return result;
    }
}
