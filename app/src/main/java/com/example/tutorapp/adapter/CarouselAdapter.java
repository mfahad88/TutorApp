package com.example.tutorapp.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tutorapp.R;
import com.example.tutorapp.helper.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarouselAdapter extends PagerAdapter {
    LayoutInflater layoutInflater;
    Context context;
    List<Drawable> drawables;

    public CarouselAdapter(Context context, List<Drawable> drawables) {
        this.context = context;
        this.drawables = drawables;
    }

    @Override
    public int getCount() {
        return drawables.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View view = layoutInflater.inflate(R.layout.item_carousel, null);
        ImageView imageView=view.findViewById(R.id.imageView);
        imageView.setImageDrawable(drawables.get(position));

        imageView.getLayoutParams().height= Utils.aspectRatio(view.getContext(), ((BitmapDrawable)drawables.get(0)).getBitmap());
        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
