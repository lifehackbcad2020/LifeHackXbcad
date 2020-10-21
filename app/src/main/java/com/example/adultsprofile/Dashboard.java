package com.example.adultsprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity{
    Button btnProf, btnMath, btnScience, btnArt, btnEng, btnLifeSkills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnProf=findViewById(R.id.btnProf);
        btnArt=findViewById(R.id.btnArt);
        btnEng=findViewById(R.id.btnEng);
        btnMath=findViewById(R.id.btnMath);
        btnScience=findViewById(R.id.btnScience);
        btnLifeSkills=findViewById(R.id.btnLifeSkills);

        btnLifeSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, MathGame1.class);
                startActivity(intent);
            }
        });
        btnProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, ChildProfile.class);
                startActivity(intent);
            }
        });
    }


}