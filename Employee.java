package ru.sky.pro;

import java.util.Arrays;
import java.util.List;


public class Employee {
    private String fullName;
    private String department;
    private double salary;
    private int id;
    private static int count;

    public Employee(String fullName, String department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = ++count;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Employee{" + "fullName='" + fullName + '\'' + ", department='" + department + '\'' + ", salary=" + salary + ", id=" + id + '}';
    }


}
