package com.pp.sun.poc;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DuplicateNumbersFindFromArray {
    public static void main(String[] args) {
        int[] inArr = {100,100, 200,200,200, 300, 400, 300, 400, 800,100, 200, 300, };
//        HashSet<Integer> check = new HashSet<>();
//        Set<Integer> out1 = Arrays.asList(100, 200, 300, 400, 300, 400, 800).stream().filter(e -> !check.add(e)).collect(Collectors.toSet());
//        Arrays.stream(inArr).filter(e -> !check.add(e)).forEach(System.out::println);
//        List<Integer> out = IntStream.of(inArr).filter(e -> !check.add(e)).boxed().toList();
//        System.out.println(out1);


//        ----------------------

        int n = inArr.length;
        boolean isDup = false;
        for (int i = 0; i < n; i++){
            isDup = false;
            for (int j = i+1; j < n; j++) {
                if (inArr[i]==inArr[j]){
                    isDup = true;
                    break;
                }else {
                    isDup =false;
                    continue;
                }
            }
            if (!isDup){
                System.out.println(inArr[i]);
            }
        }

    }
}
