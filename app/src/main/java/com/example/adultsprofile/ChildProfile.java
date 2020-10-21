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

public class ChildProfile extends AppCompatActivity {

    Button btnEdit, btnDash;
    TextInputLayout txtFName, txtSName, txtDOB,txtpName, txtFavThing;

    String u_name, f_name, s_name, u_dob, u_favthing, u_parent;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_profile);
        txtFName = findViewById(R.id.txtFName);
        txtSName = findViewById(R.id.txtSName);
        txtDOB = findViewById(R.id.txtDOB);
        txtpName = findViewById(R.id.txtpName);
        txtFavThing = findViewById(R.id.txtFavThing);
        btnDash = findViewById(R.id.btnDash);
        btnEdit = findViewById(R.id.btnEdit);
        PassingUserData();

        btnDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChildProfile.this, Dashboard.class);
                startActivity(i);
            }
        });
    }
    private void PassingUserData()
    {
        Intent intent = getIntent();

        f_name=intent.getStringExtra("name");
        s_name=intent.getStringExtra("surname");
        u_dob = intent.getStringExtra("birthday");


        txtFName.getEditText().setText(f_name);
        txtSName.getEditText().setText(s_name);
        txtDOB.getEditText().setText(u_dob);
        txtpName.getEditText().setText(u_parent);
        txtFavThing.getEditText().setText(u_favthing);

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

        if(!u_dob.equals(txtDOB.getEditText().getText().toString())){
            reference.child(u_name).child("password").setValue(txtDOB.getEditText().getText().toString());
            u_dob = txtDOB.getEditText().getText().toString();
            return true;
        }
        else
        {
            return false;
        }

    }

    private boolean isNameUpdated() {
        if(!f_name.equals(txtFName.getEditText().getText().toString())){
            reference.child(u_name).child("name").setValue(txtFName.getEditText().getText().toString());
            f_name = txtFName.getEditText().getText().toString();
            return true;
        }
        else
        {
            return false;
        }
    }



}