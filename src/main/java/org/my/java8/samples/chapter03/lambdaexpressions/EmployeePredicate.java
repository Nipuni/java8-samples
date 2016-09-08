package org.my.java8.samples.chapter03.lambdaexpressions;


/**
 * User: Nipuni Perera
 * This is the predicate interface to filter Employees
 */
@FunctionalInterface
public interface EmployeePredicate {

    public boolean test(Employee employee); //note that each predicate returns a boolean
}
