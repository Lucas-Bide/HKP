package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage
       extends House {

    // TODO - Put your code here.
    private boolean mSecondFloor;

    public Cottage(int dimension, int lotLength, int lotWidth) {
        super(dimension, dimension, lotLength, lotWidth);
        mSecondFloor = false;
    }

    public Cottage(int dimension, int lotLength, int lotWidth, String mOwner, boolean mSecondFloor) {
        super(dimension, dimension, lotLength, lotWidth, mOwner);
        this.mSecondFloor = mSecondFloor;
    }

    public boolean hasSecondFloor()
    {
        return mSecondFloor;
    }

    public String toString()
    {
        return super.toString();
    }
}

