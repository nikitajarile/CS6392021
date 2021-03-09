package com.example.asynctaskproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ImageDownloaderFragment extends Fragment {
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

        view.findViewById(R.id.btn_readImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imageURL = getString(R.string.imageUrl);
                ImageDownloader imageDownloader = new ImageDownloader(getActivity());
                imageDownloader.execute(imageURL);
            }
        });

    }
}