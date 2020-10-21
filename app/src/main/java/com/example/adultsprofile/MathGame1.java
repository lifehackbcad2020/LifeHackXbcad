package com.example.adultsprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MathGame1 extends AppCompatActivity {
    Button btnAddition, btnAddandSubtract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game1);

        btnAddition=findViewById(R.id.btnAddition);
        btnAddandSubtract = findViewById(R.id.btnAddandSubtract);
        btnAddandSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MathGame1.this, AdditionAndSubtraction.class);
                startActivity(i);
            }
        });

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MathGame1.this, AdditionAndSubtraction.class);
                startActivity(i);
            }
        });
    }
}