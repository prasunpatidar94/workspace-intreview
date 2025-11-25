package com.pp.sun.poc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicateIfDuplicateElementThenFalseElseTrue {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 39, 64, 53, 8, 5, 489, 64, 84, 854);

        System.out.println(numbers);
        System.out.println("Approach # 1");
        System.out.println(
                !numbers
                        .stream()
                        .collect(
                                Collectors
                                        .partitioningBy(
                                                e -> Collections
                                                        .frequency(numbers, e) > 1)).containsKey(Boolean.TRUE)
        );

        System.out.println("Approach # 1");
        System.out.println(
                numbers
                        .stream()
                        .collect(
                                Collectors
                                        .groupingBy(e->e,Collectors.counting())

                        ).values().stream().map(e-> (e > 1)?false:true)
        );

    }
}
