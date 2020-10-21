package com.example.adultsprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserOption extends AppCompatActivity {
    Button btnParent, btnTeacher, btnChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_option);

        btnChild=findViewById(R.id.btnChild);
        btnParent=findViewById(R.id.btnParent);
        btnTeacher=findViewById(R.id.btnTeacher);

        btnChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserOption.this, Login.class);
                startActivity(intent);
            }
        });

        btnTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserOption.this, TeacherLogin.class);
                startActivity(intent);
            }
        });

        btnParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserOption.this, AdultLogin.class);
                startActivity(intent);
            }
        });
    }
}