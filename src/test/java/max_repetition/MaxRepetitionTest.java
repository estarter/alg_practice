package max_repetition;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexey Merezhin
 */
public class MaxRepetitionTest {

    @Test
    public void getMaxRepetition() throws Exception {
        assertEquals(4, MaxRepetition.getMaxRepetition(new int[]{3,1,2,2,3,4,4,4}));
    }
}