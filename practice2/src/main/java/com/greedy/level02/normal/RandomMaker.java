package com.greedy.level02.normal;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMaker {

    // 최소값부터 최대값까지 난수 반환
    public int randomNumber(int min, int max) {
        if (min > max) {
            int tmp = min; min = max; max = tmp; // 순서 바뀌면 교환
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    // 대문자 알파벳으로 된 문자열 반환
    public String randomUpperAlphabet(int length) {
        if (length <= 0) return "";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char ch = (char) ('A' + ThreadLocalRandom.current().nextInt(26));
            sb.append(ch);
        }
        return sb.toString();
    }

    // 가위/바위/보 중 하나 반환
    public String rockPaperScissors() {
        int n = ThreadLocalRandom.current().nextInt(3);
        return (n == 0) ? "가위" : (n == 1) ? "바위" : "보";
    }

    // 동전 앞/뒤 중 하나 반환
    public String tossCoin() {
        return ThreadLocalRandom.current().nextInt(2) == 0 ? "앞면" : "뒷면";
    }
}
