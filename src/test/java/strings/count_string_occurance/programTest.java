package strings.count_string_occurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Alexey Merezhin
 */
class programTest {
    @Test
    void testCount() {
        assertEquals(1, program.getCount("aba", "ab"));
        assertEquals(1, program.getCount("aba", "ba"));
        assertEquals(2, program.getCount("aba", "a"));

        assertEquals(2, program.getCount("alala", "la"));
        assertEquals(2, program.getCount("alalala", "lala"));

        assertEquals(1, program.getCount("alabala", "alabala"));

        assertEquals(2, program.getCount("abcbabcba", "abcba"));
        assertEquals(2, program.getCount("bbcbbcbb", "bbcbb"));
        assertEquals(2, program.getCount("bbbcbbbcbbb", "bbbcbbb"));
        assertEquals(2, program.getCount("bbbbcbbbbcbbbb", "bbbbcbbbb"));
        assertEquals(1, program.getCount("bbbbccbbbbccbbbb", "bbbbccbbbb"));

//        assertEquals(2, program.getCount("babalabalabalatheend", "alabala"));
    }
}