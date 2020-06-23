package com.example.blackout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {

    FragmentBlackout blackoutFrag = new FragmentBlackout();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        Button blackoutButton = rootView.findViewById(R.id.buttonStartBlackout);
        blackoutButton.setOnClickListener(view -> {
//            FragmentBlackout blackoutFrag = new FragmentBlackout();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, blackoutFrag).addToBackStack(null).commit();

        });
        return rootView;
    }
}