package com;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public  class Main {
    private static Map<Character, CostAndNumber> words = Words.map;

    public static void main(String[] args) {
//       todo нужно разобраться со *
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), StandardCharsets.UTF_8))) {
            final int countOfWords = 8;
            char[] selectedWord = ChipsChooser.choose(countOfWords);
            System.out.println("Отдельно выбранная буква: " + selectedWord[countOfWords - 1]);
            System.out.println(new String(selectedWord));
            List<String> matchedWords = searchCoincidence(new char[] { 'В', 'О', 'С', 'П', 'Е', 'Т', 'Ь' }, reader, 7);
            printMax(matchedWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> searchCoincidence(char[] selectedWord, BufferedReader reader, int countOfWords) throws IOException {
        List<String> allMatchedWords = new ArrayList<>();
        for (int i = 1; i < countOfWords; ++i) {
            for (int j = 0; j < countOfWords - 1; j += i) {
                char[] currentSelectWord = (new String(Arrays.copyOfRange(selectedWord, j, j + i)) + selectedWord[countOfWords - 1]).toCharArray();
                String currentWord = null;
                while ((currentWord = reader.readLine()) != null) {
                    char[] charsCurrentWord = currentWord.toCharArray();
                    if (isEqualWords(currentSelectWord, charsCurrentWord)) {
                        System.out.println("Слово из словаря: " + currentWord);
                        if (!allMatchedWords.contains(currentWord)) {
                            allMatchedWords.add(currentWord);
                        }
                    }
                }
                reader = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), StandardCharsets.UTF_8));
            }
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), StandardCharsets.UTF_8));
        }
        return allMatchedWords;
    }

    private static void printMax(List<String> matchedWords) {
        List<String> strings = new ArrayList<>();
        String maxWord = null;
        int maxValue = 0;
        for (String word : matchedWords) {
            char[] charWord = word.toCharArray();
            int value = 0;
            for (char c : charWord) {
                value += words.get(c).cost;
            }
            if (value > maxValue) {
                strings.clear();
                maxValue = value;
                maxWord = word;
                strings.add(maxWord);
            } else if (value == maxValue) {
                strings.add(word);
            }
        }
        if (strings.size() == 1) {
            System.out.println("Максимальная строка: " + strings.get(0));
        } else {
            System.out.print("Максимальные строки: " + strings);
        }
    }

    private static boolean isEqualWords(char[] first, char[] second) {
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }
}