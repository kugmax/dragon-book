package com.kugmax.learn.compiler.utils;

import java.util.Arrays;

public class TireUtils {

    public static int[] failFunction(String input) {
        input = " " + input;

        int t = 0;
        int[] result = new int[input.length()];

        for (int s = 1; s < input.length()-1 ; s++) {
            while (t > 0 && input.charAt(s + 1) != input.charAt(t + 1) ) {
                t = result[t];
            }

            if (input.charAt(s + 1) == input.charAt(t + 1)) {
                t++;
                result[s+ 1] = t;
            } else {
                result[s+ 1] = 0;
            }
        }

        return Arrays.copyOfRange(result, 1, input.length());
    }

    public static void main(String... args) {
        System.out.println("ababaa" + " " +  Arrays.toString(failFunction("ababaa")));
        System.out.println("abababaab" + " " +  Arrays.toString(failFunction("abababaab")));
    }
}
