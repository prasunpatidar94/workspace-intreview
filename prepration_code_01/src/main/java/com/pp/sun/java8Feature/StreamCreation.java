package com.pp.sun.java8Feature;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {

// A Stream is the sequence of data that support to enable the functional type of operation in java using  java Collection object.
//        - it is not going to change the data structure of the collection object.
// Ways to Create Streams in Java

//        Every Collection interface has a .stream() and .parallelStream() method.
//        Collection to Stream
        List<EmployeeDetail> listOfEmp= EmployeesList.addEmployeesDetails();
        Stream stream1= listOfEmp.stream(); //sequential
        Stream parallelStream2 = listOfEmp.parallelStream(); //parallel Stream

        stream1.forEach(System.out::println);
        parallelStream2.forEach(System.out::println);




//        Level 1 – Basic (Concept Building)
//
        System.out.println("Create a stream from a list of integers and print all elements ?");
        Stream input = Stream.of(100,657,7845,53,77,55,87);
        input.forEach(System.out::println);


//
        System.out.println("Given a list of strings, filter names starting with letter ‘A’.");
        List<String> inputList = Arrays.asList("RAMA","KAMAL","REKHA","SIVA","GURU","BALRAM","AKSHAY","AKASH", "AMIT");
       inputList.stream().filter(e-> e.startsWith("A")).toList().forEach(System.out::println);

        System.out.println("  Find the sum of all elements in a list using streams.");
//        Optional<Double> out =listOfEmp.stream().map(EmployeeDetail::getSalary).reduce(0.0 ,(a, b)->(a+b));
//        System.out.println(out.get());

//
//        Convert a list of strings to uppercase using map().
//
//       Count how many strings have length > 4.
//
//        Create a stream from an array and print elements in sorted order.
//
//        Find maximum and minimum number from a list.
//
//        Use forEach() to print all elements in reverse order.
//
//                Create a stream from Stream.of() and print its elements.
//
//        Create an empty stream using Stream.empty().


    }
}

