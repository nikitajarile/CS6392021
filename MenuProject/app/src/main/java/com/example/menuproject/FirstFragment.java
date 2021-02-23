package com.example.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_sms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment","Button SMS Clicked");
                Intent intentSMS = new Intent(Intent.ACTION_SENDTO);
                intentSMS.setData(Uri.parse("smsto:"+Uri.encode(getString(R.string.btn_phone_no))));
                intentSMS.putExtra("sms_body",getString(R.string.txt_name));
                startActivity(intentSMS);
            }
        });

        view.findViewById(R.id.btn_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment","Button Phone Clicked");
                Intent intentPhone = new Intent(Intent.ACTION_DIAL);
                intentPhone.setData(Uri.parse("tel:" + getString(R.string.btn_phone_no)));
                startActivity(intentPhone);
            }
        });

        view.findViewById(R.id.btn_web).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment","Button Web Clicked");
                String url = getString(R.string.txt_webpage);
                Uri page = Uri.parse(url);
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, page);
                startActivity(intentWeb);
            }
        });

        view.findViewById(R.id.btn_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment","Button Map Clicked");
                Intent intentMap = new Intent(Intent.ACTION_VIEW);
                Uri geoLocation = Uri.parse(getString(R.string.txt_geoLocation));
                intentMap.setData(geoLocation);
                startActivity(intentMap);
            }
        });

        view.findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment","Button Share Clicked");
                String txt = getString(R.string.shareText);
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder
                        .from(getActivity())
                        .setType(mimeType)
                        .setChooserTitle(getString(R.string.shareText))
                        .setText(txt)
                        .startChooser();
            }
        });

        view.findViewById(R.id.btn_NewActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("NewActivity","New Activity Clicked");
                Intent intentNewAct = new Intent(getActivity(),NewActivity.class);
                startActivity(intentNewAct);
            }
        });
    }
}