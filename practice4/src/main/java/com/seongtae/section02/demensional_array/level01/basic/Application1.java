package com.seongtae.section02.demensional_array.level01.basic;

public class Application1 {
    public static void main(String[] args) {
        int[][] iarr = new int[3][4];
        int value = 1;
        for (int i = 0; i < iarr.length; i++) {
            for (int j = 0; j < iarr[i].length; j++) {
            iarr [i][j] = value++;
            }
        }
        for (int i = 0; i < iarr.length; i++) {
            for (int j = 0; j < iarr[i].length; j++) {
                System.out.print(iarr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
