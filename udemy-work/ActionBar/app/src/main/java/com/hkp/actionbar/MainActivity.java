package com.hkp.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.mipmap.chrome_foreground);
        ab.setTitle(" Welcome");
        ab.setDisplayShowTitleEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String type = "";
        switch (item.getItemId()) {
            case R.id.download:
                type = "Download";
                break;
            case R.id.refresh:
                type = "Refresh";
                break;
            case R.id.sync:
                type = "Sync";
                break;
        }

        Toast.makeText(MainActivity.this, type + " Clicked", Toast.LENGTH_SHORT).show();
        if (type.equals("Download"))
        {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        }
        return super.onOptionsItemSelected(item);

    }
}