package com.hkp.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText etName, etPhone;
    Button btnSubmit, btnShowData, btnEditData, btnDeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
    }

    public void btnSubmit(View v) {
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();

        try {
            ContactDB db = new ContactDB(this);
            db.open();
            db.createEntry(name, phone);
            db.close();
            Toast.makeText(MainActivity.this, "Successfully saved", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etPhone.setText("");
        }
        catch (SQLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void btnShowData(View v) {
        startActivity(new Intent(MainActivity.this, Data.class));
    }

    public void btnEditData(View v) {
        try {
            ContactDB db = new ContactDB(this);
            db.open();
            // db.updateEntry(id, name, phone);
            db.close();
            Toast.makeText(MainActivity.this, "Successfully updated / NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void btnDeleteData(View v) {
        try {
            ContactDB db = new ContactDB(this);
            db.open();
            //db.deleteEntry(id, name, phone);
            db.close();
            Toast.makeText(MainActivity.this, "Successfully deleted / NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}