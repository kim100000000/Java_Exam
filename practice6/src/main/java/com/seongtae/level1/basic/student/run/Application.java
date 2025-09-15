package com.seongtae.level1.basic.student.run;

import com.seongtae.level1.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentDTO[] students = new StudentDTO[10];
        int count = 0;

        while (count < students.length) {
            System.out.print("학년: ");
            int grade = sc.nextInt();

            System.out.print("반: ");
            int classroom = sc.nextInt();
            sc.nextLine();

            System.out.print("이름: ");
            String name = sc.nextLine();

            System.out.print("국어 점수: ");
            int kor = sc.nextInt();

            System.out.print("영어 점수: ");
            int eng = sc.nextInt();

            System.out.print("수학 점수: ");
            int math = sc.nextInt();
            sc.nextLine();

            students[count++] = new StudentDTO(grade, classroom, name, kor, eng, math);

            System.out.print("계속 입력하시겠습니까? (y/n): ");
            String more = sc.nextLine();
            if (!more.equalsIgnoreCase("y")) break;
            System.out.println();
        }
       // System.out.println("c "+count);
        System.out.println("\n=== 입력된 학생 목록 ===");
        for (int i = 0; i < count; i++) {
            //System.out.println(students[i].getClasroom()+"  "+students[i].getClasroom());
            StudentDTO s = students[i];
            System.out.printf(
                    "%d) %d학년 %d반 %s - 국:%d, 영:%d, 수:%d, 평균: %.1f%n",
                    (i + 1),
                    s.getGrade(), s.getClasroom(), s.getName(),
                    s.getKor(), s.getEng(), s.getMath(),
                    s.average()
            );
        }
    }
}

