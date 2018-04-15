package graphs.network_connectivity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.annotation.Annotation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @author Alexey Merezhin
 */
@ExtendWith(programTest.CustomIO.class)
class programTest {

    @Test
    void main() throws Exception {
        System.setIn(new ByteArrayInputStream(("7 8 2\n"+
                "1 2\n"+
                "1 4\n"+
                "4 2\n"+
                "4 3\n"+
                "3 1\n"+
                "5 6\n"+
                "5 7\n"+
                "7 6\n").getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        program.main(new String[]{});
        assertEquals("3", out.toString().trim());
    }

    public static class CustomIO implements BeforeAllCallback, AfterAllCallback {
        InputStream in;
        PrintStream out;

        @Override
        public void beforeAll(ExtensionContext context) {
            in = System.in;
            out = System.out;
        }

        @Override
        public void afterAll(ExtensionContext context) {
            System.setIn(in);
            System.setOut(out);
        }
    }
}