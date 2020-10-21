package com.example.adultsprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChildReg extends AppCompatActivity {
    Button btnRegister;
    TextInputLayout uname, fname, sname, birth, parentsname, favthing;

    FirebaseDatabase rootnode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_reg);

        btnRegister = findViewById(R.id.btnRegister);
        uname = findViewById(R.id.uname);
        fname = findViewById(R.id.fname);
        sname = findViewById(R.id.sname);
        birth = findViewById(R.id.birth);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rootnode = FirebaseDatabase.getInstance();
                        reference = rootnode.getReference("users");

                       if(!ValidateFname() | !ValidateUserName() | !ValidateDateOfBirth() | !ValidateSname()){
                            return;
                        }

                        String username = uname.getEditText().getText().toString();
                        String name = fname.getEditText().getText().toString();
                        String surname = sname.getEditText().getText().toString();
                        String birthday = birth.getEditText().getText().toString();
                       // String password =pass.getEditText().getText().toString();

                        ChildHelperClass helper = new ChildHelperClass(username, name, surname, birthday);

                        reference.child(username).setValue(helper);

                        Intent i = new Intent(ChildReg.this, Login.class);
                        startActivity(i);
                    }
                });

            }
        });
    }



    private Boolean ValidateFname(){
        String strVal = fname.getEditText().getText().toString();

        if(strVal.isEmpty()){
            fname.setError("Field cannot be empty! Please try again");
            return  false;
        }
        else{
            fname.setError(null);
            fname.setEnabled(false);
            return  true;
        }
    }
    private Boolean ValidateSname(){
        String strVal = sname.getEditText().getText().toString();

        if(strVal.isEmpty()){
            sname.setError("Field cannot be empty! Please try again");
            return  false;
        }
        else {
            sname.setError(null);
            sname.setEnabled(false);
            return true;

        }
}

   private Boolean ValidateUserName(){
        String strVal = uname.getEditText().getText().toString();
        String regex = "\\A\\w{4,20}\\z";
        if(strVal.isEmpty()){
            uname.setError("Field cannot be empty! Please try again");
            return  false;
        }
        else  if(strVal.length() >= 20){
            uname.setError("Username is too long");
            return false;

        }else if(!strVal.matches(regex)){
            uname.setError("White spaces are not allowed! Please try again");
            return  false;
        }else {
            uname.setError(null);
            uname.setEnabled(false);
            return  true;
        }
    }

    private Boolean ValidateDateOfBirth(){
        String strVal = birth.getEditText().getText().toString();
        //validating email address
        String strDOBPattern = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";

        if(strVal.isEmpty()){
            birth.setError("Field cannot be empty! Please try again");
            return  false;
        }else if(!strVal.matches(strDOBPattern)){
            birth.setError("Date of birth incorrect");
            return false;
        }
        else{
            birth.setError(null);

            return  true;
        }
    }




}
