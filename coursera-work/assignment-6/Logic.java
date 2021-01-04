package mooc.vandy.java4android.calculator.logic;

import java.util.HashMap;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    
    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out) {
        mOut = out;
        
    }

    

    /**
     * Perform the operation on argumentOne and argumentTwo.
     */
    public void process(int argumentOne, int argumentTwo, int operation) {
        // TODO - Put your code here.
        switch (operation)
        {
            case 1:
                mOut.print(Add.add(argumentOne, argumentTwo));
                break;
            case 2:
                mOut.print(Subtract.subtract(argumentOne,argumentTwo));
                break;
            case 3:
                mOut.print(Multiply.multiply(argumentOne,argumentTwo));
                break;
            case 4:
                if (argumentTwo == 0)
                {
                    mOut.print("Can't divide by zero");
                }
                else
                {
                    mOut.print(Divide.divide(argumentOne, argumentTwo));
                }
        }
    }
}
