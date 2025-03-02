package com.example.hackathon_userapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon_userapp.databinding.MenuItemBinding;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private final List<String> menuItemsName;
    private final List<String> menuItemPrice;
    private final List<Integer> menuImages;

    public MenuAdapter(List<String> menuItemsName, List<String> menuItemPrice, List<Integer> menuImages) {
        this.menuItemsName = menuItemsName;
        this.menuItemPrice = menuItemPrice;
        this.menuImages = menuImages;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MenuItemBinding binding = MenuItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MenuViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return menuItemsName.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        private final TextView menuFoodName;
        private final TextView menuPrice;
        private final ImageView menuImage;

        public MenuViewHolder(MenuItemBinding binding) {
            super(binding.getRoot());
            menuFoodName = binding.menufoodName;
            menuPrice = binding.menuPrice;
            menuImage = binding.menuImage;
        }

        public void bind(int position) {
            menuFoodName.setText(menuItemsName.get(position));
            menuPrice.setText(menuItemPrice.get(position));
            menuImage.setImageResource(menuImages.get(position));
        }
    }
}


