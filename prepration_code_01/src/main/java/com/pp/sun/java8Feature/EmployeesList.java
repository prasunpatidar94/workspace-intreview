package com.pp.sun.java8Feature;



import java.util.*;


public class EmployeesList {


    public static List<EmployeeDetail> addEmployeesDetails(){
        List<EmployeeDetail> employees = new ArrayList<>();

        // Departments
        String[] departments = {"IT", "HR", "Finance", "Sales", "Marketing", "Admin", "Support"};

        // Indian Names (50 male + 50 female approx)
        String[] indianNames = {
                "Aarav", "Vivaan", "Aditya", "Vihaan", "Arjun", "Sai", "Reyansh", "Ayaan", "Krishna", "Ishaan",
                "Rohan", "Dhruv", "Kabir", "Karthik", "Atharv", "Shivansh", "Aniket", "Pranav", "Dev", "Harshit",
                "Anaya", "Diya", "Saanvi", "Aadhya", "Kiara", "Myra", "Ira", "Sara", "Meera", "Anika",
                "Navya", "Aarohi", "Pari", "Lavanya", "Trisha", "Riya", "Sneha", "Nisha", "Simran", "Kritika",
                "Manav", "Samar", "Ritesh", "Harsh", "Vikas", "Tanishq", "Abhay", "Raj", "Nakul", "Tejas",
                "Aditi", "Ishita", "Tanvi", "Muskan", "Pooja", "Kajal", "Bhavna", "Anjali", "Neha", "Priya",
                "Deepak", "Arnav", "Rachit", "Yash", "Akhil", "Siddharth", "Raghav", "Mohit", "Gaurav", "Manish",
                "Swati", "Divya", "Khushi", "Chaitali", "Tina", "Heena", "Payal", "Reshma", "Komal", "Sonam",
                "Varun", "Kunal", "Rahul", "Anand", "Ajay", "Nitin", "Vivek", "Chetan", "Alok", "Suresh",
                "Rekha", "Pallavi", "Smita", "Preeti", "Geeta", "Lata", "Rupa", "Seema", "Jyoti", "Neelam"
        };

        Random random = new Random();

        // Add 100 employees with Indian names and fixed IDs
        for (int i = 1; i <= 100; i++) {
            String name = indianNames[(i - 1) % indianNames.length]; // cycle through names
            String dept = departments[(i - 1) % departments.length]; // assign departments in round-robin
            double salary = 35000 + (i * 500) % 45000; // generate varied but non-random salary
            employees.add(new EmployeeDetail(i, name, dept, salary));
        }

        return employees;

    }

}
