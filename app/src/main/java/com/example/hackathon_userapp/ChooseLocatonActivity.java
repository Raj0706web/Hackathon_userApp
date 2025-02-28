package com.example.hackathon_userapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hackathon_userapp.databinding.ActivityChooseLocatonBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class ChooseLocatonActivity extends AppCompatActivity {
    private ActivityChooseLocatonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding = ActivityChooseLocatonBinding.inflate(getLayoutInflater());
        ArrayList<String> locationList = new ArrayList<>(Arrays.asList("Patna", "Kolkata", "Odisha", "Meerut"));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locationList);
        AutoCompleteTextView autoCompleteTextView = binding.listOflocation;
        autoCompleteTextView.setAdapter(adapter);
    }
}