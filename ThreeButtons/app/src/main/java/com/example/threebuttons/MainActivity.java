package com.example.threebuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = (TextView) findViewById(R.id.showCount);
    }

    public void countUp(View view) {
        count++;
        if(showCount != null){
            showCount.setText(Integer.toString(count));
        }
    }

    public void showZero(View view) {
        count = 0;
        showCount.setText(R.string.text_zero);
    }

    public void countDown(View view) {
        count--;
        if(showCount != null){
            showCount.setText(Integer.toString(count));
        }
    }
}