package com.seongtae.level01.basic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("분자 입력 : ");
            int numerator = sc.nextInt();   // 분자 입력

            System.out.print("분모 입력 : ");
            int denominator = sc.nextInt(); // 분모 입력

            int result = numerator / denominator; // 나눗셈 연산
            System.out.println("결과 : " + result);

        } catch (InputMismatchException e) {
            // 숫자가 아닌 값 입력 시
            System.out.println("오류 : 유효한 정수를 입력하세요.");
        } catch (ArithmeticException e) {
            // 분모가 0일 때
            System.out.println("오류 : 0으로 나누는 것은 허용되지 않습니다.");
        } finally {
            // 무조건 실행됨
            System.out.println("실행이 완료되었습니다.");
        }
    }
}


