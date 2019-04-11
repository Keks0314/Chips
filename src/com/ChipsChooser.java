package com;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ChipsChooser {
    private static Map<Character, CostAndNumber> words = Words.map;

    public static char[] choose(final int count) {
        char[] chips = new char[count];
        var random = ThreadLocalRandom.current();
        for (int i = 0; i < count; ++i) {
            char word = (char) (random.nextInt(0, 33) + 'А');
            if (word == 'Ё') {
                ++word;
            }
            while (words.get(word).number == 0) {
                word = (char) (random.nextInt(0, 33) + 'А');
            }
            chips[i] = word;
            CostAndNumber last = words.get(word);
            words.put(word, new CostAndNumber(last.number - 1, last.cost));
        }
        return chips;
    }
}
