package com.hkp.cricketchirps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etChirps = findViewById(R.id.etChirps);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        TextView tvResult = findViewById(R.id.tvResult);
        
        tvResult.setVisibility(View.GONE);
        
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etChirps.getText().toString().isEmpty()) {
                    int fahr = Integer.parseInt(etChirps.getText().toString()) + 40;
                    String result = getString(R.string.result_1) + fahr + getString(R.string.result_2);
                    tvResult.setText(result);
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}