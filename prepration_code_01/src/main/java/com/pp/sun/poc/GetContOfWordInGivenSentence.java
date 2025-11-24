package com.pp.sun.poc;

import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetContOfWordInGivenSentence {
    public static void main(String[] args) {
        String input = "I am Prasun Patidar . I am software engineer in IBM";
        System.out.println(input);
        System.out.println("Approach # 1");
        Stream.of(input.split(" "))
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("Approach # 2");
        HashMap<String,Integer> mapOut = new HashMap<>();
        Stream.of(input.split(" "))
                .forEach(e->mapOut.merge(e,1 , (c1 ,c2)->c1+c2));
                mapOut.entrySet()
                .forEach(System.out::println);

 System.out.println("Approach # 3");
        Stream.of(input.split(" "))
                .collect(Collectors.toMap(Function.identity(),e->1,Integer::sum))
                .forEach((k,v)-> System.out.println(k +":" +v));

    }

}
