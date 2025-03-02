package com.example.hackathon_userapp.Fragment;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.hackathon_userapp.MenuBottomSheetFragment;
import com.example.hackathon_userapp.R;
import com.example.hackathon_userapp.adapter.PopularAdapter;
import com.example.hackathon_userapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private FragmentHomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.viewAllMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuBottomSheetFragment bottomSheetDialog = new MenuBottomSheetFragment();
                bottomSheetDialog.show(getParentFragmentManager(), "Test");
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<SlideModel>imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        ImageSlider imageSlider =  binding.imageSlider;
        imageSlider.setImageList(imageList,ScaleTypes.FIT);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void doubleClick(int i) {

            }

            @Override
            public void onItemSelected(int i) {
                SlideModel clickedImage = imageList.get(i);
                String message = "Selected image " + (i + 1);
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
        List<String> foodName = new ArrayList<>(Arrays.asList("Burger","Sandwich","momo","item"));
        List<String> Price = new ArrayList<>(Arrays.asList("51/-","109/-","49/-","69/-"));
        List<Integer> images = new ArrayList<>(Arrays.asList(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu2));
        PopularAdapter adapter = new PopularAdapter(foodName,images,Price);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setItemPrefetchEnabled(false);
        binding.PopularRecyclerView.setLayoutManager(layoutManager);
        binding.PopularRecyclerView.setAdapter(adapter);



    }
}