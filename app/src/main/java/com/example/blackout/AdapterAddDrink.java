package com.example.blackout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterAddDrink extends RecyclerView.Adapter<AdapterAddDrink.AddDrinkViewHolder> {
    private ArrayList<Drink> _drinkList;

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

    //Gets the drink from the specified position of the array
    @Override
    public void onBindViewHolder(@NonNull AddDrinkViewHolder holder, int position) {
        Drink currentDrink = _drinkList.get(position);
        holder._imageView.setImageResource(currentDrink.get_imageResource());
        holder._name.setText(currentDrink.get_name());
        holder._alcPercent.setText(Integer.toString(currentDrink.get_alcPercent()));
        holder._alcVolume.setText(Integer.toString(currentDrink.get_alcVolume()));

    }

    @Override
    public int getItemCount() {
        return _drinkList.size();
    }

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