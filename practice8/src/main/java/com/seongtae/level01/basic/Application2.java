package com.seongtae.level01.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.*;

public class Application2 {
    public static void main(String[] args) {

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            bw.write("분자 입력 : ");
            bw.flush(); // 출력 즉시 보여주기
            int numerator = Integer.parseInt(br.readLine()); // 문자열 → 정수

            bw.write("분모 입력 : ");
            bw.flush();
            int denominator = Integer.parseInt(br.readLine());

            int result = numerator / denominator;
            bw.write("결과 : " + result + "\n");

        } catch (NumberFormatException e) {
            // 정수가 아닌 값 입력 시
            System.out.println("오류 : 유효한 정수를 입력하세요.");
        } catch (ArithmeticException e) {
            // 0으로 나눌 때
            System.out.println("오류 : 0으로 나누는 것은 허용되지 않습니다.");
        } catch (
                IOException e) {
            // 입력/출력 오류
            System.out.println("오류 : 입출력 처리 중 문제가 발생했습니다.");
        } finally {
            System.out.println("실행이 완료되었습니다.");
        }
    }
}
