package com.hkp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "SA ID";

    EditText etID;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String idNumber = etID.getText().toString().trim();
                String dob = idNumber.substring(0, 6);
                String gender;
                int genderFlag = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String citizenship;
                int citizenshipFlag = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                if (genderFlag < 5) {
                    gender = getString(R.string.female);
                }
                else {
                    gender = getString(R.string.male);
                }

                if (citizenshipFlag == 0) {
                    citizenship = getString(R.string.sa_citizen);
                }
                else {
                    citizenship = getString(R.string.permanent_resident);
                }

                String text = getString(R.string.dob_id) + dob + getString(R.string.id_gender) + gender + getString(R.string.citizenship_id) + citizenship;

                tvResult.setText(text);
                tvResult.setVisibility(View.VISIBLE);
            }
        });

        Log.d(TAG, "In onCreate");
    }


}