package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office
       extends Building {

    // TODO - Put your code here.
    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = null;
        this.mParkingSpaces = 0;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String mBusinessName) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = mBusinessName;
        this.mParkingSpaces = 0;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String mBusinessName, int mParkingSpaces) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = mBusinessName;
        this.mParkingSpaces = mParkingSpaces;
        sTotalOffices++;
    }

    public static int getTotalOffices() {
        return sTotalOffices;
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public void setBusinessName(String mBusinessName) {
        this.mBusinessName = mBusinessName;
    }

    public int getParkingSpaces() {
        return mParkingSpaces;
    }

    public void setParkingSpaces(int mParkingSpaces) {
        this.mParkingSpaces = mParkingSpaces;
    }

    public String toString() {
        String result = "Business: " + (mBusinessName == null ? "unoccupied" : mBusinessName);
        if (mParkingSpaces > 0)
        {
            result += "; has " + mParkingSpaces + " parking spaces";
        }
        result += " (total offices: " + sTotalOffices + ")";
        return result;
    }

    public boolean equals(Object f)
    {
        return this.mParkingSpaces == ((Office)f).getParkingSpaces() && this.calcBuildingArea() == ((Office)f).calcBuildingArea();
    }

}
