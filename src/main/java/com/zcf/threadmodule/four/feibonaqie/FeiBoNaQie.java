package com.zcf.threadmodule.four.feibonaqie;

public class FeiBoNaQie {
    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        magicNum(128);
    }

    private static void magicNum(int num) {
        int hashCode = 0;
        for (int i = 0; i < num; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            System.out.print(hashCode & (num - 1));
            System.out.print(" ");
        }
        System.out.println("");
    }
}
