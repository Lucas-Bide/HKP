package com.hkp.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Person> people;

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<>();
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Peter", "Jennings", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Peter", "Jennings", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Peter", "Jennings", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));

        myAdapter = new PersonAdapter(this, people);
        recyclerView.setAdapter(myAdapter);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Susan", "Susans", "plane"));
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Surname: " + people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}