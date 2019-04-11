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
            searchCoincidence(new char[] { 'В', 'О', 'С', 'П', 'Е', 'Т', 'Ь' }, reader, 7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchCoincidence(char[] selectedWord, BufferedReader reader, int countOfWords) throws IOException {
        for (int i = 1; i < countOfWords; ++i) {
            for (int j = 0; j < countOfWords - 1; j += i) {
                char[] currentSelectWord = (new String(Arrays.copyOfRange(selectedWord, j, j + i)) + selectedWord[countOfWords - 1]).toCharArray();
                String currentWord = null;
                while ((currentWord = reader.readLine()) != null) {
                    char[] charsCurrentWord = currentWord.toCharArray();
                    if (isEqualWords(currentSelectWord, charsCurrentWord)) {
                        System.out.println("Слово из словаря: " + currentWord);
                    }
                }
                reader = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), StandardCharsets.UTF_8));
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