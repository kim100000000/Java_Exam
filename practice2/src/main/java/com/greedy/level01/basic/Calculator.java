package com.greedy.level01.basic;

public class Calculator {

    public void checkMethod() {
        System.out.println("메소드 호출 확인");
    }

    public int sum1to10() {
        int sum = 0;
        for(int snum = 1; snum <= 10; snum++ )
            sum += snum;
        return sum;
    }

    public void checkMaxNumber(int a, int b) {
        if(a>=b) {
            System.out.println("두 수 중 큰 수는 20이다.");
        } else {
            System.out.println("두 수 중 큰 수는 20이다");
        }
    }

    public int sumTwomNumber(int a , int b) {
    return a+b;
    }

    public int minusTwoNumber(int a, int  b) {
        return a-b;
    }
}
