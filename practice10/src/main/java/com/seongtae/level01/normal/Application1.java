package com.seongtae.level01.normal;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("swap 전 : " + Arrays.toString(intArray));  // [1, 2, 3, 4, 5]
        swap(intArray, 1, 3);
        System.out.println("swap 후 : " + Arrays.toString(intArray));  // [1, 4, 3, 2, 5]

        String[] strArray = {"A", "B", "C", "D"};
        System.out.println("swap 전 : " + Arrays.toString(strArray));  // [A, B, C, D]
        swap(strArray, 0, 2);
        System.out.println("swap 후 : " + Arrays.toString(strArray));  // [C, B, A, D]
    }

    // 제네릭 메서드 swap
    public static <T> void swap(T[] array, int i, int j) {
        if (i < 0 || j < 0 || i >= array.length || j >= array.length) {
            throw new IndexOutOfBoundsException("인덱스 범위가 잘못되었습니다.");
        }

        T temp = array[i];  // i번째 값을 임시 저장
        array[i] = array[j]; // i 위치에 j 값을 넣음
        array[j] = temp;     // j 위치에 임시 값(temp) 넣음
    }
}
