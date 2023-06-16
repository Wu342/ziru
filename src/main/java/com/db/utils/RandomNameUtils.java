package com.db.utils;

import java.util.Random;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-31 17:33
 */
public class RandomNameUtils {
    public static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return "自如客" + sb.toString();
    }
}
