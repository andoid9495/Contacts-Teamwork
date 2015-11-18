package com.example.contact.Contacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SONY1 on 11/16/2015.
 */
public class ContactsDBOpenHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME="Contacts"; /////////////////
    public static final String DATABASE_VERSION="1";

    public static final String TABLE_CONTACT="contact";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_ADDRESS="address";
    public static final String COLUMN_IMAGE="image";

    public static final String QUERY_CREATE_TABLE_CONTACT =
            "CREATE TABLE "+ TABLE_CONTACT +" ( "+
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_PHONE + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_ADDRESS + " TEXT, " +
                    COLUMN_IMAGE + " BLOB) ";


    public ContactsDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(QUERY_CREATE_TABLE_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_CONTACT);
        onCreate(db);
    }
}
