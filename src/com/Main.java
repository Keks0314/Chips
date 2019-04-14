package com;

import java.util.*;

public  class Main {
    private static Map<Character, CostAndNumber> words = Words.map;

    public static void main(String[] args) {
        final int countOfWords = 8;
        char[] selectedWord = ChipsChooser.choose(countOfWords);
        System.out.print("Случайно выбранные буквы: ");
        for (int i = 0; i < countOfWords - 1; ++i) {
            System.out.print(selectedWord[i] + " ");
        }
        System.out.println("\nОтдельно выбранная буква: " + selectedWord[countOfWords - 1]);
        List<String> matchedWords = WordChecker.check(selectedWord);
        Collections.sort(matchedWords);
        printWords(matchedWords);
    }

    private static void printWords(List<String> matchedWords) {
        List<String> strings = new ArrayList<>();
        String maxWord = null;
        int count = 1;
        int maxValue = 0;
        for (String word : matchedWords) {
            char[] charWord = word.toCharArray();
            int value = 0;
            for (char c : charWord) {
                value += words.get(c).getCost();
            }
            if (value > maxValue) {
                strings.clear();
                maxValue = value;
                maxWord = word;
                strings.add(maxWord);
            } else if (value == maxValue) {
                strings.add(word);
            }
            System.out.println(count + ": " + word + " - " + value);
            ++count;
        }
        if (strings.size() == 1) {
            System.out.println("Слово " + strings.get(0) + " с максимальным значением " + maxValue);
        } else if (strings.size() > 1) {
            System.out.println("Слова " + strings + " с максимальным значением " + maxValue);
        } else {
            System.out.println("Невозможно составить слово из заданной последовательности");
        }
    }
}