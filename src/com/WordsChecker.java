package com;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordsChecker {
    private static Set<String> dictionary = new HashSet<>(297510);

    public static List<String> check(char[] word) {
        initializeDictionary();
        Set<String> wordsSet = CombinationsGenerator.generate(word);
        return searchCoincidence(wordsSet);
    }

    private static void initializeDictionary() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), StandardCharsets.UTF_8))) {
            String word = null;
            while ((word = reader.readLine()) != null) {
                dictionary.add(word);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> searchCoincidence(Set<String> wordsSet) {
        List<String> allMatchedWords = new ArrayList<>();
        for (var word : wordsSet) {
            if (word.contains("*")) {
                List<String> wordsWithoutStars = getWordWithoutStars(word);
                for (var newWord : wordsWithoutStars) {
                    if (dictionary.contains(newWord) && !allMatchedWords.contains(newWord)) {
                        allMatchedWords.add(newWord);
                    }
                }
            } else if (dictionary.contains(word) && !allMatchedWords.contains(word)) {
                allMatchedWords.add(word);
            }
        }
        return allMatchedWords;
    }

    private static List<String> getWordWithoutStars(String word) {
        List<String> wordsWithoutStar = new ArrayList<>();
        List<String> wordsWithoutOneStar = replaceStar(word);
        List<String> wordsWithoutTwoStar = null;
        List<String> wordsWithoutThreeStar = null;
        int countOfStars = (int) word.chars().mapToObj(x -> (char) x).filter(x -> x == '*').count();
        if (countOfStars > 1) {
            wordsWithoutTwoStar = new ArrayList<>();
            for (var wordWithoutOneStar : wordsWithoutOneStar) {
                wordsWithoutTwoStar.addAll(replaceStar(wordWithoutOneStar));
            }
            if (countOfStars > 2) {
                wordsWithoutThreeStar = new ArrayList<>();
                for (var wordWithoutTwoStar : wordsWithoutTwoStar) {
                    wordsWithoutThreeStar.addAll(replaceStar(wordWithoutTwoStar));
                }
                wordsWithoutStar.addAll(wordsWithoutThreeStar);
            } else {
                wordsWithoutStar.addAll(wordsWithoutTwoStar);
            }
        } else {
            wordsWithoutStar.addAll(wordsWithoutOneStar);
        }
        return wordsWithoutStar;
    }

    private static List<String> replaceStar(String word) {
        List<String> listWithReplacedStarSymbol = new ArrayList<>();
        String alphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        final int starIndex = word.indexOf("*");
        for (int i = 0; i < alphabet.length(); ++i) {
            StringBuilder newWord = new StringBuilder();
            newWord.append(word, 0, starIndex)
                    .append(alphabet.charAt(i))
                    .append(word, starIndex + 1, word.length());
            listWithReplacedStarSymbol.add(newWord.toString());
        }
        return listWithReplacedStarSymbol;
    }
}