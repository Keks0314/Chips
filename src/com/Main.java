package com;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public  class Main {
    private static Map<Character, CostAndNumber> words = Words.map;
    private static HashSet<String> dict = new HashSet<>();

    public static void main(String[] args) {
        final int countOfWords = 8;
        char[] selectedWord = ChipsChooser.choose(countOfWords);
        System.out.print("Случайно выбранные буквы: ");
        for (int i = 0; i < countOfWords - 1; ++i) {
            System.out.print(selectedWord[i] + " ");
        }
        System.out.println();
        System.out.println("Отдельно выбранная буква: " + selectedWord[countOfWords - 1]);
        initializeDict();
        Set<String> wordsSet = CombinationGenerator.generate(selectedWord);
        List<String> matchedWords = searchCoincidence(wordsSet);
        printWords(matchedWords);
    }

    private static void initializeDict() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), StandardCharsets.UTF_8))) {
            String word = null;
            while ((word = reader.readLine()) != null) {
                dict.add(word);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> searchCoincidence(Set<String> wordsSet) {
        List<String> allMatchedWords = new ArrayList<>();
        for (var word : wordsSet) {
            if (word.contains("*")) {
                List<String> wordsWithoutStar = replaceStar(word);
                for (var newWord : wordsWithoutStar) {
                    if (dict.contains(newWord) && !allMatchedWords.contains(newWord)) {
                        allMatchedWords.add(newWord);
                    }
                }
            } else if (dict.contains(word) && !allMatchedWords.contains(word)) {
                allMatchedWords.add(word);
            }
        }
        return allMatchedWords;
    }

    private static List<String> replaceStar(String word) {
        List<String> listWithReplacedStar = new ArrayList<>();
        String alphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        for (int i = 0; i < alphabet.length(); ++i) {
            int starIndex = word.indexOf("*");
            StringBuilder newWord = new StringBuilder();
            newWord.append(word, 0, starIndex)
                    .append(alphabet.charAt(i))
                    .append(word, starIndex + 1, word.length());
            listWithReplacedStar.add(newWord.toString());
        }
        return listWithReplacedStar;
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