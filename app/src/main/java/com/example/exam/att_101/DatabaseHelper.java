package com.example.exam.att_101;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "studentInfo";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "name";
    public static final String COL_3 = "rollno";
    public static final String COL_4 = "dept";
    public static final String COL_5 = "attendance";




    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,rollno INTEGER,dept TEXT,attendance  INTEGER DEFAULT(0))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String rollno,String dept) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,rollno);
        contentValues.put(COL_4,dept);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public void update(int[] ids,int numRows) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i=0,m=0;i<numRows;i++) {

            Cursor c = db.rawQuery("update "+TABLE_NAME+" set attendance = attendance+1 where ID ="+ids[m],null);
             c.moveToFirst();
            c.close();

        }
    }
}
