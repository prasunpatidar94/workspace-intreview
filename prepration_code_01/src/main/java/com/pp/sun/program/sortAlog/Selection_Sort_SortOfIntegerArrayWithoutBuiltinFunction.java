package com.pp.sun.program.sortAlog;

public class Selection_Sort_SortOfIntegerArrayWithoutBuiltinFunction {




    //Time complexity = O(n^2)
    public static void main(String[] args) {
        int []in = {2000,2003,2004,2000,3000,5000};

        // Selection sort
        for (int i = 0; i < in.length-1; i++) {
            int getIndex = i;
            for (int j = i; j < in.length-1; j++) {
                if (in[j] > in[j + 1]) {
                    getIndex = j+1;
                    System.out.println(getIndex);
                }
            }//inner for end
            //swap
            int temp = in[i];
            in[i]= in[getIndex];
            in[getIndex]= temp;

        } //outer for end


        for (int i = 0; i < in.length ; i++) {
            System.out.println(in[i]);
        }

    }

}
