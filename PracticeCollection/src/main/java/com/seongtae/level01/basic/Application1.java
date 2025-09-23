package com.seongtae.level01.basic;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application1 {
//학생들의 점수를 입력받아 저장한 후,
// 평균 점수를 계산하여 출력하는 프로그램을 작성하세요.
//    학생 성적 : 100
//    추가 입력하려면 y : y
//    학생 성적 : 95
//    추가 입력하려면 y : Y
//    학생 성적 : 66
//    추가 입력하려면 y : y
//    학생 성적 : 79
//    추가 입력하려면 y : n
//    학생 인원 : 4
//    평균 점수 : 85.0

    public static void main(String[] args) {
        // 학생 점수 하나씩 저장할 곳
        List<Integer> scores = new ArrayList<>();


        try (Scanner scanner = new Scanner(System.in)) {
            // 무한 반복(While(true) 시작 -> 점수 계속 받을 수 있음
            while(true) {
                System.out.println("학생 성적");
                try {
                    int score = scanner.nextInt();
                    scores.add(score);
                } catch (InputMismatchException e) {
                    System.out.println("올바른 정수를 입력하세요");
                    scanner.next(); // 잘못된 입력 버리고 넘어감.
                    continue;       // 다시 반복문 처음으로 돌아감
                }
                System.out.print("추가 입력하려면 y : ");
                String choice = scanner.next();
                // equals 문자열을 대소문자까지 정확히 비교
                // 문자열을 대소문자 구분 없이 비교
                if (!choice.equalsIgnoreCase("y")) {
                    break;
                }
                if (scores.isEmpty()) {
                    System.out.println("입력된 학생 성적이 없습니다");
                    return;
                }
                // 점수 합계 구하기
                //Scores 안에 있는 점수를 하나씩 꺼내 total에 더함
                int total = 0;
                for (Integer score : scores) {
                    total += score;
                }
                double average = (double) total / scores.size();
                System.out.println("학생 인원 : " + scores.size());
                System.out.println("평균 점수" + average);

            }
        }
    }
}
