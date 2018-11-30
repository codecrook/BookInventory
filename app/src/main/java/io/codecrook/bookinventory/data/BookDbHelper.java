package io.codecrook.bookinventory.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import io.codecrook.bookinventory.data.BookContract.BookEntry;

public class BookDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bookstore.db";
    private static final int DATABASE_VERSION = 1;

    public BookDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_BOOKS_TABLE = "CREATE TABLE " +BookEntry.TABLE_NAME+ "("
                +BookEntry._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +BookEntry.COLUMN_PRODUCT_NAME+ " TEXT NOT NULL, "
                +BookEntry.COLUMN_PRODUCT_PRICE+ " INTEGER NOT NULL DEFAULT 0, "
                +BookEntry.COLUMN_PRODUCT_QUANTITY+ " INTEGER NOT NULL DEFAULT 0, "
                +BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME+ " TEXT, "
                +BookEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NO+ " TEXT);";

        db.execSQL(SQL_CREATE_BOOKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
