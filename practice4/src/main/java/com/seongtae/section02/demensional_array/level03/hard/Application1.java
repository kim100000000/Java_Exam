package com.seongtae.section02.demensional_array.level03.hard;

import java.util.Random;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row,column;

        while(true) {
            System.out.println("가로 행의 수를 입력하세요");
             row = sc.nextInt();
            System.out.println("세로 행의 수를 입력하세요");
             column = sc.nextInt();
             if(row<= 10 && row >=1 && column <= 10 && column >=1){
                 break;
             }
             System.out.println("다시 입력 하세요");
        }



        char[][] index = new char[row][column];

        for (int i = 0; i< index.length; i++) {

            for (int j = 0; j < index[i].length; j++) {
                index[i][j] = (char)((int)(Math.random()*26)+65);
                System.out.print(index[i][j]+ " ");
            }
            System.out.println();
        }

    }
}