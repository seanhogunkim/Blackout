package com.example.blackout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Adapter class for RecyclerView.Adapter made for purpose of the recycler view used in FragmentAddDrink
 */

public class AdapterAddDrink extends RecyclerView.Adapter<AdapterAddDrink.AddDrinkViewHolder> {
    private ArrayList<Drink> _drinkList;

    //Constructor
    public AdapterAddDrink(ArrayList<Drink> drinkList) {
        _drinkList = drinkList;

    }

    @NonNull
    @Override
    public AddDrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_drink, parent, false);
        AddDrinkViewHolder drinkViewHolder = new AddDrinkViewHolder(v);
        return drinkViewHolder;
    }

    //Gets the drink from the specified position of the array and sets the text of the recycler view to the parameters specified
    @Override
    public void onBindViewHolder(@NonNull AddDrinkViewHolder holder, int position) {
        Drink currentDrink = _drinkList.get(position);
        holder._imageView.setImageResource(currentDrink.get_imageResource());
        holder._name.setText(currentDrink.get_name());
        holder._alcPercent.setText(currentDrink.get_alcPercent());
        holder._alcVolume.setText(currentDrink.get_alcVolume());

    }

    //Finds the size of the array ie. number of unique drinks
    @Override
    public int getItemCount() {
        return _drinkList.size();
    }

    // https://stackoverflow.com/questions/31302341/what-difference-between-static-and-non-static-viewholder-in-recyclerview-adapter#:~:text=By%20using%20static%20it%20just,rather%20than%20a%20nested%20class.

    public static class AddDrinkViewHolder extends RecyclerView.ViewHolder {
        public ImageView _imageView;
        public TextView _name;
        public TextView _alcPercent;
        public TextView _alcVolume;

        public AddDrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            _imageView = itemView.findViewById(R.id.drinkImageView);
            _name = itemView.findViewById(R.id.drinkName);
            _alcPercent = itemView.findViewById(R.id.alcPercent);
            _alcVolume = itemView.findViewById(R.id.alcVolume);
        }
    }


}