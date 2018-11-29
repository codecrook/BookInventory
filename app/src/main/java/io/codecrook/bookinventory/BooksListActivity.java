package io.codecrook.bookinventory;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BooksListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        FloatingActionButton addNewFab = findViewById(R.id.add_new_fab);
        addNewFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editorIntent = new Intent(BooksListActivity.this, EditorActivity.class);
                startActivity(editorIntent);
            }
        });
    }
}
