package com.example.rishi.myapp.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Rishi on 10/18/2016.
 */
public class Utils {
    public static void toast(Context getContext,String msg){
        Toast toast=Toast.makeText(getContext,msg,Toast.LENGTH_SHORT);
       toast.show();
    }
}
