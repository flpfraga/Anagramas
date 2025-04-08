package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

class AnagramTest {

    @Test
    void testAnagramGenerationWithCommaSeparator() {
        Anagram anagram = new Anagram.Builder()
                .word("a,b,c")
                .separator(",")
                .build();
        
        anagram.make();
        Set<String> result = anagram.getAnagrams();
        
        assertEquals(6, result.size()); // 3! = 6 permutações possíveis
        assertTrue(result.contains("[a, b, c]"));
        assertTrue(result.contains("[a, c, b]"));
        assertTrue(result.contains("[b, a, c]"));
        assertTrue(result.contains("[b, c, a]"));
        assertTrue(result.contains("[c, a, b]"));
        assertTrue(result.contains("[c, b, a]"));
    }

    @Test
    void testAnagramGenerationWithSpaceSeparator() {
        Anagram anagram = new Anagram.Builder()
                .word("a b c")
                .separator(" ")
                .build();
        
        anagram.make();
        Set<String> result = anagram.getAnagrams();
        
        assertEquals(6, result.size());
        assertTrue(result.contains("[a, b, c]"));
    }

    @Test
    void testAnagramGenerationWithSingleLetter() {
        Anagram anagram = new Anagram.Builder()
                .word("a")
                .separator(",")
                .build();
        
        anagram.make();
        Set<String> result = anagram.getAnagrams();
        
        assertEquals(1, result.size());
        assertTrue(result.contains("[a]"));
    }

    @Test
    void testAnagramGenerationWithEmptyWord() {
        assertThrows(IllegalStateException.class, () -> {
            new Anagram.Builder()
                    .word("")
                    .separator(",")
                    .build();
        });
    }

    @Test
    void testAnagramGenerationWithNullWord() {
        assertThrows(IllegalStateException.class, () -> {
            new Anagram.Builder()
                    .word(null)
                    .separator(",")
                    .build();
        });
    }

    @Test
    void testAnagramGenerationWithInvalidCharacters() {
        assertThrows(IllegalStateException.class, () -> {
            new Anagram.Builder()
                    .word("a,1,c")
                    .separator(",")
                    .build();
        });
    }

    @Test
    void testAnagramGenerationWithRepeatedLetters() {
        Anagram anagram = new Anagram.Builder()
                .word("a,a,b")
                .separator(",")
                .build();
        
        anagram.make();
        Set<String> result = anagram.getAnagrams();
        
        assertEquals(3, result.size()); // 3! / 2! = 3 permutações únicas
    }

    @Test
    void testGetWord() {
        Anagram anagram = new Anagram.Builder()
                .word("test")
                .separator(",")
                .build();
        
        assertEquals("test", anagram.getWord());
    }

    @Test
    void testGetSeparator() {
        Anagram anagram = new Anagram.Builder()
                .word("test")
                .separator(",")
                .build();
        
        assertEquals(",", anagram.getSeparator());
    }

    @Test
    void testCountStack() {
        Anagram anagram = new Anagram.Builder()
                .word("a,b,c")
                .separator(",")
                .build();
        
        anagram.make();
        assertTrue(Anagram.getCountStack() > 0);
    }
} 