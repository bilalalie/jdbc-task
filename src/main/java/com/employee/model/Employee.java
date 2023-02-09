package com.employee.model;

public class Employee {
    private int id;

    private String name;

    private String phoneNumber;

    private boolean male;

    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, String phoneNumber, boolean male, double salary) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.male = male;
        this.salary = salary;
    }

    public Employee(String name, String phoneNumber, boolean male, double salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.male = male;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", male=" + male +
                ", salary=" + salary +
                '}';
    }
}
