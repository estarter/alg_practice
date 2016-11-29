package strings.count_string_occurance;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexey Merezhin
 */
public class programTest {
    @Test
    public void testCount() throws Exception {
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
        assertEquals(2, program.getCount("bbbbccbbbbccbbbb", "bbbbccbbbb"));

//        assertEquals(2, program.getCount("babalabalabalatheend", "alabala"));
    }
}