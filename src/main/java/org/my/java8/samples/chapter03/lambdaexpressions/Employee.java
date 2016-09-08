package org.my.java8.samples.chapter03.lambdaexpressions;

/**
 * User: Nipuni Perera
 * This class represents an Employee.
 */
public class Employee {

    private String ID;
    private int age;
    private String position;
    private String gender;

    public Employee(String ID, int age, String gender) {
        this.setID(ID);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
