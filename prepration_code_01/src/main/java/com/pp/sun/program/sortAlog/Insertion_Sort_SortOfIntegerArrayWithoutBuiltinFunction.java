package com.pp.sun.program.sortAlog;

public class Insertion_Sort_SortOfIntegerArrayWithoutBuiltinFunction {



    //Time complexity = O(n^2)

    public static void main(String[] args) {
        int []in = {2000,2003,2004,2000,3000,5000};

        // Insertion Sort
        for (int i = 1; i < in.length; i++) {
            int current = in[i];

            int j= i-1;  //12

            while (j>=0 && in[j]>current){
                in[j+1] = in[j];
                j--;
            }
            in[j+1] = current;

        }


        for (int i = 0; i < in.length ; i++) {
            System.out.println(in[i]);
        }


    }

}
