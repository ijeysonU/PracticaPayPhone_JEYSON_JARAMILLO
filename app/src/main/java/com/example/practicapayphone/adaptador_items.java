package com.example.practicapayphone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class adaptador_items extends RecyclerView.Adapter<items_holdviewer>
        implements View.OnClickListener{

    private Context Ctx;
    private List<c_Items> lstItems;
    private View.OnClickListener Listener;
    public adaptador_items(Context c, ArrayList<c_Items> litms){
        this.Ctx = c;
        this.lstItems = litms;
    }
    @NonNull
    @Override
    public items_holdviewer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_tienda, null);
        view.setOnClickListener(this);
        return new items_holdviewer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull items_holdviewer holder, int position) {
        c_Items itm = lstItems.get(position);
        holder.itm.setText(itm.getItem());
        holder.prc.setText("Precio: $ "+itm.getPrecio().toString()+"0");

        try {
            Glide.with(Ctx)
                    .load(itm.getImgURL())
                    .error(R.drawable.unknown)
                    .into(holder.img)

            ;//(Drawable("https://evaladmin.uteq.edu.ec/adminimg/unknown.png"));
        }catch(Exception ex){

        }
    }

    @Override
    public int getItemCount() {
        final int size = lstItems.size();
        return size;
    }
    public void setOnClickListener(View.OnClickListener listener)
    {
        this.Listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (Listener != null){
            Listener.onClick(v);
        }
    }
}
