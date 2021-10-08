package com.example.tutorapp.fragment;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tutorapp.R;
import com.example.tutorapp.adapter.CarouselAdapter;
import com.example.tutorapp.helper.Utils;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    ViewPager viewPager;
    RecyclerView recyclerView;
    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_home, container, false);
        viewPager=root.findViewById(R.id.viewPager);
        viewPager.setAdapter(new CarouselAdapter(root.getContext(),getDrawables()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position,true);

                viewPager.getLayoutParams().height= Utils.aspectRatio(root.getContext(), ((BitmapDrawable)getDrawables().get(0)).getBitmap());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        recyclerView=root.findViewById(R.id.recyclerView);
        return root;
    }


    public List<Drawable> getDrawables(){
        List<Drawable> drawables=new ArrayList<>();
        drawables.add(getResources().getDrawable(R.drawable.luis));
        drawables.add(getResources().getDrawable(R.drawable.sally));
        drawables.add(getResources().getDrawable(R.drawable.scott));
        drawables.add(getResources().getDrawable(R.drawable.sally));
        drawables.add(getResources().getDrawable(R.drawable.scott));
        drawables.add(getResources().getDrawable(R.drawable.luis));
        drawables.add(getResources().getDrawable(R.drawable.scott));
        drawables.add(getResources().getDrawable(R.drawable.luis));
        drawables.add(getResources().getDrawable(R.drawable.sally));
        return drawables;
    }
}