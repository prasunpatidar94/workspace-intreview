package com.pp.sun.java8Feature;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters (optional)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    // toString() for easy printing
    @Override
    public String toString() {
        return "Employee { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                " }";
    }
}

public class StreamPocProgrammes {
    public static void main(String[] args) {
        // Create an ArrayList of Employee objects
        List<Employee> employees = new ArrayList<>();

        // Add Employee objects
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "Finance", 55000));
        employees.add(new Employee(103, "Charlie", "IT", 60000));
        employees.add(new Employee(105, "Kharlie", "IT", 60000));
        employees.add(new Employee(106, "Bharlie", "IT", 60000));
        employees.add(new Employee(107, "Charlie", "IT", 60000));
        employees.add(new Employee(109, "David", "Marketing", 52000));

        Map.Entry<Character , Long> outs=
                employees
                .stream()
                .collect(Collectors.groupingBy(
                employee -> employee.getName().toCharArray()[0]
        ,Collectors.counting()
        )).entrySet().stream().max(Map.Entry.comparingByValue()).get();



        System.out.println(outs);

        // Print all employees
        System.out.println("List of Employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
