package com.example.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //переменные
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Связываем наши переменные
        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editTextNumber);
        bControl = (Button)findViewById(R.id.button);

        guess = (int)(Math.random()*100);
        gameFinished = false;
    }

    public void onClick(View v) {

        if(!gameFinished) {

            try
                {
                int inp = Integer.parseInt(etInput.getText().toString());
                if (inp < (int)1 || inp > (int)100)
                    tvInfo.setText("Введенное число не соответствует условиям задачи от 1 до 100");
                else if (inp > guess)
                    tvInfo.setText(getResources().getString(R.string.ahead));
                else if (inp < guess)
                    tvInfo.setText(getResources().getString(R.string.behind));
                else if (inp == guess) {
                    tvInfo.setText(getResources().getString(R.string.hit));
                    bControl.setText(getResources().getString(R.string.play_more));
                    gameFinished = true;
                    }
                }
            catch(Exception ex)
            {
                tvInfo.setText(getResources().getString(R.string.error));
            }
            }
        else
        {
            guess = (int)(Math.random()*100);
            gameFinished = false;
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            bControl.setText(getResources().getString(R.string.input_value));
        }
    }
}