package com.example.adultsprofile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AdultLogin extends AppCompatActivity {
    Button btnReg, btnLogin, btnRegChild;
    TextInputLayout username, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adult_login);

        btnReg=findViewById(R.id.btnReg);
        btnLogin=findViewById(R.id.btnLogin);
        username = findViewById(R.id.username);
        pass=findViewById(R.id.pass);
        btnRegChild = findViewById(R.id.btnRegChild);

        btnRegChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdultLogin.this, ChildReg.class);
                startActivity(i);
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdultLogin.this, ParentReg.class);
                startActivity(intent);
            }
        });
       // loginUser(v);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(!ValidateUserName() | !ValidatePass()){
                        return;
                    }else{
                        user();
                    }

            }
        });

    }
    private Boolean ValidateUserName(){
        String strVal = username.getEditText().getText().toString();
        //String regex = "\\A\\w{4,20}\\z";
        if(strVal.isEmpty()){
            username.setError("Field cannot be empty! Please try again");
            return  false;
        } else {
            username.setError(null);
            username.setEnabled(false);
            return  true;
        }
    }
    private Boolean ValidatePass(){
        String strVal = pass.getEditText().getText().toString();
        //String strPass = "^(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        //^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$
        if(strVal.isEmpty()){
            pass.setError("Field cannot be empty! Please try again");
            return  false;
        }
        else{
            pass.setError(null);
            pass.setErrorEnabled(false);
            return  true;
        }
    }
    public void loginUser(View v){
        if(!ValidateUserName() | !ValidatePass()){
            return;
        }else{
            user();
        }
    }
    public void user(){
        final String userName = username.getEditText().getText().toString().trim();
        final String upassword = pass.getEditText().getText().toString().trim();

        //db Reference
        //DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserValid = FirebaseDatabase.getInstance().getReference("parent_users").orderByChild("uname").equalTo(userName);
        //Query checkUserValid = reference.orderByChild("StrUserName").equalTo(userName);

        checkUserValid.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    username.setError(null);
                    username.setErrorEnabled(false);

                    String dbPass = dataSnapshot.child(userName).child("password").getValue(String.class);

                    if(dbPass.equals(upassword)){
                        username.setError(null);
                        username.setErrorEnabled(false);

                        String dbUname = dataSnapshot.child(userName).child("uname").getValue(String.class);
                        String dbName = dataSnapshot.child(userName).child("name").getValue(String.class);
                        String dbSurname = dataSnapshot.child(userName).child("surname").getValue(String.class);
                        String dbEmail = dataSnapshot.child(userName).child("uemail").getValue(String.class);
                        String dbPassword= dataSnapshot.child(userName).child("password").getValue(String.class);

                        //Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                        Intent i = new Intent(getApplicationContext(), ParentProfile.class);

                       i.putExtra("strName", dbName);
                        i.putExtra("uname", dbUname);
                       i.putExtra("uemail", dbEmail);
                       i.putExtra("surname", dbSurname);
                        i.putExtra("password", dbPass);

                        startActivity(i);
                    }
                    else{
                        pass.setError("Incorrect Password");
                        pass.requestFocus();
                    }
                }
                else {
                    username.setError("Username does not exist in our database");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(AdultLogin.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}