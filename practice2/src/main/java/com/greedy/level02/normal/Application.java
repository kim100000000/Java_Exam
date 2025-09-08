package com.greedy.level02.normal;

public class Application {
    public static void main(String[] args) {
        RandomMaker rm = new RandomMaker();

        // 1) 난수 출력
        System.out.println(rm.randomNumber(-50, 50));

        // 2) 대문자 알파벳 문자열 출력
        System.out.println(rm.randomUpperAlphabet(10));

        // 3) 가위/바위/보 출력
        System.out.println(rm.rockPaperScissors());

        // 4) 동전 앞/뒤 출력
        System.out.println(rm.tossCoin());
    }
}
