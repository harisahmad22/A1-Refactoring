package src.test;

import src.application.TextApp;
import src.model.ProcessCalculations;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testEvaluateOperation() {
        String input = "e\nq\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        TextApp.main(new String[]{});

        String expectedOutput = "You chose evaluate";

        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testDifferentiateOperation() {
        String input = "d\nq\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        TextApp.main(new String[]{});

        String expectedOutput = "You chose differentiate";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testAddOperation() {
        String input = "a\nq\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        TextApp.main(new String[]{});

        String expectedOutput = "You chose add";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testMultiplyOperation() {
        String input = "m\nq\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        TextApp.main(new String[]{});

        String expectedOutput = "You chose multiply";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testRootsOperation() {
        String input = "r\nq\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        TextApp.main(new String[]{});

        String expectedOutput = "You chose roots";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testSuccessfulQuitOperation() {
        String input = "q\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        TextApp.main(new String[]{});

        String expectedOutput = "***  Exiting program  ***";

        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testMulitpleOperations() {
        String input = "e\nr\nm\nq\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        TextApp.main(new String[]{});

        String expectedOutput = "You chose evaluate";
        String expectedOutput2 = "You chose roots";
        String expectedOutput3 = "You chose multiply";

        assertTrue(outContent.toString().contains(expectedOutput));
        assertTrue(outContent.toString().contains(expectedOutput2));
        assertTrue(outContent.toString().contains(expectedOutput3));
    }
}
