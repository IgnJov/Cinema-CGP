package com.example.databasetesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
        dbHelper.addCategory(new Category("Food"));
        Category category = dbHelper.getCategory();
        Toast.makeText(MainActivity.this, category.getCategory_name(), Toast.LENGTH_LONG).show();
    }
}