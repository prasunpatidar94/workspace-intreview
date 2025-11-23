package com.pp.sun.poc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindNonRepeatingCharInString {
    public static void main(String[] args) {
        String input = "swiss";
        List<String> characters = Arrays.asList(input.split(""));

        System.out.println("Approach # 01");
        System.out.println("Output : -> " + characters.stream()
                .filter(e -> Collections.frequency(characters, e) == 1).findFirst().orElse("Invalid Inputs"));

        System.out.println("Approach # 02");
        System.out.println("Output : -> " + characters.stream()
                .collect(
                        Collectors
                                .groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .findFirst()
                .get()
                .getKey());

        System.out.println("Approach # 03");
        System.out.println("Output : -> " + characters.stream()
                .collect(Collectors.toMap(Function.identity(), e -> 1, Integer::sum))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .get()
                .getKey()
        );

        System.out.println("Approach # 04");
        Map<String, Integer> integerMap = new HashMap<>();
        characters.forEach(e -> integerMap.merge(e, 1, Integer::sum));
        System.out.println("Output : -> " + integerMap.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey());


    }
}
