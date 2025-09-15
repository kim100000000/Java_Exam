package com.seongtae.level01.basic;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("(yyyy-MM-dd 양식으로 작성 : ");
            String input = sc.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthDate = LocalDate.parse(input, formatter);

            LocalDate today = LocalDate.now();

            int age = Period.between(birthDate, today).getYears();


            if (age > 20) {
                System.out.println("입장하셔도 됩니다.");
            } else {
                System.out.println("20세 미만은 입장 불가입니다.");
            }
        } catch (Exception e) {
            System.out.println("날짜 양식을 잘못 입력하셨습니다.");
        }
    }
}
