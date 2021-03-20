package com.example.midtermnikitajarilev3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private EditText etCurrencyInEuros;
    private Button btnConvert;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View fragmentView = inflater.inflate(R.layout.fragment_first, container, false);
        etCurrencyInEuros = (EditText) fragmentView.findViewById(R.id.etCurrencyInEuros);
        btnConvert = fragmentView.findViewById(R.id.btn_convert);


        btnConvert.setOnClickListener(new View.OnClickListener() {
            Double currencyInEuros;
            Double currencyInDollars;
            Double converter = 1.13;
            SecondFragment secondFragment = new SecondFragment();
            FragmentManager fragmentManager;
            Bundle bundle = new Bundle();
            @Override
            public void onClick(View view) {
                currencyInEuros = Double.parseDouble(etCurrencyInEuros.getText().toString());

                if(currencyInEuros != null){
                    currencyInDollars = currencyInEuros * converter;
                }
                Log.i("MAINACTIVITY",currencyInDollars.toString());

                Intent intent = new Intent(getContext(),ResultActivity.class);
                intent.putExtra("result",currencyInDollars);
                startActivity(intent);
                
            }
        });

        return fragmentView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}