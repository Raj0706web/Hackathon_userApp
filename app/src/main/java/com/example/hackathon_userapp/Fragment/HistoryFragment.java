package com.example.hackathon_userapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hackathon_userapp.R;
import com.example.hackathon_userapp.adapter.BuyAgainAdapter;
import com.example.hackathon_userapp.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class HistoryFragment extends Fragment {
    private FragmentHistoryBinding binding;
    private BuyAgainAdapter buyAgainAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(getLayoutInflater(),container,false);
        setupRecyclerView();
        return binding.getRoot();
    }
    private void setupRecyclerView(){
        ArrayList<String>buyAgainFoodName = new ArrayList<>(Arrays.asList("Food 1","Food 2","Food 3"));
        ArrayList<String>buyAgainFoodPrice = new ArrayList<>(Arrays.asList("51/-","109/-","71/-"));
        ArrayList<Integer>buyAgainFoodImage = new ArrayList<>(Arrays.asList(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3));
        buyAgainAdapter = new BuyAgainAdapter(new ArrayList<>(buyAgainFoodName),new ArrayList<>(buyAgainFoodPrice),new ArrayList<>(buyAgainFoodImage));
        binding.historyRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.historyRecyclerView.setAdapter(buyAgainAdapter);
    }
}