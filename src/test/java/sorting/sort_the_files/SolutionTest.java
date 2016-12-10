package sorting.sort_the_files;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Alexey Merezhin
 */
public class SolutionTest {

    @Test
    public void sort_the_files() {
        List<String> expectation = new ArrayList<>();
        expectation.add("IMG1.jpg");
        expectation.add("IMG10.jpg");
        expectation.add("IMG11.jpg");
        expectation.add("IMG12.jpg");
        expectation.add("IMG13.jpg");
        expectation.add("IMG14.jpg");
        expectation.add("IMG15.jpg");
        expectation.add("IMG16.jpg");
        expectation.add("IMG2.jpg");
        expectation.add("IMG3.jpg");
        expectation.add("IMG4.jpg");
        expectation.add("IMG5.jpg");
        expectation.add("IMG6.jpg");
        expectation.add("IMG7.jpg");
        expectation.add("IMG8.jpg");
        expectation.add("IMG9.jpg");

        List<String> result = new ArrayList<>();
        Solution.sort_the_files(16, result);
        assertEquals(expectation, result);
    }
}