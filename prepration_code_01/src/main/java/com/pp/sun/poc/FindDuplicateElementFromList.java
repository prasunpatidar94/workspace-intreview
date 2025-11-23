package com.pp.sun.poc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElementFromList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 3, 2, 5, 4, 1, 3, 6, 7, 8, 9);
        Set<Integer> see = new HashSet<>();
        System.out.println("  Approch # 01 ");
        numbers.stream().filter(e -> !see.add(e))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("  Approch # 02 ");
        numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .forEach(e-> System.out.println(e.getKey()));


        System.out.println("  Approch # 03");
        numbers.stream().filter(e -> Collections.frequency(numbers, e) > 1)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("  Approch # 04");
        Map<Integer, Integer> mapsee = new HashMap<>();

        numbers.stream()
                .forEach(e -> mapsee.merge(e, 1, Integer::sum));
        mapsee.entrySet().stream().filter(e -> e.getValue() > 1)
                .forEach(e-> System.out.println(e.getKey()));

        System.out.println("  Approch # 05");

         numbers.stream()
                 .collect(Collectors.toMap(Function.identity(), e->1, Integer::sum))
                 .entrySet().stream().filter(e -> e.getValue() > 1)
                .forEach( e-> System.out.println(e.getKey()));

    }
}
