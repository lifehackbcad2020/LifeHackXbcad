package com.example.adultsprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ParentReg extends AppCompatActivity {
    Button btnRegister;
    TextInputLayout username, fname, sname, email, pass;

    FirebaseDatabase rootnode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_reg);

        btnRegister=findViewById(R.id.btnRegister);
        username = findViewById(R.id.username);
        fname = findViewById(R.id.fname);
        sname = findViewById(R.id.sname);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("parent_users");

                if(!ValidateFname() | !ValidateUserName() | !ValidateEmail() | !ValidateSname() | !ValidatePass()){
                    return;
                }

                String uname = username.getEditText().getText().toString();
                String name = fname.getEditText().getText().toString();
                String surname = sname.getEditText().getText().toString();
                String uemail = email.getEditText().getText().toString();
                String password =pass.getEditText().getText().toString();

                UserHelper helper = new UserHelper(uname, name, surname, uemail, password);

                reference.child(uname).setValue(helper);
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
        else{
            sname.setError(null);
            sname.setEnabled(false);
            return  true;
        }
    }
    private Boolean ValidateUserName(){
        String strVal = username.getEditText().getText().toString();
        String regex = "\\A\\w{4,20}\\z";
        if(strVal.isEmpty()){
            username.setError("Field cannot be empty! Please try again");
            return  false;
        }
        else  if(strVal.length() >= 20){
            username.setError("Username is too long");
            return false;

        }else if(!strVal.matches(regex)){
            username.setError("White spaces are not allowed! Please try again");
            return  false;
        }else {
            username.setError(null);
            username.setEnabled(false);
            return  true;
        }
    }

    private Boolean ValidateEmail(){
        String strVal = email.getEditText().getText().toString();
        //validating email address
        String strEmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(strVal.isEmpty()){
            email.setError("Field cannot be empty! Please try again");
            return  false;
        }else if(!strVal.matches(strEmailPattern)){
            email.setError("Email address incorrect");
            return false;
        }
        else{
            email.setError(null);

            return  true;
        }
    }

    private Boolean ValidatePass(){
        String strVal = pass.getEditText().getText().toString();
        String strPass = "^(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        //^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$
        if(strVal.isEmpty()){
            pass.setError("Field cannot be empty! Please try again");
            return  false;
        }else if(!strVal.matches(strPass)){

            pass.setError("Password is too weak! Please try again");
            return  false;
        }
        else{
            pass.setError(null);
            return  true;
        }
}}