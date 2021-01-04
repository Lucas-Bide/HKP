package com.hkp.lifecycleevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Life Cycle Event";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "In onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "In onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "In onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "In onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "In onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "In onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "In onDestroy");
    }
}