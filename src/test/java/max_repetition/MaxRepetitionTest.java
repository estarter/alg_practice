package max_repetition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Alexey Merezhin
 */
class MaxRepetitionTest {

    @Test
    void getMaxRepetition() {
        assertEquals(4, MaxRepetition.getMaxRepetition(new int[]{3,1,2,2,3,4,4,4}));
    }
}