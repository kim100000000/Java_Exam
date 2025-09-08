package com.seongtae.section01.conditional.level03.hard;

import java.util.Scanner;

/* 두 개의 정수를 입력 받아 변수에 저장하고,
 * 연산기호(+, -, *, /, %)를 입력 받아 해당 연산의 수행 결과를 출력하세요.
 * 단, 준비된 연산기호 외의 문자를 입력하는 경우 "입력하신 연산은 없습니다. 프로그램을 종료합니다." 출력 후 프로그램 종료
 *
 * -- 입력 예시 --
 * 첫 번째 정수 : 4
 * 두 번째 정수 : 3
 * 연산 기호를 입력하세요 : +
 *
 * -- 출력 예시 --
 * 4 + 3 = 7
 */

public class Application1 {
    public void save() {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 정수 : ");
        int first = sc.nextInt();

        System.out.println("두 번째 정수 : ");
        int second = sc.nextInt();

        System.out.println("연산 기호를 입력하세요 : ");
        char ch = sc.next().charAt(0);

        int sum = 0;

        switch(ch) {
            case '+':
                sum = first + second;
                break;

            case '-':
                sum = first - second;
                break;

            case '*':
                sum = first * second;
                break;

            case '/':
                sum = first / second;
                break;

            case '%' :
                sum = first % second;
                break;
        }
        System.out.println(first + " " + ch + " " + second + " = " + sum);
    }
}
