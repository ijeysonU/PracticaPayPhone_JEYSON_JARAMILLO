package com.example.practicapayphone;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class items_holdviewer extends RecyclerView.ViewHolder {
    TextView itm, prc;
    ImageView img;
    public items_holdviewer(View v){
        super(v);
        itm = v.findViewById(R.id.txtnombreitem);
        prc = v.findViewById(R.id.txtprecioitem);
        img = v.findViewById(R.id.imgItem);
    }
}
