package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationsGenerator {
    private static List<String> wordCombinations = new ArrayList<>(109592);
    private static StringBuilder wordCombination = new StringBuilder();

    public static Set<String> generate(final char[] letters) {
        for (int i = 2; i < letters.length + 1; ++i) {
            permuteIteration(letters, 0, i);
        }
        wordCombination = null;
        Set<String> wordsSet = wordCombinations.stream()
                                                    .filter(x -> x.contains(String.valueOf(letters[letters.length - 1])))
                                                    .collect(Collectors.toCollection(HashSet::new));
        wordCombinations = null;
        return wordsSet;
    }

    private static void permuteIteration(char[] letters, int index, int limit){
        if (index >= limit) {
            for (int i = 0; i < limit; ++i) {
                wordCombination.append(letters[i]);
            }
            wordCombinations.add(wordCombination.toString());
            wordCombination.delete(0, wordCombination.length());
            return;
        }

        for (int i = index; i < letters.length; ++i) {
            swapLetter(letters, index, i);
            permuteIteration(letters, index + 1, limit);
            swapLetter(letters, index, i);
        }
    }

    private static void swapLetter(char[] letters, int first, int second) {
        char tmp = letters[first];
        letters[first] = letters[second];
        letters[second] = tmp;
    }
}