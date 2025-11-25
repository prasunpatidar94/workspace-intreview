package com.pp.sun.poc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertTheListOfStringValuesIntoMapKeyIsStringValueAndLengthOfStringIsValue {
    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("I", "AM", "PRASUN", "PATIDAR");
        System.out.println(inputList);
        System.out.println("Approach # 1");
        System.out.println(
                inputList
                        .stream()
                        .collect(Collectors.toMap(e -> e, e -> e.length()))
        );

        System.out.println("Approach # 2");
        System.out.println(
                inputList
                        .stream()
                        .collect(Collectors.toMap(Function.identity(), String::length))
        );


        System.out.println("Approach # 3");
        Map<String, Integer> strIntMap = new HashMap<>();
        inputList.forEach(e -> strIntMap.putIfAbsent(e, e.length())
        );
        System.out.println(strIntMap);

        System.out.println("Approach # 4");
        Map<String, Integer> strIntMap1 = new HashMap<>();
        for (String e : inputList) {
            strIntMap1.computeIfAbsent(e, String::length);
        }
        System.out.println(strIntMap1);


    }

}
