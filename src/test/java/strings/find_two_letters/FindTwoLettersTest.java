package strings.find_two_letters;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by estarter on 31/03/16.
 */
public class FindTwoLettersTest {

    @Test
    public void testExample() throws NoSuchFieldException, IllegalAccessException {
        FindTwoLetters ftl = new FindTwoLetters("HALO");
        assertTrue(ftl.findTwoLetters('H', 'O'));
        assertTrue(ftl.findTwoLetters('A', 'O'));
        assertTrue(ftl.findTwoLetters('L', 'O'));
        assertFalse(ftl.findTwoLetters('O', 'L'));
    }

    @Test
    public void testBigString() throws NoSuchFieldException, IllegalAccessException {
        FindTwoLetters ftl = new FindTwoLetters("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertTrue(ftl.findTwoLetters('A', 'Z'));
        assertTrue(ftl.findTwoLetters('A', 'A'));
        assertTrue(ftl.findTwoLetters('Z', 'A'));
    }
}