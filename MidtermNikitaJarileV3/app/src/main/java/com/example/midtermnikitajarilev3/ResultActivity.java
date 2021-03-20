package com.example.midtermnikitajarilev3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView txt_currencyInDollars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txt_currencyInDollars = findViewById(R.id.txt_currencyInDollars);
        Double result = getIntent().getDoubleExtra("result", 0.0);
        Log.i("MAINACTIVITY",result.toString());
        txt_currencyInDollars.setText(String.format("%s%s", getString(R.string.strCurrencyInDollars), result));
    }
}