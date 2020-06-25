package com.example.blackout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Fragment for add drink function
 * <p>
 * Author: Sean Hogun Kim
 */
public class FragmentAddDrink extends Fragment {

    private RecyclerView _recyclerView;
    private RecyclerView.Adapter _adapter;
    private RecyclerView.LayoutManager _layoutManager;
    private ArrayList<Drink> drinksList = new ArrayList<>();

    private Button buttonAddDrink;

    private EditText drinkName;
    private EditText alcPercent;
    private EditText alcVol;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_drink, container, false);

        createDrinkList();
        buildRecyclerView(rootView);

        //Initialise buttons and editTexts
        buttonAddDrink = rootView.findViewById(R.id.buttonAddDrink);
        drinkName = rootView.findViewById(R.id.etDrinkName);
        alcPercent = rootView.findViewById(R.id.etAlcPercent);
        alcVol = rootView.findViewById(R.id.etAlcVolume);

        //Setting up listeners
        buttonAddDrink.setOnClickListener(view -> {
            String drinkNameString = drinkName.getText().toString();
            int alcPercentInt = Integer.parseInt(alcPercent.getText().toString());
            int alcVolInt = Integer.parseInt(alcVol.getText().toString());
            insertItem(drinkNameString, alcPercentInt, alcVolInt);

        });


        return rootView;
    }

    public void insertItem(String name, int alcPercent, int alcVol) {
        drinksList.add(0, new Drink(name, alcPercent, alcVol));
        System.out.println("adding item to list");
        _adapter.notifyItemInserted(0);

    }

    public void removeItem() {

    }

    public void createDrinkList() {
        drinksList = new ArrayList<>();
    }

    public void buildRecyclerView(View rootView) {
        _recyclerView = rootView.findViewById(R.id.recyclerViewAddDrink);
        _recyclerView.setHasFixedSize(true);
        _layoutManager = new LinearLayoutManager(getActivity());
        _adapter = new AdapterAddDrink(drinksList);

        _recyclerView.setLayoutManager(_layoutManager);
        _recyclerView.setAdapter(_adapter);
    }

}