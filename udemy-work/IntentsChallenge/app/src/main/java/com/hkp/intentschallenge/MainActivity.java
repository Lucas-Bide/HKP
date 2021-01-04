package com.hkp.intentschallenge;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ivFace, ivPhone, ivWeb, ivMap;
    Button btnCreateContact;

    String phone, web, map;
    final int BUTTON_RESULT = 921;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateContact = findViewById(R.id.btnCreateContact);
        ivFace = findViewById(R.id.ivFace);
        ivPhone = findViewById(R.id.ivPhone);
        ivWeb = findViewById(R.id.ivWeb);
        ivMap = findViewById(R.id.ivMap);

        ivFace.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivMap.setVisibility(View.GONE);

        btnCreateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, com.hkp.intentschallenge.ContactEntryActivity.class), BUTTON_RESULT);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phone != null && !phone.isEmpty()) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone)));
                }
                else {
                    Toast.makeText(MainActivity.this, "No phone number provided", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (web != null && !web.isEmpty()) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + web)));
                }
                else {
                    Toast.makeText(MainActivity.this, "No website provided", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null && !map.isEmpty()) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + map)));
                }
                else {
                    Toast.makeText(MainActivity.this, "No address provided", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == BUTTON_RESULT && resultCode == RESULT_OK) {
            phone = data.getStringExtra("phone");
            web = data.getStringExtra("web");
            map = data.getStringExtra("map");

            switch (data.getStringExtra("face"))
            {
                case "good":
                    ivFace.setImageResource(R.drawable.good);
                    break;
                case "meh":
                    ivFace.setImageResource(R.drawable.meh);
                    break;
                default:
                    ivFace.setImageResource(R.drawable.bad);
            }

            ivFace.setVisibility(View.VISIBLE);
            ivPhone.setVisibility(View.VISIBLE);
            ivWeb.setVisibility(View.VISIBLE);
            ivMap.setVisibility(View.VISIBLE);
        }
    }
}