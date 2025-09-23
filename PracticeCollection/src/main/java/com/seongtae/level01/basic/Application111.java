package com.seongtae.level01.basic;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class Application111 {

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

        List<Integer> scores = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("학생 성적 :");
                try {
                    int score = scanner.nextInt();
                    scores.add(score);
                } catch (InputMismatchException e) {
                    System.out.println("올바른 정수를 입력 하시오");
                    scanner.next();
                    continue;
                }
                System.out.println("추가 입력하려면 y : ");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }
        if (scores.isEmpty()) {
            System.out.println("입력된 학생 성적이 없습니다.");
            return;
        }
        int total = 0;
        for (Integer score : scores) {
            total += score;
        }
        double average = (double) total / scores.size();
        System.out.println("학생 인원 : " + scores.size());
        System.out.println("평균 점수 : " + average);

    }
}
