package com.example.hackathon_userapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.hackathon_userapp.databinding.FragmentCartBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        com.example.hackathon_userapp.databinding.FragmentCartBinding binding = FragmentCartBinding.inflate(inflater, container, false);

        List<String> cartFoodName = Arrays.asList("Burger", "sandwich", "cono", "iten", "sandwich", "womo");
        List<String> cartItemPrice = Arrays.asList("$5", "$6", "$8", "$9", "$10", "$10");
        List<Integer> cartImage = Arrays.asList(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu3,
                R.drawable.menu4,
                R.drawable.menu5,
                R.drawable.menu6
        );

        CartAdapter adapter = new CartAdapter(new ArrayList<>(cartFoodName), new ArrayList<>(cartItemPrice), new ArrayList<>(cartImage));
        binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.cartRecyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    public static class Companion {
        // Empty companion object converted to static inner class
    }

    private static final Companion companion = new Companion();
}