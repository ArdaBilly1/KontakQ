package com.example.kontakq.libraries;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static java.sql.Types.VARCHAR;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);


    }
    public DbHelper(Context context){
        super(context,"kontak.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS kontak(id integer PRIMARY KEY, nama VARCHAR, nomor VARCHAR)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS kontak";
        db.execSQL(sql);
        this.onCreate(db);
    }

    public Cursor executeRead(String sql)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }
    public void executeWrite(String sql)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
}

