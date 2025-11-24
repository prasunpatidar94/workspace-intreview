package com.pp.sun.poc;

import java.util.*;

public class RemoveDuplicateAndPrintElementInSorted {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 20, 10, 53, 8, 5, 489, 64, 84, 39, 64, 53, 8, 5, 489, 64, 84, 854);
        System.out.println(numbers);
        System.out.println("Approach # 1");
        System.out.println(
                numbers.stream().distinct().sorted(Integer::compareTo).toList()
        );

        System.out.println("Approach # 2");
        System.out.println(
                new ArrayList<>(new TreeSet<>(numbers))
        );

        System.out.println("Approach # 3");

        List<Integer> integerList = new ArrayList<>();
        numbers.forEach(e -> {
            if (!integerList.contains(e))
                integerList.add(e);
        });
        integerList.sort(Integer::compareTo);
        System.out.println(
                integerList
        );




    }


}
