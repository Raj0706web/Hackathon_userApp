package com.example.hackathon_userapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hackathon_userapp.adapter.MenuAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.example.hackathon_userapp.databinding.FragmentMenuBottomSheetBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuBottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentMenuBottomSheetBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false);

        List<String> menuFoodName = Arrays.asList("Burger", "sandwich", "momo", "dosa", "sandwich", "momo");
        List<String> menuItemPtice = Arrays.asList("50/-", "100/-", "50/-", "60", "70/-", "120/-");
        List<Integer> menuImage = Arrays.asList(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu3,
                R.drawable.menu4,
                R.drawable.menu5,
                R.drawable.menu6
        );

        MenuAdapter adapter = new MenuAdapter(
                new ArrayList<>(menuFoodName),
                new ArrayList<>(menuItemPtice),
                new ArrayList<>(menuImage)
        );

        binding.menuRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.menuRecyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
}