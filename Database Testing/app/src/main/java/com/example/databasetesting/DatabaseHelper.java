package com.example.databasetesting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "HomeSpaceTesting";
    private static final int DB_VERSION = 1;

    //Table Name
    private static final String TABLE_NAME = "categories";

    //Table column
    private static final String KEY_ID = "category_id";
    private static final String KEY_NAME = "category_name";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
                String CREATE_CATEGORY_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        KEY_ID + " INTEGER PRIMARY KEY," +
                        KEY_NAME + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "categories");
        onCreate(sqLiteDatabase);
    }

    public void addCategory(Category category){
        SQLiteDatabase db = this.getWritableDatabase();

        //Content Values
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, category.getCategory_name());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public Category getCategory(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_ID, KEY_NAME}, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Category category = new Category(cursor.getString());

        return category;
    }
}
