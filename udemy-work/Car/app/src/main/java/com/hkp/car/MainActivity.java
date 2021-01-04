package com.hkp.car;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    Button btnCar, btnOwner;
    TextView tvName, tvTel, tvModel;
    ImageView ivBrand;
    CarFrag fragCar;
    OwnerFrag fragOwner;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        tvModel = findViewById(R.id.tvModel);
        ivBrand = findViewById(R.id.ivBrand);

        fragmentManager = this.getSupportFragmentManager();
        fragCar = (CarFrag) fragmentManager.findFragmentById(R.id.fragCar);
        fragOwner = (OwnerFrag) fragmentManager.findFragmentById(R.id.fragOwner);

        fragOwner.getView().setVisibility(View.GONE);

        btnCar = findViewById(R.id.btnCar);
        btnOwner = findViewById(R.id.btnOwner);

        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragCar.getView().setVisibility(View.VISIBLE);
                fragOwner.getView().setVisibility(View.GONE);
            }
        });

        btnOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragOwner.getView().setVisibility(View.VISIBLE);
                fragCar.getView().setVisibility(View.GONE);
            }
        });

        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {
        Person p = ApplicationClass.people.get(index);

        tvName.setText(p.getName());
        tvTel.setText(p.getNumber());
        tvModel.setText(p.getModel());

        switch (p.getBrand())
        {
            case "M":
                ivBrand.setImageResource(R.drawable.mercedes);
                break;
            case "V":
                ivBrand.setImageResource(R.drawable.volkswagen);
                break;
            default:
                ivBrand.setImageResource(R.drawable.nissan);
        }
    }
}