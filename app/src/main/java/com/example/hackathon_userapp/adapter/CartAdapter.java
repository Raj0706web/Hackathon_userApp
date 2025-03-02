package com.example.hackathon_userapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hackathon_userapp.databinding.CartItemBinding;

import java.util.Arrays;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private final List<String> cartItems;
    private final List<String> cartItemPrice;
    private final List<Integer> cartImage;
    private final int[] itemQuantities;

    public CartAdapter(List<String> cartItems, List<String> cartItemPrice, List<Integer> cartImage) {
        this.cartItems = cartItems;
        this.cartItemPrice = cartItemPrice;
        this.cartImage = cartImage;
        this.itemQuantities = new int[cartItems.size()];
        // Initialize all quantities to 1
        Arrays.fill(itemQuantities, 1);
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemBinding binding = CartItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CartViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        private final CartItemBinding binding;

        public CartViewHolder(CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int position) {
            binding.apply; {

                // Get the quantity
                int quantity = itemQuantities.get(position);

                // Set values to the UI components
                cartFoodName.setText(CartItems.get(position));
                cartItemPrice.setText(CartItemPrice.get(position));
                cartImage.setImageResource(CartImage.get(position));
                catItemQuantity.setText(String.valueOf(quantity));

                // Handle button clicks
                minusbutton.setOnClickListener(v -> decreaseQuantity(position));
                plusebutton.setOnClickListener(v -> increaseQuantity(position));
                deleteButton.setOnClickListener(v -> {
                    int itemPosition = getAdapterPosition();
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(itemPosition);
                    }
                });
            }
        }

        private void increaseQuantity(int position) {
            if (itemQuantities.get(position) < 10) {
                itemQuantities.set(position, itemQuantities.get(position) + 1);
                binding.catItemQuantity.setText(String.valueOf(itemQuantities.get(position)));
            }
        }

        private void decreaseQuantity(int position) {
            if (itemQuantities.get(position) > 1) {
                itemQuantities.set(position, itemQuantities.get(position) - 1);
                binding.catItemQuantity.setText(String.valueOf(itemQuantities.get(position)));
            }
        }

        private void deleteItem(int position) {
            CartItems.remove(position);
            CartImage.remove(position);
            CartItemPrice.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, CartItems.size());
        }
    }
}