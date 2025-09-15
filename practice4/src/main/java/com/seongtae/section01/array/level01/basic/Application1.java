package com.seongtae.section01.array.level01.basic;
import java.util.Scanner;

/* 길이가 10인 정수형 배열을 선언 및 할당한 뒤
 * 각 인덱스에 차례대로 1부터 10까지 값을 넣고 출력하세요
 * */




public class Application1 {
    public static void main(String[] args) {

        int[] iarr = new int[10];


        for (int i = 0; i < iarr.length; i++) {
            iarr [i] = i + 1;
        }
        for (int i = 0; i < iarr.length; i++) {
            System.out.println("arr["+i+"] = "+iarr [i]);
        }
       int count=0;
        for (int i : iarr) {
            System.out.println("arr[" + count + "] = " + i);
            count++;
        }

        }
    }
