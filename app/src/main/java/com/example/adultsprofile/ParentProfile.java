package com.example.adultsprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ParentProfile extends AppCompatActivity {
    Button btnEdit, btnDash;
    TextInputLayout username, fname, sname, email, pass;

    String u_name, f_name, s_name, u_email, u_pass;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_profile);

        databaseReference= FirebaseDatabase.getInstance().getReference("parent_users");

        btnDash=findViewById(R.id.btnDash);
        btnEdit=findViewById(R.id.btnEdit);
        username=findViewById(R.id.username);
        fname=findViewById(R.id.fname);
        sname=findViewById(R.id.sname);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);

        PassingUserData();

        btnDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParentProfile.this, Dashboard.class);
                startActivity(intent);
            }
        });


    }
    private void PassingUserData()
    {
        Intent intent = getIntent();
        u_name=intent.getStringExtra("uname");
        f_name=intent.getStringExtra("name");
        s_name=intent.getStringExtra("surname");
        u_email = intent.getStringExtra("uemail");
        u_pass = intent.getStringExtra("password");

        username.getEditText().setText(u_name);
        fname.getEditText().setText(f_name);
        sname.getEditText().setText(s_name);
        email.getEditText().setText(u_email);
        pass.getEditText().setText(u_pass);
    }
    public void UpdateData(View v){
        if(isNameUpdated() || isPasswordUpdated()){
            Toast.makeText(this, "Update Succesful", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(this, "Update unsuccesful. Data cannot be the same", Toast.LENGTH_LONG).show();
        }
    }
    private boolean isPasswordUpdated() {

        if(!u_pass.equals(pass.getEditText().getText().toString())){
            databaseReference.child(u_name).child("password").setValue(pass.getEditText().getText().toString());
            u_pass = pass.getEditText().getText().toString();
            return true;
        }
        else
        {
            return false;
        }

    }

    private boolean isNameUpdated() {
        if(!f_name.equals(fname.getEditText().getText().toString())){
            databaseReference.child(u_name).child("name").setValue(fname.getEditText().getText().toString());
            f_name = fname.getEditText().getText().toString();
            return true;
        }
        else
        {
            return false;
        }
    }


}