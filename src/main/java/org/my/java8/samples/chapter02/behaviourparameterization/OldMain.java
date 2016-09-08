package org.my.java8.samples.chapter02.behaviourparameterization;


import java.util.ArrayList;
import java.util.List;

/**
 * User: Nipuni Perera
 * This class gives an example of filtering a list in java 7 way
 */
public class OldMain {
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
          System.out.println("The number of employees with age less than 30 is : " + filterByAge(inventory).size());
          System.out.println("The number Male employees : " + filterByGender(inventory).size());
      }

    // Both filter method below filter the employee list. The method body differs only by one line of code which is
    // logic inside if statement.
    public static List<Employee> filterByAge( List<Employee> employees) {
        List<Employee> result = new ArrayList<Employee>();
        for( Employee employee : employees) {
            if(employee.getAge() < 30){
                result.add(employee);
            }
        }
        return result;
    }

    public static List<Employee> filterByGender( List<Employee> employees) {
        List<Employee> result = new ArrayList<Employee>();
        for( Employee employee : employees) {
            if(employee.getGender().equals("Male")) {
                result.add(employee);
            }
        }
        return result;
    }
}
