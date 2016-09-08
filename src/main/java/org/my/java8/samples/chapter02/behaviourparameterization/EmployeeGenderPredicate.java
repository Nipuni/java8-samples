package org.my.java8.samples.chapter02.behaviourparameterization;


/**
 * User: Nipuni Perera
 * This predicate class implement the behaviour to filter employees based on gender.
 */
public class EmployeeGenderPredicate implements EmployeePredicate {

    @Override
    public boolean test(Employee employee) {
        return employee.getGender().equals("Male");
    }
}
