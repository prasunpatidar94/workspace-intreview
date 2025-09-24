package com.pp.sun.program.sortAlog;

public class Booble_Sort_SortOfIntegerArrayWithoutBuiltinFunction {



    //Time complexity = O(n^2)

    public static void main(String[] args) {
        int []in = {2000,2003,2004,2000,3000,5000};

        // Bubble Sort
        for (int i = 0; i < in.length-1; i++) {
            for (int j = 0; j < (in.length-i)-1; j++) {
                if (in[j] > in[j + 1]) {
                    //swap
                    int temp = in[j];
                    in[j] = in[j + 1];
                    in[j + 1] = temp;

//                    in[j]= (in[j]+in[j+1])-in[j];
//                    in[j+1]= (in[j]+in[j+1])-in[j+1];

                }
            }

        }


        for (int i = 0; i < in.length ; i++) {
            System.out.println(in[i]);
        }

    }

}
