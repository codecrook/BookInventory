package io.codecrook.bookinventory;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import io.codecrook.bookinventory.data.BookContract.BookEntry;
import io.codecrook.bookinventory.data.BookDbHelper;

public class EditorActivity extends AppCompatActivity {

    EditText productNameEditText;
    EditText productPriceEditText;
    EditText productQuantityEditText;
    EditText supplierNameEditText;
    EditText supplierPhoneNoEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        productNameEditText = findViewById(R.id.product_name_edit_text);
        productPriceEditText = findViewById(R.id.product_price_edit_text);
        productQuantityEditText = findViewById(R.id.product_quantity_edit_text);
        supplierNameEditText = findViewById(R.id.supplier_name_edit_text);
        supplierPhoneNoEditText = findViewById(R.id.supplier_phone_edit_text);
    }

    private void insertBook() {

        String productName = productNameEditText.getText().toString().trim();
        String productPriceText = productPriceEditText.getText().toString();
        int productPrice = Integer.parseInt(productPriceText);
        String productQuantityText = productQuantityEditText.getText().toString();
        int productQuantity = Integer.parseInt(productQuantityText);
        String supplierName = supplierNameEditText.getText().toString().trim();
        String supplierPhone = supplierPhoneNoEditText.getText().toString().trim();


        BookDbHelper mDbHelper = new BookDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BookEntry.COLUMN_PRODUCT_NAME, productName);
        values.put(BookEntry.COLUMN_PRODUCT_PRICE, productPrice);
        values.put(BookEntry.COLUMN_PRODUCT_QUANTITY, productQuantity);
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME, supplierName);
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NO, supplierPhone);

        long newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(this, "Error With Saving book", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Book saved with ID" +newRowId, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertBook();
                finish();
                return true;
            case R.id.action_delete:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
