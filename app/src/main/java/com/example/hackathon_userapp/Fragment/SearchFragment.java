package com.example.hackathon_userapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hackathon_userapp.adapter.MenuAdapter;
import com.example.hackathon_userapp.databinding.FragmentSearchBinding;
import com.google.android.material.search.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFragment extends Fragment {
    private FragmentSearchBinding binding;
    private MenuAdapter adapter;
    private final List<String> originalMenuFoodName = Arrays.asList(
            "Burger",
            "sandwich",
            "momo",
            "item",
            "sandwich",
            "momo",
            "sandwich",
            "momo",
            "item",
            "sandwich",
            "momo"
    );

    private final List<String> originalMenuItemPrice = Arrays.asList(
            "$5", "$6", "$8", "$9", "$8", "$9", "$10", "$10"
    );

    private final List<Integer> originalMenuImage = Arrays.asList(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6
    );

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    @Override
    private List<String> filteredMenuFoodName = new ArrayList<>();
    private List<String> filteredMenuItemPrice = new ArrayList<>();
    private List<Integer> filteredMenuImage = new ArrayList<>();
    private MenuAdapter adapter;
    private FragmentSearchBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false);

        adapter = new MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage);

        binding.menuRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.menuRecyclerView.setAdapter(adapter);

        // Setup for search view
        setupSearchView();

        return binding.getRoot();
    }

    private void showAllMenu() {
        filteredMenuFoodName.clear();
        filteredMenuItemPrice.clear();
        filteredMenuImage.clear();

        filteredMenuFoodName.addAll(originalMenuFoodName);
        filteredMenuItemPrice.addAll(originalMenuItemPrice);
        filteredMenuImage.addAll(originalMenuImage);

        adapter.notifyDataSetChanged();
    }


    private void setupSearchView() {
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterMenuItems(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMenuItems(newText);
                return true;
            }
        });
    }



    private void filterMenuItems(String query) {
        filteredMenuFoodName.clear();
        filteredMenuItemPrice.clear();
        filteredMenuImage.clear();

        for (int i = 0; i < originalMenuFoodName.size(); i++) {
            String foodName = originalMenuFoodName.get(i);
            if (foodName.toLowerCase().contains(query.toLowerCase())) { // Ignore case
                filteredMenuFoodName.add(foodName);
                filteredMenuItemPrice.add(originalMenuItemPrice.get(i));
                filteredMenuImage.add(originalMenuImage.get(i));
            }
        }
        adapter.notifyDataSetChanged();
    }



}
