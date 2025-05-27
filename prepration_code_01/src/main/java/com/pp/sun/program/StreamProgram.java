package com.pp.sun.program;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProgram {
    public static void main(String[] args) {

        //ways to create Stream Object in java
        Stream<String> streamIn = Stream.of("Rahul","Prasun","Jyoti","Kisrthan","Vikash");
        Stream<String> streamEmpty = Stream.empty();
        String[] arr = {"x", "y", "z"};
        Stream<String> streamArray = Arrays.stream(arr);
        Stream<String> streamNullable = Stream.ofNullable(null);
        Stream<String> streamList = Arrays.asList("Prasun","Prasun").stream();
        Stream<Integer> streamLis = Stream.iterate(1,n -> n+1);

        //There are two method in Stream 1st Intermediate  and second terminal
        //Intermediate=->
        List<String> filterList = streamIn.filter(e->e.length()>5).collect(Collectors.toList());
        System.out.println(".filter() : "+filterList);

        List<String> mapList = streamIn.map(e->"Hello".concat(e)).toList();
        System.out.println(".map() : "+mapList);

//        System.out.println(".map() : "+streamIn.map(e->"Hello".concat(e)).toList());



    }

}
