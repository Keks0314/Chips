package com;

import java.util.Arrays;

public  class Main {
    public static void main(String[] args) {
        char[] chips = ChipsChooser.chooseChips(8);
        System.out.println(Arrays.toString(chips));
    }

    private static boolean isEqualWords(String first, String second) {
        first = first.toUpperCase();
        second = second.toUpperCase();
        byte[] firstBytes = first.getBytes();
        Arrays.sort(firstBytes);
        byte[] secondBytes = second.getBytes();
        Arrays.sort(secondBytes);
        return Arrays.equals(firstBytes, secondBytes);
    }
}