import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.spec.ECField;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {
    private static StringManipulator manipulator;

    @BeforeAll
    static void setupBeforeTest() throws Exception {

        manipulator = new StringManipulator();
    }

    @Test
    void testConcatenate() {
//        StringManipulator manipulator = new StringManipulator();
        assertEquals("Hello World", manipulator.concatenate("Hello", "World"));
    }

    @Test
    void testFindLength() {
//        StringManipulator manipulator = new StringManipulator();
        assertEquals(5, manipulator.findLength("Hello"));
    }

    @Test
    void testConvertToUpperCase() {
//        StringManipulator manipulator = new StringManipulator();
        assertEquals("HELLO", manipulator.convertToUpperCase("hello"));
    }

    @Test
    void testConvertToLowerCase() {
//        StringManipulator manipulator = new StringManipulator();
        assertEquals("hello", manipulator.convertToLowerCase("HELLO"));
    }

    @Test
    void testContainsSubstring() {
//        StringManipulator manipulator = new StringManipulator();
        assertTrue(manipulator.containsSubstring("Hello World", "World"));
        assertFalse(manipulator.containsSubstring("Hello World", "world"));
    }
}
