package com.hkp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactDB {

    public static final String KEY_ID = "_id";
    public static  final String KEY_NAME = "person_name";
    public static  final String KEY_PHONE = "_phone";

    private final String DATABASE_NAME = "ContactsDB";
    private final String DATABASE_TABLE = "ContactsTable";
    private final int DATABASE_VERSION = 1;

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDB;

    public ContactDB(Context context) {
        ourContext = context;
    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String sqlCode = "CREATE TABLE " + DATABASE_TABLE + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_NAME + " TEXT NOT NULL, " +
                    KEY_PHONE + " TEXT NOT NULL);";

            db.execSQL(sqlCode);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public ContactDB open() throws SQLException {
        ourHelper = new DBHelper(ourContext);
        ourDB = ourHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        ourHelper.close();
    }

    public long createEntry(String name, String phone) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_PHONE, phone);
        return ourDB.insert(DATABASE_TABLE, null, cv);
    }

    public String getData() {
        String[] columns = {KEY_ID, KEY_NAME, KEY_PHONE};

        Cursor c = ourDB.query(DATABASE_TABLE, columns, null, null, null, null, null);

        String result = "";

        int iID = c.getColumnIndex(KEY_ID);
        int iName = c.getColumnIndex(KEY_NAME);
        int iPhone = c.getColumnIndex(KEY_PHONE);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result += c.getString(iID) + ": " + c.getString(iName) + " " + c.getString(iPhone) + "\n";
        }

        return result;
    }

    public long deleteEntry(String id) {
        return ourDB.delete(DATABASE_TABLE, KEY_ID + "=?", new String[] {id});
    }

    public long updateEntry(String id, String name, String phone) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_PHONE, phone);

        return ourDB.update(DATABASE_TABLE, cv, KEY_ID + "=?", new String[] {id});
    }
}
