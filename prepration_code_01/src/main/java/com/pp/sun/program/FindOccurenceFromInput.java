package com.pp.sun.program;

import org.springframework.expression.spel.ast.Identifier;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOccurenceFromInput {


     private static List<String> empNames = Arrays.asList("Prasun","Prasun","Kamal","Rama","Rahul","Viky","Kamal","Kamal","Kamal");
     private static List<Double> empsSalary = Arrays.asList(1055.456,1095.4506,1095.456,1905.4596,105.496,185.456,1095.4596,1095.456,123.567,1095.456,1095.456,1095.456,123.567,123.567);

    public static void main(String[] args) {
        Map<String,Long> out = empNames.stream().collect(Collectors.groupingBy(Function.identity() ,Collectors.counting() ));

        Optional<Map.Entry<String, Long>> outdata = out.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).skip(1).findFirst();

        System.out.println(outdata);
        System.out.println(out);

        Optional<Map.Entry<Double, Long>> sal=empsSalary.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).skip(1).findFirst();
        System.out.println(sal.get());

//        Set<Double> = new HashSet<>(empsSalary.;

    }

}
