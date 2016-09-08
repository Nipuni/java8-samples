package org.my.java8.samples.chapter03.lambdaexpressions;
/*
 * Copyright (c) 2016, Denis Weerasiri All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * User: NIpuni Perera
 * This class demonstrates the usage of lambda expressions with consumer as functional interfaces.
 */
public class ConsumerDemo {
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

        //We have used lambda expressions when passing consumer to filterEmployee() method.
        Consumer<Employee> testAgePredicate = (Employee employee) -> System.out.println(employee.getID());
        System.out.println("Printing employee IDs");
        filterEmployee(inventory, testAgePredicate);

    }

    //we have simplified the filter method to accept a predicate. So that we don't need multiple filter methods.
    //we can pass different implementations of EmployeePredicate interface to filter method below.
    //We can use lambdas in place where a functional interface is needed.
    public static void filterEmployee(List<Employee> employees, Consumer consumer) {
        for (Employee employee : employees) {
            consumer.accept(employee);
        }

    }
}
