package src.model;
/**
 * 
 * @author Haris Ahmad
 *
 */
import java.util.Scanner;

public interface EssentialCalculations {
    void evaluate(int[] poly1, int x, int poly1Value);
    void differentiate(int[] polynomial, int[] diff_poly);
    void sumPoly(int[] poly1, int[] poly2, int[] polySum);
    boolean multiplyPolys(int[] poly1, int[] poly2, int[] product);
    double[] rootsPoly(int[] polynomial);
}
