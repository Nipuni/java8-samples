package org.my.java8.samples.chapter02.behaviourparameterization;


/**
 * User: Nipuni
 * This a one implementation of the predicate EmployeePredicate that filter the employee by age
 */
public class EmployeeAgePredicate implements EmployeePredicate {

    @Override
    public boolean test(Employee employee) {
       return employee.getAge() < 30;
    }
}
