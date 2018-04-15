package graphs.where_am_i;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Alexey Merezhin
 */
class programTest {

    @Test
    void locateStart() {
        boolean[][] field = new boolean[][]{
                {true, false, true, true, true, true, true, true, true, true},
                {false, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, false, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true}
        };
        short[][] location = new short[][]{
                {0, 1, 0},
                {1, 0, 2}
        };

        int[][] position = program.locateStart(field, location);
        assertArrayEquals(new int[]{1, 2}, position[0]);
    }

    @Test
    void pathLengthTest() {
        boolean[][] field = new boolean[][]{
                {true, false, true, true, true, true, true, true, true, true},
                {false, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, false, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true}
        };
        assertEquals(8, program.pathLenght(new int[][]{{1, 2}}, 3, 8, field));
    }
}