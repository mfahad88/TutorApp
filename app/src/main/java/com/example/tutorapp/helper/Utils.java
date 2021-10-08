package com.example.tutorapp.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;

public class Utils {

    public static int aspectRatio(Context context, Bitmap bitmap){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float ratio=new Float(height)/new Float(width);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int pxWidth = displayMetrics.widthPixels;
        int pxHeight = (int) (pxWidth*ratio);
        return pxHeight;
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
