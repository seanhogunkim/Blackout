package com.example.mainactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {

    Activity context;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        Button blackoutButton = (Button) rootView.findViewById(R.id.buttonStartBlackout);
        blackoutButton.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), BlackoutActivity.class);
            startActivity(intent);

        });
        return rootView;
    }
}