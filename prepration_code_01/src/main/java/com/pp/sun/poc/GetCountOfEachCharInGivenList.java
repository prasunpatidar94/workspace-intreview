package com.pp.sun.poc;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetCountOfEachCharInGivenList {

      static String  inputData = "I Am Prasun Patidar";

    public static void main(String[] args) {

 Arrays.stream(inputData.split(""))
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach(
                        (key,val)-> System.out.println(key +":" +val)
                );

        inputData
                .chars()
                .mapToObj(e->(char) e).collect(
                        Collectors
                        .groupingBy(a->a,Collectors.counting())
                )
                .forEach(
                (key,val)-> System.out.println(key +":" +val)
        );


    }

}
