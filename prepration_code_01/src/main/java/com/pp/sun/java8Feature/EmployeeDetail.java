package com.pp.sun.java8Feature;

import lombok.Getter;

@Getter
 public class EmployeeDetail {
    // Getters
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public EmployeeDetail(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // toString() method for readable output
    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}