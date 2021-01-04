package com.hkp.asynctasks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText etRolls;
    Button btnRolls;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRolls = findViewById(R.id.etRolls);
        btnRolls = findViewById(R.id.btnRoll);
        tvResults = findViewById(R.id.tvResults);

        btnRolls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rolls = Integer.parseInt(etRolls.getText().toString().trim());
                new ProcessDiceInBackground().execute(rolls);
            }
        });
    }

    public class ProcessDiceInBackground extends AsyncTask<Integer, Integer, String> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(MainActivity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(Integer.parseInt(etRolls.getText().toString().trim()));
            dialog.show();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int[] occurrences = {0, 0, 0, 0, 0, 0};
            Random rand = new Random();

            double currentProgress = 0,  previousProgress = 0;


            for(int i = 0; i < integers[0]; i++) {
                occurrences[rand.nextInt(6)]++;
                currentProgress = (double ) i / integers[0];

                if (currentProgress - previousProgress >= 0.03 ) {
                    publishProgress(i);
                    previousProgress = currentProgress;
                }
            }

            return "Results:\n" +
                    "1. " + occurrences[0] + "\n" +
                    "2. " + occurrences[1] + "\n" +
                    "3. " + occurrences[2] + "\n" +
                    "4. " + occurrences[3] + "\n" +
                    "5. " + occurrences[4] + "\n" +
                    "6. " + occurrences[5] + "\n";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            dialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.dismiss();
            tvResults.setText(s);

        }
    }
}
