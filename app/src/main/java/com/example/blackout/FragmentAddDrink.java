package com.example.blackout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Fragment for add drink function
 * Add drink page allows you to add a drink with parameters name, alcohol percentage and volume
 * <p>
 * Author: Sean Hogun Kim
 */
public class FragmentAddDrink extends Fragment {

    //Setting up the recycler view for added drink entries
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
            String alcPercentString = alcPercent.getText().toString();
            String alcVolString = alcVol.getText().toString();
            if (TextUtils.isEmpty(drinkNameString) || TextUtils.isEmpty(alcPercentString) || TextUtils.isEmpty(alcVolString)) {
                Toast.makeText(getActivity(), "please fill in all the blanks", Toast.LENGTH_SHORT).show();
            } else if (Integer.parseInt(alcPercentString) >= 100) {
                Toast.makeText(getActivity(), "wow where did u find more than 100% alcohol?", Toast.LENGTH_SHORT).show();
            } else {
                insertItem(drinkNameString, alcPercentString, alcVolString);
            }


        });


        return rootView;
    }

    //Whenever we create a new drink we add it to the top of the list
    public void insertItem(String name, String alcPercent, String alcVol) {
        drinksList.add(0, new Drink(name, alcPercent, alcVol));
        System.out.println("adding item to list");
        _adapter.notifyItemInserted(0);

    }

    public void removeItem() {

    }

    //Initialisation of the list of drinks
    public void createDrinkList() {
        drinksList = new ArrayList<>();
    }

    //Create the recycler view and adapter
    public void buildRecyclerView(View rootView) {
        _recyclerView = rootView.findViewById(R.id.recyclerViewAddDrink);
        _recyclerView.setHasFixedSize(true);
        _layoutManager = new LinearLayoutManager(getActivity());
        _adapter = new AdapterAddDrink(drinksList);

        _recyclerView.setLayoutManager(_layoutManager);
        _recyclerView.setAdapter(_adapter);
    }

}