package com.pierluc.exercicecour1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private  CompareNumber compareNumber;

        private EditText input1;
        private EditText input2;
        private Button buttonCompare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.editText_Number);
        input2 = findViewById(R.id.editText_Number2);
        buttonCompare= findViewById(R.id.button_compare);
        compareNumber = new CompareNumber();
        setListenner();
    }

    private void setListenner() {
        buttonCompare.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                guess();
            }
        });
    }
    private void guess() {
        input1.setBackgroundColor(Color.argb(1,0,0,0));
        input2.setBackgroundColor(Color.argb(1,0,0,0));
        int number1 = Integer.parseInt(!input1.getText().toString().isEmpty()? input1.getText().toString():"0");
        int number2 = Integer.parseInt(!input2.getText().toString().isEmpty()?input2.getText().toString():"0");
        CompareNumber.comparaisonState result = compareNumber.testNumbers(number1,number2);
        if(result ==  CompareNumber.comparaisonState.ONEBIGGER) {
            showHint("Le nombre 1 est plus grand");
            input1.setBackgroundColor(Color.argb(255,1,254,1));
        }
        if(result ==  CompareNumber.comparaisonState.TWOBIGGER) {
            showHint("Le nombre 2 est plus grand");
            input2.setBackgroundColor(Color.argb(255,1,254,1));
        }
        if(result == CompareNumber.comparaisonState.EQUAL) {
            showHint("Les nombres sont égaux");
        }

    }
    private void showHint(String hint) {
        Toast.makeText(this, hint, Toast.LENGTH_SHORT).show();
    }
}
