package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    public FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here
    public void setCorralGates(Gate[] gate, Random rand)
    {
        for (int i = 0; i < gate.length; i++)
        {
            gate[i].setSwing(rand.nextInt(3) - 1);
            mOut.println("Gate " + i + ": " + gate[i].toString());
        }
    }

    public boolean anyCorralAvailable(Gate[] corral)
    {
        boolean result = false;
        for (int i = 0; i < corral.length; i++)
        {
            if (corral[i].getSwingDirection() == Gate.IN)
            {
                result = true;
                break;
            }
        }
        return result;
    }

    public int corralSnails(Gate[] corral, Random rand)
    {
        int attempts = 0;
        int pasture = 5;
        while (pasture > 0)
        {
            int cIndex = rand.nextInt(corral.length);
            int snails = rand.nextInt(pasture) + 1;
            int diff = corral[cIndex].thru(snails);
            pasture -= diff;
            if (diff != 0)
            {
                mOut.println(snails + " are trying to move through corral " + cIndex);
            }
            attempts++;
        }
        mOut.println("It took " + attempts + "attempts to corral all of the snails.");
        return attempts;
    }

}
