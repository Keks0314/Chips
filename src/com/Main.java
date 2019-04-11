package com;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public  class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), StandardCharsets.UTF_8))) {
            char[] selectedWord = ChipsChooser.choose(8);
            for (char w : selectedWord) {
                System.out.print(w + "");
            }
            System.out.println();
            String currentWord = null;
            while ((currentWord = reader.readLine()) != null) {
                char[] charsCurrentWord = currentWord.toCharArray();
                if (isEqualWords(selectedWord, charsCurrentWord)) {
                    System.out.print("Слово из словаря: ");
                    for (char c : charsCurrentWord) {
                        System.out.print(c + "");
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isEqualWords(char[] first, char[] second) {
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }
}