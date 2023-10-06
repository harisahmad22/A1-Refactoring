package src.test;


import src.model.BasicCalculations;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class BasicCalculationsTest {

    private BasicCalculations calculator;
    private int[] polynomial;

    @BeforeEach
    public void setUp() {
        calculator = new BasicCalculations();
        polynomial = new int[BasicCalculations.MAX_SIZE];
    }

    @Test
    public void testPrintPolyNegatives() {
        // Set the polynomial values for testing
        polynomial[8] = -6;
        polynomial[6] = -5;
        polynomial[4] = -3;

        // Redirect the standard output to capture printed content
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the printPoly method and capture the output
        calculator.printPoly(polynomial);
        String printedOutput = outputStream.toString().trim();

        // Restore standard output
        System.setOut(System.out);

        // Define the expected output
        String expectedOutput = "-6x^8 - 5x^6 - 3x^4";

        // Assert that the printed output matches the expected output
        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    public void testPrintPolyPositives() {
        // Set the polynomial values for testing
        polynomial[8] = 1;
        polynomial[2] = 2;
        polynomial[3] = 3;

        // Redirect the standard output to capture printed content
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the printPoly method and capture the output
        calculator.printPoly(polynomial);
        String printedOutput = outputStream.toString().trim();

        // Restore standard output
        System.setOut(System.out);

        // Define the expected output
        String expectedOutput = "x^8 + 3x^3 + 2x^2";

        // Assert that the printed output matches the expected output
        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    public void testPrintPolyOrdering() {
        // Set the polynomial values for testing
        polynomial[8] = 1;
        polynomial[2] = 6;
        polynomial[7] = 3;
        polynomial[10] = 4;
        polynomial[5] = 12;

        // Redirect the standard output to capture printed content
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the printPoly method and capture the output
        calculator.printPoly(polynomial);
        String printedOutput = outputStream.toString().trim();

        // Restore standard output
        System.setOut(System.out);

        // Define the expected output
        String expectedOutput = "4x^10 + x^8 + 3x^7 + 12x^5 + 6x^2";

        // Assert that the printed output matches the expected output
        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    public void testPrintPolyOrderingNegatives() {
        // Set the polynomial values for testing
        polynomial[8] = -1;
        polynomial[2] = -6;
        polynomial[7] = -3;
        polynomial[10] = -4;
        polynomial[5] = -12;

        // Redirect the standard output to capture printed content
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the printPoly method and capture the output
        calculator.printPoly(polynomial);
        String printedOutput = outputStream.toString().trim();

        // Restore standard output
        System.setOut(System.out);

        // Define the expected output
        String expectedOutput = "-4x^10 - x^8 - 3x^7 - 12x^5 - 6x^2";

        // Assert that the printed output matches the expected output
        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    public void testPrintPolyOrderingMixed() {
        // Set the polynomial values for testing
        polynomial[8] = -1;
        polynomial[2] = 6;
        polynomial[7] = -3;
        polynomial[10] = 4;
        polynomial[5] = -12;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        calculator.printPoly(polynomial);
        String printedOutput = outputStream.toString().trim();

        System.setOut(System.out);

        String expectedOutput = "4x^10 - x^8 - 3x^7 - 12x^5 + 6x^2";

        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    public void testReadPoly() {
        BasicCalculations basicCalc = new BasicCalculations();
        int[] polynomial = new int[BasicCalculations.MAX_SIZE];

        String input = "3 4\n-2 2\n5 1\n0 0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);

        basicCalc.readPoly(polynomial);

        // Assert that the polynomial array has been populated correctly
        assertEquals(3, polynomial[4]);
        assertEquals(-2, polynomial[2]);
        assertEquals(5, polynomial[1]);
    }
}
