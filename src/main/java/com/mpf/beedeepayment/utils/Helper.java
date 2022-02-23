package com.mpf.beedeepayment.utils;

import java.util.Random;

public class Helper {
    public static String getToken(String prefix, int length) {
        final String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append(prefix);
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }

    public static String getToken(String prefix) {
        return getToken(prefix,6);
    }
    public static String getToken() {
        return getToken("");
    }
}
