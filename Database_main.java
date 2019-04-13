package com.example.admin.kiemtrab;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.annotation.Nullable;

public class Database_main extends SQLiteOpenHelper {
    public Database_main(@Nullable Context context, @Nullable String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void CreateTable(String table){
        SQLiteDatabase db=getWritableDatabase();
        String sql="";
        switch (table){
            case "SP":
                sql="Create table if not exists "+table+"(id integer primary key autoincrement, masp varchar, tensp varchar," +
                        " mahang varchar, loai varchar, gia integer, img varchar)";
                db.execSQL(sql);
                break;
            case "Hang":
                sql="Create table if not exists "+table+" (mahang varchar, tenhang varchar )";
                db.execSQL(sql);
                break;
            case "Hoadon":
                sql="Create table if not exists "+table+"( )";
                db.execSQL(sql);
                break;
            case "Nguoidung":
                sql="Create table if not exists "+table+"(id integer primary key autoincrement, tk varchar, mk varchar, level integer )";
                db.execSQL(sql);
                break;
        }
    }
    public void DeleteItem(String table, int id){
        SQLiteDatabase db=getWritableDatabase();
        String sql1="delete from "+table+" where id="+id;
        db.execSQL(sql1);
    }
    public void InsertItem(String table, String row){
        SQLiteDatabase db=getWritableDatabase();
        String sql="insert into "+table+" values("+row+")";
        db.execSQL(sql);
    }
    public void UpdateItem(String table, String row, int vt){
        SQLiteDatabase db=getWritableDatabase();
        String sql="update "+table+" set "+row+" where id="+vt;
        db.execSQL(sql);
    }
    public Cursor getItems(String table){
        SQLiteDatabase db=getReadableDatabase();
        String sql="Select* from "+table;
        return db.rawQuery(sql,null);
    }
    public Cursor getItemsID(String table,String vt, String x ){
        SQLiteDatabase db=getReadableDatabase();
        String sql="";
        switch (x){
            case "id":
                 sql="Select* from "+ table+" where "+x+"="+Integer.parseInt(vt);
                 break;
            case "loai":
                sql="Select* from "+table+" where "+x+"='"+vt+"'";
                break;
            case "mahang":
                sql="Select* from "+table+" where "+x+"='"+vt+"'";
                break;
        }
        return db.rawQuery(sql,null);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
