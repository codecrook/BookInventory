package io.codecrook.bookinventory;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import io.codecrook.bookinventory.data.BookContract;
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

        EditText productNameEditText = findViewById(R.id.product_name_edit_text);
        EditText productPriceEditText = findViewById(R.id.product_price_edit_text);
        EditText productQuantityEditText = findViewById(R.id.product_quantity_edit_text);
        EditText supplierNameEditText = findViewById(R.id.supplier_name_edit_text);
        EditText supplierPhoneNoEditText = findViewById(R.id.supplier_phone_edit_text);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
