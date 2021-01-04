package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House
       extends Building {

    // TODO - Put your code here.
    private String mOwner;
    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = null;
        this.mPool = false;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = owner;
        this.mPool = false;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean mPool) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = owner;
        this.mPool = mPool;
    }

    public String getOwner() {
        return mOwner;
    }

    public boolean hasPool() {
        return mPool;
    }

    public void setOwner(String mOwner) {
        this.mOwner = mOwner;
    }

    public void setPool(boolean mPool) {
        this.mPool = mPool;
    }

    public String toString()
    {
        String result = "Owner: " + (mOwner == null ? "n/a" : mOwner);
        if (mPool)
        {
            result += "; has a pool";
        }
        if (calcLotArea() - calcBuildingArea() > calcBuildingArea())
        {
            result += "; has a big open space";
        }
        return result;
    }

    public boolean equals(Object h)
    {
        return this.calcBuildingArea() == ((House)h).calcBuildingArea() && this.mPool == ((House)h).mPool;
    }
}
