package com.seongtae.level01.basic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("분자 입력");
            int a = sc.nextInt();
            System.out.println("분모 입력");
            int b = sc.nextInt();

            int result = a / b;
            System.out.println(result);
        } catch (InputMismatchException e) {
            System.out.println("유효한 정수를 입력하세요");
    } catch (ArithmeticException e) {
            System.out.println("0으로 나누는 것은 허용되지 않습니다.");
        }finally{
            System.out.println("실행이 완료되었습니다");
        }
    }
}
