package com.pp.sun.program;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProgram {
    private static List<Integer> streamForDistinctSortedLimitSkip;

    public static void main(String[] args) {

        //ways to create Stream Object in java
        Stream<String> streamIn = Stream.of("Rahul","Prasun","Jyoti","Kisrthan","Vikash");
        Stream<String> streamEmpty = Stream.empty();
        String[] arr = {"x", "y", "z"};
        Stream<String> streamArray = Arrays.stream(arr);
        Stream<String> streamNullable = Stream.ofNullable(null);
        Stream<String> streamList = Arrays.asList("Prasun","Prasun").stream();
        Stream<Integer> streamLis = Stream.iterate(1,n -> n+1);

        //There are two method in Stream 1st Intermediate  and second terminal
        //Intermediate=->
//        | Operation                                      | Description                                     | Example                                    |
//| ---------------------------------------------- | ----------------------------------------------- | ------------------------------------------ |
//| `filter()`                                     | Filters elements based on a condition           | `stream.filter(e -> e > 5)`                |
//| `map()`                                        | Transforms each element                         | `stream.map(String::toUpperCase)`          |
//| `flatMap()`                                    | Flattens nested structures                      | `stream.flatMap(List::stream)`             |
//| `distinct()`                                   | Removes duplicates                              | `stream.distinct()`                        |
//| `sorted()`                                     | Sorts elements                                  | `stream.sorted()`                          |
//| `sorted(Comparator)`                           | Sorts using custom logic                        | `stream.sorted(Comparator.reverseOrder())` |
//| `peek()`                                       | Used for debugging (like `forEach`, but lazy)   | `stream.peek(System.out::println)`         |
//| `limit(n)`                                     | Truncates the stream to `n` elements            | `stream.limit(5)`                          |
//| `skip(n)`                                      | Skips the first `n` elements                    | `stream.skip(3)`                           |
//| `mapToInt()` / `mapToDouble()` / `mapToLong()` | Primitive specializations for performance       | `stream.mapToInt(String::length)`          |
//| `boxed()`                                      | Converts primitive stream back to object stream | `intStream.boxed()`                        |
//| `takeWhile()` (Java 9+)                        | Takes elements while a condition is true        | `stream.takeWhile(e -> e < 10)`            |
//| `dropWhile()` (Java 9+)                        | Skips elements while condition is true          | `stream.dropWhile(e -> e < 10)`            |
//| `parallel()`                                   | Converts sequential stream to parallel          | `stream.parallel()`                        |
//| `sequential()`                                 | Converts back to sequential                     | `stream.sequential()`                      |
//| `unordered()`                                  | Removes ordering constraint                     | `stream.unordered()`                       |

        Stream<String> streamForFilter = Stream.of("Rahul","Prasun","Jyoti","Kisrthan","Vikash");

        List<String> filterList = streamForFilter.filter(e->e.length()>5).toList();
        System.out.println(".filter() : "+filterList);

        Stream<String> streamForMap = Stream.of("Rahul","Prasun","Jyoti","Kisrthan","Vikash");
        System.out.println(".map() : "+streamForMap.map("Hello "::concat).toList());

        List<List<String>> streamForFlatMap = List.of(List.of("Prasun","Kamal"),List.of("Rina","Mahesh"));
        System.out.println(".flatMap() : "+streamForFlatMap.stream().flatMap(e->e.stream()).toList());

        List<List<String>> streamForFlatMap1 = List.of(List.of("Prasun","Kamal"),List.of("Rina","Mahesh"));
        List<List<String>> streamForFlatMap2 = List.of(List.of("Rahul","Vikash"),List.of("Rama","Chetan"));
        System.out.println(".flatMap() with 2 variable : "+Stream.of(streamForFlatMap1,streamForFlatMap1).flatMap(Collection::stream).toList());

        List<Integer> streamForDistinctSortedLimitSkip = List.of(1003,965,76,44,55,55,77,66,44,77,44,22,33,55,66);
        System.out.println(".distinct() ,.sorted() : "+streamForDistinctSortedLimitSkip.stream().distinct().sorted().toList());
        System.out.println(".distinct() ,.sorted(Comparator) : "+streamForDistinctSortedLimitSkip.stream().distinct().sorted((e1,e2)->e2-e1).toList());
        System.out.println(".distinct() ,.sorted(Comparator.reverseOrder()) : "+streamForDistinctSortedLimitSkip.stream().distinct().sorted((Comparator.reverseOrder())).toList());
        System.out.println(".distinct() ,.sorted(Comparator.reverseOrder()) : "+streamForDistinctSortedLimitSkip.stream().distinct().sorted((Comparator.reverseOrder())).toList());
        System.out.println(".distinct() ,.sorted(),.limit(5) : "+streamForDistinctSortedLimitSkip.stream().distinct().sorted().limit(5).toList());
        System.out.println(".distinct() ,.sorted(),.limit(5),.skip(3) : "+streamForDistinctSortedLimitSkip.stream().distinct().sorted().limit(5).skip(3).toList());

        List<Integer> streamForpPeek = List.of(1003,965,76,44,55,55,77,66,44,77,44,22,33,55,66);
        System.out.println(".peek() : "+streamForpPeek.stream().peek(System.out::print).map(e->e+1).collect(Collectors.toList()).add(1111));


        List<Integer> streamForFindFirstFindAny = List.of(1003,965,76,44,55,55,77,66,44,77,44,22,33,55,66);
        System.out.println(".FindAny() : "+streamForFindFirstFindAny.stream().findAny().orElseGet(()-> 0));
        System.out.println(".FindFirst() : "+streamForFindFirstFindAny.stream().findFirst().orElseGet(()-> 0));

    }

}
