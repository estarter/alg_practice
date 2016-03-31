import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by amerezhi on 3/30/16.
 */
public class MainTest {
    @Test
    public void testSimple() throws Exception {
        Order[] orders  = new Order[]{
                new Order("0 5 10"),
                new Order("3 7 14"),
                new Order("5 9 7"),
                new Order("6 9 8")
        };
        assertEquals(18, Main.findMaxPrice(orders));
    }
    @Test
    public void testAnotherExample() throws Exception {
        Order[] orders = new Order[] {
                new Order("0 5 6"),
                new Order("2 3 1"),
                new Order("8 5 11"),
                new Order("15 2 1"),
                new Order("15 5 10"),
                new Order("1 4 3"),
                new Order("20 1 1"),
                new Order("20 2 10"),
                new Order("25 2 15"),
                new Order("25 2 11")
        };
        assertEquals(52, Main.findMaxPrice(orders));
    }
    @Test
    public void testExample3() throws Exception {
        Order[] orders = new Order[] {
                new Order("0 5 6"),
                new Order("2 3 1"),
                new Order("8 5 11"),
                new Order("15 2 1"),
                new Order("15 5 10"),
                new Order("1 4 3"),
                new Order("20 1 1"),
                new Order("20 2 10"),
                new Order("25 2 15"),
                new Order("25 2 11")
        };
        assertEquals(52, Main.findMaxPrice(orders));
    }
    @Test
    public void testEmtpy() throws Exception {
        Order[] orders  = new Order[]{
        };
        assertEquals(0, Main.findMaxPrice(orders));
    }
    @Test
    public void testOne() throws Exception {
        Order[] orders  = new Order[]{
                new Order("0 5 10")
        };
        assertEquals(10, Main.findMaxPrice(orders));
    }
    @Test
    public void testSameLength() throws Exception {
        Order[] orders  = new Order[]{
                new Order("0 5 11"),
                new Order("0 5 10")
        };
        assertEquals(11, Main.findMaxPrice(orders));
    }
    @Test
    public void testShortIsBetter() throws Exception {
        Order[] orders  = new Order[]{
                new Order("0 5 10"),
                new Order("2 5 11")
        };
        assertEquals(11, Main.findMaxPrice(orders));
    }
}