package com.seongtae.level01.basic;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("생년월일 입력 (yyyy-MM-dd 양식으로 작성) : ");
            String input = sc.nextLine();

            // 날짜 형식 지정
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthDate = LocalDate.parse(input, formatter);

            // 오늘 날짜
            LocalDate today = LocalDate.now();

            // 만 나이 계산
            int age = Period.between(birthDate, today).getYears();

            if (age < 20) {
                System.out.println("만 20세 미만은 입장 불가입니다.");
            } else {
                System.out.println("입장하셔도 됩니다.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("날짜 양식을 잘못 입력하셨습니다.");

        } finally {
            sc.close();
        }
    }
}