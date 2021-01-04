package com.hkp.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ContactEntryActivity extends AppCompatActivity {

    EditText etName, etPhone, etWeb, etMap;
    ImageView ivFaceGood, ivFaceMeh, ivFaceBad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_entry_activity);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etWeb = findViewById(R.id.etWeb);
        etMap = findViewById(R.id.etMap);
        ivFaceGood = findViewById(R.id.ivFaceGood);
        ivFaceMeh = findViewById(R.id.ivFaceMeh);
        ivFaceBad = findViewById(R.id.ivFaceBad);

        ivFaceGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeResultIntentAndReturn("good");
            }
        });

        ivFaceMeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeResultIntentAndReturn("meh");
            }
        });

        ivFaceBad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeResultIntentAndReturn("bad");
            }
        });
    }

    private void makeResultIntentAndReturn(String face) {
        Intent intent = new Intent();
        intent.putExtra("face", face);
        intent.putExtra("name", etName.getText().toString());
        intent.putExtra("phone", etPhone.getText().toString());
        intent.putExtra("web", etWeb.getText().toString());
        intent.putExtra("map", etMap.getText().toString());

        setResult(RESULT_OK, intent);
        finish();
    }
}