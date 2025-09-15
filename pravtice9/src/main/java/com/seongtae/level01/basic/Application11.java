package com.seongtae.level01.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Application11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("파일 이름을 입력하세요");
        String filename = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            System.out.println("파일 내용 출력");
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("해당 이름을 가진 파일이 없습니다");
        }
    }
}
