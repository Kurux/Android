package com.PierLuc.GuessTheNumberCour1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int MAX = 10;
    private GuessNumber guessNumber;

    private EditText inputNumber;
    private Button buttonTry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.editText_Guessed_Number);
        buttonTry = findViewById(R.id.button_try_number);

        guessNumber = new GuessNumber(MAX);
        setListenner();
    }

    private void setListenner() {
        buttonTry.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                guess();
            }
        });
    }

    private void guess() {
        int numberGuessed = Integer.parseInt(inputNumber.getText().toString());
        GuessNumber.guessState result = guessNumber.testNumber(numberGuessed);
        if(result == GuessNumber.guessState.BIGGER) {
            showHint("Votre nombre est plus grand");
        }
        if(result == GuessNumber.guessState.SMALLER) {
            showHint("Votre nombre est plus petit");
        }
        if(result == GuessNumber.guessState.EQUAL) {
            showHint("Bravo");
            guessNumber.generateNewNumber();
        }

    }

    private void showHint(String hint) {
        Toast.makeText(this, hint, Toast.LENGTH_SHORT).show();
    }
}
