package org.my.java8.samples.chapter02.behaviourparameterization;


/**
 * User: Nipuni Perera
 * This is the predicate interface to filter Employees
 */
public interface EmployeePredicate {

    public boolean test(Employee employee); //note that each predicate returns a boolean
}
