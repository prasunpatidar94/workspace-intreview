package com.pp.sun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8StreamMethods {
    public static void main(String[] args) {
        //filter
        List<Integer> out = Arrays.asList(100, 200, 300, 500, 400, 1000, 3999).stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(out);
        List<Integer> out1 = Arrays.asList(100, 200, 300, 500, 400, 1000, 3999).stream()
                .filter(e -> e % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(out1);

        Map<Integer ,Long> out3 = Arrays.asList(100,100,500,1000,300, 200, 300, 500, 400, 1000, 3999)
                .stream()
                .collect(
                        Collectors
                                .groupingBy(
                                        Function.identity(),Collectors.counting()
                                )
                );
        System.out.println(out3);
    }
}
