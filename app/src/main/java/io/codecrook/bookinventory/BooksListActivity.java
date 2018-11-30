package io.codecrook.bookinventory;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import io.codecrook.bookinventory.data.BookContract.BookEntry;
import io.codecrook.bookinventory.data.BookDbHelper;

public class BooksListActivity extends AppCompatActivity {

    private BookDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        mDbHelper = new BookDbHelper(this);

        FloatingActionButton addNewFab = findViewById(R.id.add_new_fab);
        addNewFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editorIntent = new Intent(BooksListActivity.this, EditorActivity.class);
                startActivity(editorIntent);
            }
        });

        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        BookDbHelper mDbHelper = new BookDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String [] projection = {
                BookEntry._ID,
                BookEntry.COLUMN_PRODUCT_NAME,
                BookEntry.COLUMN_PRODUCT_PRICE,
                BookEntry.COLUMN_PRODUCT_QUANTITY,
                BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME,
                BookEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NO
        };

        Cursor cursor = db.query(
                BookEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null);

        TextView displayView = findViewById(R.id.books_text_view);
        try {
            displayView.setText("The books table contains " + cursor.getCount() + " books\n\n");
            displayView.append(BookEntry._ID + " - " +
                    BookEntry.COLUMN_PRODUCT_NAME + "\n");


            int idColumnIndex = cursor.getColumnIndex(BookEntry._ID);
            int productNameColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_PRODUCT_NAME);


            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(productNameColumnIndex);
                displayView.append(("\n" + currentID + " - " +
                        currentName));
            }
        } finally {
            cursor.close();
        }
    }

    private void insertBook() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BookEntry.COLUMN_PRODUCT_NAME, "ABC");
        values.put(BookEntry.COLUMN_PRODUCT_PRICE, 100);
        values.put(BookEntry.COLUMN_PRODUCT_QUANTITY, 10);
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME, "XYZ");
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NO, "9658243470");

        db.insert(BookEntry.TABLE_NAME, null, values);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_booklist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_insert_dummy:
                insertBook();
                displayDatabaseInfo();
            case R.id.action_delete_all:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
