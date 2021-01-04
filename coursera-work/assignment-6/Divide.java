package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide {
    // TODO - add your solution here.
    public static String divide(int a, int b)
    {
        int quotient = a / b;
        int remainder = a % b;
        return Integer.toString(quotient) + " R: "  + Integer.toString(remainder);
    }
}
