package com.pp.sun.poc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class FindSecondLargestNumberFromListOfInteger {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 39, 64, 53, 8, 5, 489, 64, 84, 854);

        System.out.println(numbers);
        System.out.println("Approach # 1");
        System.out.println(
                numbers.stream()
                        .distinct()
                        .sorted((e1, e2) -> e2 - e1)
                        .skip(1).findFirst().get()
        );

        System.out.println("Approach # 2");
        TreeSet<Integer> treeSet = new TreeSet<>((e1, e2) -> e2 - e1);
        treeSet.addAll(numbers);
        System.out.println(treeSet.stream().skip(1).findFirst().get());


        System.out.println("Approach # 3");
        System.out.println(numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder()).skip(1)
                .findFirst()
                .get());

        System.out.println("Approach # 4");
        System.out.println(
                numbers.stream()
                        .filter(e -> e < (numbers.stream().distinct().max(Integer::compareTo).get()))
                        .max(Integer::compareTo)
                        .get()
        );
        System.out.println("Approach # 5");
        System.out.println(
                numbers.stream()
                        .filter(e -> e < (numbers.stream().distinct().max(Integer::compareTo).get()))
                        .max(Integer::compareTo)
                        .get()
        );

        System.out.println("Approach # 6");
        System.out.println(
                new TreeSet<>(numbers)
                        .lower(numbers.stream().max(Integer::compareTo).get())

        );


    }
}
