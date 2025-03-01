package com.example.hackathon_userapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon_userapp.databinding.PopularItemBinding;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    private final List<String> Items;
    private final List<Integer> images;
    private final List<String> prices;
    public PopularAdapter(List<String> items, List<Integer>images,List<String>prices) {
        this.Items = items;
        this.images = images;
        this.prices = prices;
    }

    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        String item = Items.get(position);
        int image = images.get(position);
        String price = prices.get(position);
        holder.binding.foodNamePopular.setText(item);
        holder.binding.imageView5.setImageResource(image);
        holder.binding.PricePopular.setText(price);
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final PopularItemBinding binding;

        public ViewHolder(PopularItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(String item,Integer image,String price){
            binding.foodNamePopular.setText(item);
            binding.imageView5.setImageResource(image);
            binding.PricePopular.setText(price);
        }
    }
}
