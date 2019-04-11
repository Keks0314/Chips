package com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class WordsTest {
    private static Map<Character, CostAndNumber> map;

    @Before
    public void init() {
        map = Words.map;
    }

    @Test
    public void А() {
        assertNotNull(map.get('А'));
    }

    @Test
    public void Б() {
        assertNotNull(map.get('Б'));
    }
    @Test
    public void В() {
        assertNotNull(map.get('В'));
    }

    @Test
    public void Г() {
        assertNotNull(map.get('Г'));
    }

    @Test
    public void Д() {
        assertNotNull(map.get('Д'));
    }

    @Test
    public void Е() {
        assertNotNull(map.get('Е'));
    }

    @Test
    public void Ж() {
        assertNotNull(map.get('Ж'));
    }

    @Test
    public void З() {
        assertNotNull(map.get('З'));
    }

    @Test
    public void И() {
        assertNotNull(map.get('И'));
    }

    @Test
    public void Й() {
        assertNotNull(map.get('Й'));
    }

    @Test
    public void К() {
        assertNotNull(map.get('К'));
    }

    @Test
    public void Л() {
        assertNotNull(map.get('Л'));
    }

    @Test
    public void М() {
        assertNotNull(map.get('М'));
    }

    @Test
    public void Н() {
        assertNotNull(map.get('Н'));
    }

    @Test
    public void О() {
        assertNotNull(map.get('О'));
    }

    @Test
    public void П() {
        assertNotNull(map.get('П'));
    }

    @Test
    public void Р() {
        assertNotNull(map.get('Р'));
    }

    @Test
    public void С() {
        assertNotNull(map.get('С'));
    }

    @Test
    public void Т() {
        assertNotNull(map.get('Т'));
    }

    @Test
    public void У() {
        assertNotNull(map.get('У'));
    }

    @Test
    public void Ф() {
        assertNotNull(map.get('Ф'));
    }

    @Test
    public void Х() {
        assertNotNull(map.get('Х'));
    }

    @Test
    public void Ц() {
        assertNotNull(map.get('Ц'));
    }

    @Test
    public void Ш() {
        assertNotNull(map.get('Ш'));
    }

    @Test
    public void Щ() {
        assertNotNull(map.get('Щ'));
    }

    @Test
    public void Ъ() {
        assertNotNull(map.get('Ъ'));
    }

    @Test
    public void Ы() {
        assertNotNull(map.get('Ы'));
    }

    @Test
    public void Ь() {
        assertNotNull(map.get('Ь'));
    }

    @Test
    public void Э() {
        assertNotNull(map.get('Э'));
    }

    @Test
    public void Ю() {
        assertNotNull(map.get('Ю'));
    }

    @Test
    public void Я() {
        assertNotNull(map.get('Я'));
    }

    @Test
    public void звезда() {
        assertNotNull(map.get('*'));
    }

    @After
    public void delete() {
        map = null;
    }
}