package com.example.kavya.broadcast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kavya on 2/5/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="numberDb";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE="create table "+DBcontract.Table_Name+"(id integer primary key autoincrement,"+DBcontract.Incoming_Number+"text);";
    private static final String DROP_TABLE="drop table if exixtss"+DBcontract.Table_Name;

public  DBHelper(Context context)
{
    super(context,DATABASE_NAME,null,DATABASE_VERSION);
}
    public void onCreate(SQLiteDatabase db) {
db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL(DROP_TABLE);
 onCreate(db);
    }
    public void saveNumber(String number,SQLiteDatabase database)
    {
        ContentValues contenntValues=new ContentValues();
        contenntValues.put(DBcontract.Incoming_Number,number);
        database.insert(DBcontract.Table_Name,null,contenntValues);
    }
    public Cursor readNumber(SQLiteDatabase database)
    {
        String[] projection={"id",DBcontract.Incoming_Number};
        return(database.query(DBcontract.Table_Name,projection,null,null,null,null,null));
    }
}
