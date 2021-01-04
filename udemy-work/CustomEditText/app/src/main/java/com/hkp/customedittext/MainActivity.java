package com.hkp.customedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView etFirstName, etLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (AutoCompleteTextView) findViewById(R.id.etFirstName);
        etLastName = (AutoCompleteTextView) findViewById(R.id.etLastName);

        String[] first = {"James", "John", "Lucas", "Sam", "Jeremiah", "Jenny", "Jennifer"};
        String[] last = {"Bluckermau", "Roberts", "Smith", "Jameson", "Roy", "Brickman"};

        ArrayAdapter<String> firstAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, first);
        etFirstName.setAdapter(firstAdapter);
        etFirstName.setThreshold(1);

        ArrayAdapter<String> lastAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, last);
        etLastName.setAdapter(lastAdapter);
        etLastName.setThreshold(1);
    }
}