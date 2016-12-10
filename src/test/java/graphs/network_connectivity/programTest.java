package graphs.network_connectivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author Alexey Merezhin
 */
public class programTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void main() throws Exception {
        systemInMock.provideLines("7 8 2", 
                "1 2", 
                "1 4", 
                "4 2", 
                "4 3", 
                "3 1", 
                "5 6", 
                "5 7", 
                "7 6");
        program.main(new String[]{});
        assertEquals("3", systemOutRule.getLog().trim());
    }

}