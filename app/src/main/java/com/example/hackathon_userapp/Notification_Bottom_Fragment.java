package com.example.hackathon_userapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hackathon_userapp.adapter.NotificationAdapter;
import com.example.hackathon_userapp.databinding.FragmentNotificationBottomBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Notification_Bottom_Fragment extends BottomSheetDialogFragment {
    private FragmentNotificationBottomBinding binding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBottomBinding.inflate(inflater, container, false);
        ArrayList<String>notifications = new ArrayList<>(Arrays.asList("Your order has been Cancelled Successfully", "Order has been taken by the driver", "Congrats Your Order Placed"));
        ArrayList<Integer>notifcationImages = new ArrayList<>(Arrays.asList(R.drawable.sademoji,R.drawable.truck,R.drawable.congrats2));
        NotificationAdapter adapter = new NotificationAdapter(new ArrayList<>(notifications),new ArrayList<>(notifcationImages));
        binding.notificationRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.notificationRecyclerView.setAdapter(adapter);
        return binding.getRoot();
    }
}