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
        assertFalse(ftl.findTwoLetters('O', 'O'));

        assertFalse(ftl.findTwoLetters('H', 'H'));
        assertFalse(ftl.findTwoLetters('A', 'H'));
        assertFalse(ftl.findTwoLetters('L', 'H'));
        assertFalse(ftl.findTwoLetters('O', 'H'));

        assertTrue(ftl.findTwoLetters('H', 'A'));
        assertFalse(ftl.findTwoLetters('A', 'A'));
        assertFalse(ftl.findTwoLetters('L', 'A'));
        assertFalse(ftl.findTwoLetters('O', 'A'));

        assertTrue(ftl.findTwoLetters('H', 'L'));
        assertTrue(ftl.findTwoLetters('A', 'L'));
        assertFalse(ftl.findTwoLetters('L', 'L'));
        assertFalse(ftl.findTwoLetters('O', 'L'));
    }

    @Test
    public void testABC() throws NoSuchFieldException, IllegalAccessException {
        FindTwoLetters ftl = new FindTwoLetters("ABCAB");
        assertTrue(ftl.findTwoLetters('A', 'A'));
        assertTrue(ftl.findTwoLetters('B', 'A'));
        assertTrue(ftl.findTwoLetters('C', 'A'));
        assertTrue(ftl.findTwoLetters('A', 'B'));
        assertTrue(ftl.findTwoLetters('B', 'B'));
        assertTrue(ftl.findTwoLetters('C', 'B'));
        assertTrue(ftl.findTwoLetters('A', 'C'));
        assertTrue(ftl.findTwoLetters('B', 'C'));
        assertFalse(ftl.findTwoLetters('C', 'C'));
    }

    @Test
    public void testABCD() throws NoSuchFieldException, IllegalAccessException {
        FindTwoLetters ftl = new FindTwoLetters("ABCDAB");
        assertTrue(ftl.findTwoLetters('A', 'B'));
        assertTrue(ftl.findTwoLetters('B', 'B'));
        assertTrue(ftl.findTwoLetters('C', 'B'));
        assertTrue(ftl.findTwoLetters('D', 'B'));

        assertTrue(ftl.findTwoLetters('A', 'A'));
        assertTrue(ftl.findTwoLetters('B', 'A'));
        assertTrue(ftl.findTwoLetters('C', 'A'));
        assertTrue(ftl.findTwoLetters('D', 'A'));

        assertTrue(ftl.findTwoLetters('A', 'D'));
        assertTrue(ftl.findTwoLetters('B', 'D'));
        assertTrue(ftl.findTwoLetters('C', 'D'));
        assertFalse(ftl.findTwoLetters('D', 'D'));

        assertTrue(ftl.findTwoLetters('A', 'C'));
        assertTrue(ftl.findTwoLetters('B', 'C'));
        assertFalse(ftl.findTwoLetters('C', 'C'));
        assertFalse(ftl.findTwoLetters('D', 'C'));
    }

    @Test
    public void testBigString() throws NoSuchFieldException, IllegalAccessException {
        FindTwoLetters ftl = new FindTwoLetters("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertTrue(ftl.findTwoLetters('A', 'Z'));
        assertTrue(ftl.findTwoLetters('A', 'A'));
        assertTrue(ftl.findTwoLetters('Z', 'A'));
    }

}