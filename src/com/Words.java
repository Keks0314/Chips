package com;

import java.util.HashMap;
import java.util.Map;

public class Words {
    public static Map<Character, CostAndNumber> map = new HashMap<>(33) {{
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
}
