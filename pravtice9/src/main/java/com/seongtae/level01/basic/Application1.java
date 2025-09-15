package com.seongtae.level01.basic;

import java.io.*;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("파일 이름을 입력하세요 : ");
        String fileName = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            System.out.println("===== 파일 내용 출력 =====");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // 파일 내용을 한 줄씩 출력
            }

        } catch (FileNotFoundException e) {
            System.out.println("오류 : 해당 이름을 가진 파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("오류 : 파일을 읽는 도중 문제가 발생했습니다.");
        } finally {
            sc.close();
        }
    }
}