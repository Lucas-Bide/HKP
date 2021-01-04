package com.hkp.textfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText etName, etSurname;
    TextView tvResults;
    Button btnAdd, btnSave;
    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        tvResults = findViewById(R.id.tvResults);
        btnAdd = findViewById(R.id.btnAdd);
        btnSave = findViewById(R.id.btnSave);

        persons = new ArrayList<>();
        loadData();
    }

    public void btnAddData(View v) {
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        persons.add(new Person(name, surname));
        setTextToTextView();
    }

    private void setTextToTextView() {
        String text = "";

        for (Person p : persons) {
            text += p.getName() + " " + p.getSurname() + "\n";
        }
        tvResults.setText(text);
    }

    public void btnSaveData(View v) {
        try {
            FileOutputStream fos = openFileOutput("Data.txt", MODE_PRIVATE);
            OutputStreamWriter outfile = new OutputStreamWriter(fos);

            for (Person p : persons) {
                outfile.write(p.getName() + "," + p.getSurname() + "\n");
            }

            outfile.flush();
            outfile.close();

            Toast.makeText(MainActivity.this, "Data successfully saved to file", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void loadData() {
        persons.clear();

        File file = getApplicationContext().getFileStreamPath("Data.txt");
        String lineFromFile;

        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("Data.txt")));
                while ((lineFromFile = reader.readLine()) != null) {
                    StringTokenizer token = new StringTokenizer(lineFromFile, ",");
                    persons.add(new Person(token.nextToken(), token.nextToken()));
                }
                reader.close();
                setTextToTextView();
            } catch (IOException e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}