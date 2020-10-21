package com.example.adultsprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class AdditionAndSubtraction extends AppCompatActivity {
    TextView txtNum1, txtNum2, txtAnswer, txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_and_subtraction);

        txtNum1=findViewById(R.id.txtNum1);
        txtNum2=findViewById(R.id.txtNum2);
        txtAnswer=findViewById(R.id.txtAnswer);
        txtResult=findViewById(R.id.txtResult);

        run_reset();
    }
    void run_reset()
    {
        Random rand = new Random();

        int num1 = rand.nextInt(101);
        int num2 =rand.nextInt(101);

        txtNum1.setText(""+num1);
        txtNum2.setText(""+num2);

        txtAnswer.setText("");
        txtResult.setText("");
    }

    void printAns(String a)
    {
        String text=txtAnswer.getText().toString();
        txtAnswer.setText(text+a);
    }
    public void one(View view) {
        printAns("1");
    }

    public void two(View view) {
        printAns("2");
    }

    public void three(View view) {
        printAns("3");
    }

    public void four(View view) {
        printAns("4");
    }

    public void five(View view) {
        printAns("5");
    }

    public void six(View view) {
        printAns("6");
    }

    public void seven(View view) {
        printAns("7");
    }

    public void eight(View view) {
        printAns("8");
    }

    public void nine(View view) {
        printAns("9");
    }

    public void zero(View view) {
        printAns("0");
    }

    public void clear(View view) {
        run_reset();
    }

    public void submit(View view) {
        int num1=Integer.parseInt(txtNum1.getText().toString());
        int num2=Integer.parseInt(txtNum2.getText().toString());
        int ans = num1+num2;

        int get_user_asnwer = Integer.parseInt(txtAnswer.getText().toString());

        if (ans==get_user_asnwer)
        {
            txtResult.setText("CORRECT!");
        }
        else
        {
            txtResult.setText("INCORRECT!");
        }
    }
}