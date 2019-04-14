package com;

import java.util.*;

public  class Main {
    private static Map<Character, AmountAndCost> letters = Letters.container;

    public static void main(String[] args) {
        final int wordLength = 8;
        char[] choosedWords = ChipsChooser.choose(wordLength);
        System.out.print("Случайно выбранные буквы: ");
        for (int i = 0; i < wordLength - 1; ++i) {
            System.out.print(choosedWords[i] + " ");
        }
        System.out.println("\nОтдельно выбранная буква: " + choosedWords[wordLength - 1]);
        List<String> matchedWords = WordsChecker.check(choosedWords);
        Collections.sort(matchedWords);
        printWords(matchedWords);
    }

    private static void printWords(List<String> matchedWords) {
        List<String> words = new ArrayList<>();
        String maxWord = null;
        int maxValue = 0;
        int wordNumber = 1;
        for (String word : matchedWords) {
            char[] charWord = word.toCharArray();
            int value = 0;
            for (char c : charWord) {
                value += letters.get(c).getCost();
            }
            if (value > maxValue) {
                words.clear();
                maxValue = value;
                maxWord = word;
                words.add(maxWord);
            } else if (value == maxValue) {
                words.add(word);
            }
            System.out.println(wordNumber + ": " + word + " - " + value);
            ++wordNumber;
        }
        if (words.size() == 1) {
            System.out.println("Слово " + words.get(0) + " с максимальным значением " + maxValue);
        } else if (words.size() > 1) {
            System.out.println("Слова " + words + " с максимальным значением " + maxValue);
        } else {
            System.out.println("Невозможно составить слово из заданной последовательности");
        }
    }
}