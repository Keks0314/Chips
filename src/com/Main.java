package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public  class Main {
    private static Map<Character, CostAndNumber> map = new HashMap<>(33) {{
        put('а', new CostAndNumber(10, 1));
        put('б', new CostAndNumber(3, 3));
        put('в', new CostAndNumber(5, 2));
        put('г', new CostAndNumber(3, 3));
        put('д', new CostAndNumber(5, 2));
        put('е', new CostAndNumber(9, 1));
        put('ж', new CostAndNumber(2, 5));
        put('з', new CostAndNumber(2, 5));
        put('и', new CostAndNumber(8, 1));
        put('й', new CostAndNumber(4, 2));
        put('к', new CostAndNumber(6, 2));
        put('л', new CostAndNumber(4, 2));
        put('м', new CostAndNumber(5, 2));
        put('н', new CostAndNumber(8, 1));
        put('о', new CostAndNumber(10, 1));
        put('п', new CostAndNumber(6, 2));
        put('р', new CostAndNumber(6, 2));
        put('с', new CostAndNumber(6, 2));
        put('т', new CostAndNumber(5, 2));
        put('у', new CostAndNumber(3, 3));
        put('ф', new CostAndNumber(1, 10));
        put('х', new CostAndNumber(2, 5));
        put('ц', new CostAndNumber(1, 10));
        put('ч', new CostAndNumber(2, 5));
        put('ш', new CostAndNumber(1, 10));
        put('щ', new CostAndNumber(1, 10));
        put('ъ', new CostAndNumber(1, 10));
        put('ы', new CostAndNumber(2, 5));
        put('ь', new CostAndNumber(2, 5));
        put('э', new CostAndNumber(1, 10));
        put('ю', new CostAndNumber(1, 10));
        put('я', new CostAndNumber(3, 3));
        put('*', new CostAndNumber(3, 0));
    }};

    public static void main(String[] args) {
        char[] chips = chooseChips(8);
        System.out.println(Arrays.toString(chips));
    }

    private static char[] chooseChips(final int count) {
        char[] chips = new char[count];
        var random = ThreadLocalRandom.current();
        for (int i = 0; i < count; ++i) {
            char word = (char) (random.nextInt(0, 33) + 'а');
            if (word == 'ё') {
                ++word;
            }
            while (map.get(word).number == 0) {
                word = (char) (random.nextInt(0, 33) + 'а');
            }
            chips[i] = word;
            CostAndNumber last = map.get(word);
            map.put(word, new CostAndNumber(last.number - 1, last.cost));
        }
        return chips;
    }

    private static boolean isEqualWords(String first, String second) {
        first = first.toUpperCase();
        second = second.toUpperCase();
        byte[] firstBytes = first.getBytes();
        Arrays.sort(firstBytes);
        byte[] secondBytes = second.getBytes();
        Arrays.sort(secondBytes);
        return Arrays.equals(firstBytes, secondBytes);
    }
}