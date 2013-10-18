package kr.ac.korea.mobide.hci.core;

import java.util.UUID;

public class IdGenerator {
    public static long id() {
        return UUID.randomUUID().getMostSignificantBits();
    }

    /**
     * 8자리 양의 정수로 만들기
     *
     * @return
     */
    public static long sId() {
        long result = Math.abs(UUID.randomUUID().getMostSignificantBits());
        while (result >= 100000000) result = result / 10;
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(IdGenerator.sId());
        }
    }
}
