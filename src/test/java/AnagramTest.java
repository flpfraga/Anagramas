import org.example.Anagram;
import org.junit.jupiter.api.Test;
import resources.AnagramMockTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste da classe Anagram
 *
 * @author Felipe Carlos Fraga
 * @version 1.0
 * @since 08-03-2025
 */

public class AnagramTest {


    @Test
    void testBuilderCreateWithSucess(){
        Anagram anagram = new Anagram.Builder()
                .word("a,a,c,b")
                .separator(",")
                .build();
        assertNotNull(anagram);
        assertEquals("a,a,c,b",anagram.getWord());
        assertEquals(",", anagram.getSeparator());
    }

    @Test
    void testBuilderCreateWithErrorRegexWithNumber(){
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            new Anagram.Builder()
                    .word("1,a,c,b")
                    .separator(",")
                    .build();
        });
        assertEquals("Word deve conter apenas letras separadas por ,!", exception.getMessage());
    }

    @Test
    void testBuilderCreateWithErrorWordNull(){
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            new Anagram.Builder()
                    .separator(",")
                    .build();
        });
        assertEquals("Word não pode ser nula!", exception.getMessage());
    }

    @Test
    void testBuilderCreateWithErrorRegexSeparator(){
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            new Anagram.Builder()
                    .word("1,a,c,b")
                    .separator(";")
                    .build();
        });
        assertEquals("Word deve conter apenas letras separadas por ;!", exception.getMessage());
    }

    @Test
    void testBuilderMakeAnagramsWithSucess(){
        Anagram anagram = new Anagram.Builder()
                .word("a,b,c,d")
                .separator(",")
                .build();
        anagram.make();
        assertEquals(24, anagram.getAnagrams().size());
        assertEquals(AnagramMockTest.getAnagramsABCD(), anagram.getAnagrams());
    }

    @Test
    void testBuilderMakeAnagramsOneLetterWithSucess(){
        Set<String> expectedResponse = Set.of("[a]");
        Anagram anagram = new Anagram.Builder()
                .word("a")
                .separator(",")
                .build();
        anagram.make();
        assertEquals(1, anagram.getAnagrams().size());
        assertEquals(expectedResponse, anagram.getAnagrams());
    }

    @Test
    void testBuilderMakeAnagramsSameLettersWithSucess(){
        Set<String> expectedResponse = Set.of("[a, a, a, a]");
        Anagram anagram = new Anagram.Builder()
                .word("a,a,a,a")
                .separator(",")
                .build();
        anagram.make();
        assertEquals(1, anagram.getAnagrams().size());
        assertEquals(expectedResponse, anagram.getAnagrams());
    }
}
