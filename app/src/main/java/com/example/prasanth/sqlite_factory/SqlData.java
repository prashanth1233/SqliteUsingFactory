package com.example.prasanth.sqlite_factory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlData extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="rayDetails.db";
    private static final String TABLE_NAME="rayTable";
    private static final int DATABASE_VERSION=1;
    private static final String COLUMN_1="First_Name";
    private static final String COLUMN_2="Last_Name";
    private static final String COLUMN_3="Age";
    private static final String CREATE_TABLE="create table "+TABLE_NAME+"("+COLUMN_1+" TEXT,"+COLUMN_2+" TEXT,"+COLUMN_3+" TEXT"+")";


    public  SqlData(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        String str="DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(str);
        onCreate(db);
    }

    public long insertData(Model_Factory model)
    {
        SQLiteDatabase sqLiteDatabase1=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_1,model.getFirstName());
        contentValues.put(COLUMN_2,model.getLastName());
        contentValues.put(COLUMN_3,model.getNickName());
        long check= sqLiteDatabase1.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase1.close();
        return check;
    }

    public String searchingData(String name1,String name2)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String str2="select "+COLUMN_3+ " from "+TABLE_NAME+ " where "+COLUMN_1+" = '"+name1+"' AND "+COLUMN_2+" = '"+name2+"'";
        Cursor cursor=sqLiteDatabase.rawQuery(str2,null);

        if(cursor.getCount()>0)
        {

            cursor.moveToFirst();
            return cursor.getString(0);
        }
        else
        {
          return null;
        }
    }
}
