package com.beekay.hitit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



/**
 * Created by krishna on 10/6/2014.
 */
public class Helper {

    private static final String DBNAME="highscore.db";
    private static final String TABLE_NAME="score";
    private static final int VERSION=1;
    private static final String COLUMN="myscore";
    private static final String QUERY="create table if not exists score(myscore INTEGER not null DEFAULT (0) );";
    SQLiteDatabase db;
    private DBOpener opener;
    Context context;
    public Helper(Context context){
        this.context=context;
        opener=new DBOpener(context);
    }


    private class DBOpener extends SQLiteOpenHelper{




        public DBOpener(Context context) {
            super(context,DBNAME,null,VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            try{
                sqLiteDatabase.execSQL(QUERY);
                //insertData(0);
            }catch (android.database.SQLException e){
                Log.v("error",e.toString());
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS score");
        }
    }

    public Helper open(){
        db=opener.getWritableDatabase();
        Log.v("Opened","Writable");
        return this;

    }

    public void close(){
        opener.close();
    }

    public Helper openRead(){
        db=opener.getReadableDatabase();
        Log.v("Opened","Readable");
        return  this;
    }

    public long insertData(int score){

        db.delete(TABLE_NAME,null,null);
        ContentValues value=new ContentValues();
        value.put(COLUMN,score);
        return db.insertOrThrow(TABLE_NAME,null,value);

    }

    public Cursor retrive(){
        Log.v("came","to retrieve");
        return db.query(TABLE_NAME,new String[]{COLUMN},null,null,null,null,null);
    }
}
