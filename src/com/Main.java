package com;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public  class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), StandardCharsets.UTF_8))) {
            final int countOfWords = 8;
            char[] selectedWord = ChipsChooser.choose(countOfWords);
            System.out.println("Отдельно выбранная буква: " + selectedWord[countOfWords - 1]);
            for (char w : selectedWord) {
                System.out.print(w + "");
            }
            System.out.println();
            searchCoincidence(selectedWord, reader, countOfWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchCoincidence(char[] selectedWord, BufferedReader reader, int countOfWords) throws IOException {
        for (int i = 0; i < countOfWords - 1; ++i) {
            char[] currentSelectWord = (new String(Arrays.copyOfRange(selectedWord, 0, i + 1)) + selectedWord[countOfWords - 1]).toCharArray();
            String currentWord = null;
            while ((currentWord = reader.readLine()) != null) {
                char[] charsCurrentWord = currentWord.toCharArray();
                if (isEqualWords(currentSelectWord, charsCurrentWord)) {
                    System.out.print("Слово из словаря: ");
                    for (char c : charsCurrentWord) {
                        System.out.print(c + "");
                    }
                    System.out.println();
                }
            }
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), StandardCharsets.UTF_8));
        }
    }

    private static boolean isEqualWords(char[] first, char[] second) {
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }
}