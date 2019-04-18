package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationsGenerator {
    private static List<String> wordCombinations = new ArrayList<>();
    private static StringBuilder letterCombination = new StringBuilder();

    public static Set<String> generate(final char[] letters) {
        for (int i = 2; i < letters.length + 1; ++i) {
            permuteIteration(letters, 0, i);
        }
        letterCombination = null;
        Set<String> wordsSet = wordCombinations.stream()
                                                .filter(x -> x.contains(String.valueOf(letters[letters.length - 1])))
                                                .collect(Collectors.toCollection(HashSet::new));
        wordCombinations = null;
        return wordsSet;
    }

    private static void permuteIteration(char[] letters, int index, int limit){
        if (index >= limit) {
            for (int i = 0; i < limit; ++i) {
                letterCombination.append(letters[i]);
            }
            String word = letterCombination.toString();
            if (word.contains("*")) {
                List<String> wordsWithoutStars = getWordsWithoutStars(word);
                wordCombinations.addAll(wordsWithoutStars);
            } else {
                wordCombinations.add(word);
            }
            letterCombination.delete(0, letterCombination.length());
            return;
        }

        for (int i = index; i < letters.length; ++i) {
            swapLetter(letters, index, i);
            permuteIteration(letters, index + 1, limit);
            swapLetter(letters, index, i);
        }
    }

    private static List<String> getWordsWithoutStars(String word) {
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

    private static void swapLetter(char[] letters, int first, int second) {
        char tmp = letters[first];
        letters[first] = letters[second];
        letters[second] = tmp;
    }
}