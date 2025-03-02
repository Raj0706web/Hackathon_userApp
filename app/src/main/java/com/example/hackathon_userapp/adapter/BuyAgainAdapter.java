package com.example.hackathon_userapp.adapter;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon_userapp.databinding.BuyAgainItemBinding;

import java.util.ArrayList;

public class BuyAgainAdapter extends RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder> {
    private ArrayList<String>buyAgainFoodName;
    private ArrayList<String>buyAgainFoodPrice;
    private ArrayList<Integer>buyAgainFoodImage;
    public BuyAgainAdapter(ArrayList<String>buyAgainFoodName,ArrayList<String>buyAgainFoodPrice,ArrayList<Integer>buyAgainFoodImage){
        this.buyAgainFoodName = buyAgainFoodName;
        this.buyAgainFoodPrice = buyAgainFoodPrice;
        this.buyAgainFoodImage = buyAgainFoodImage;
    }

    @NonNull
    @Override
    public BuyAgainAdapter.BuyAgainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BuyAgainItemBinding binding =  BuyAgainItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new BuyAgainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyAgainAdapter.BuyAgainViewHolder holder, int position) {
        String foodName = buyAgainFoodName.get(position);
        String foodPrice = buyAgainFoodPrice.get(position);
        int foodImage = buyAgainFoodImage.get(position);
        holder.binding.FoodNameHistory.setText(foodName);
        holder.binding.FoodPriceHistory.setText(foodPrice);
        holder.binding.FoodImageHistory.setImageResource(foodImage);
    }

    @Override
    public int getItemCount() {
        return buyAgainFoodName.size();
    }

    public class BuyAgainViewHolder extends RecyclerView.ViewHolder {
        private BuyAgainItemBinding binding;
        public BuyAgainViewHolder(BuyAgainItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
