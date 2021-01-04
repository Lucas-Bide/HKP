package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    private int mSwing;

    public Gate()
    {
        mSwing = CLOSED;
    }

    public boolean setSwing(int direction)
    {
        boolean valid = false;
        if (direction >= -1 && direction <= 1)
        {
            valid = true;
            mSwing = direction;
        }
        return valid;
    }

    public boolean open(int direction)
    {
        return direction == CLOSED ? false : setSwing(direction);
    }

    public void close()
    {
        mSwing = CLOSED;
    }

    public int getSwingDirection()
    {
        return mSwing;
    }

    public int thru(int count)
    {
        return mSwing == CLOSED ? 0 : mSwing == IN ? count : -count;
    }

    public String toString()
    {
        String status;
        switch(mSwing) {
            case CLOSED:
                status = "This gate is closed";
                break;
            case IN:
                status = "This gate is open and swings to enter the pen only";
                break;
            case OUT:
                status = "This gate is open and swings to exit the pen only";
                break;
            default:
                status = "This gate has an invalid swing direction";
        }
        return status;
    }

}
