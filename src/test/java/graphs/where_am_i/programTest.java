package graphs.where_am_i;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Alexey Merezhin
 */
public class programTest {

    @Test
    public void locateStart() throws Exception {
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
    public void pathLengthTest() {
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