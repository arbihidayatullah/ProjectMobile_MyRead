package com.andoidstudio.myread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RomanceAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Romance> romances = new ArrayList<>();

    public void setContext(Context context) {
        this.context = context;
    }

    public void setRomance(ArrayList<Romance> romances) {
        this.romances = romances;
    }

    public RomanceAdapter(Context context, ArrayList<Romance> romance) {
        this.context = context;
        this.romances = romances;
    }

    public RomanceAdapter(Context context) {
        this.context = context;
    }



    @Override
    public int getCount() {
        return romances.size();
    }

    @Override
    public Object getItem(int i) {
        return romances.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_romance, viewGroup, false);
        }
        RomanceAdapter.ViewHolder viewHolder = new RomanceAdapter.ViewHolder(itemView);
        Romance romance = (Romance) getItem(i);
        viewHolder.bind(romance);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtNamer;
        private TextView txtDescriptionr;
        private ImageView imgPhotor;
        ViewHolder(View view) {
            txtNamer = view.findViewById(R.id.txt_namer);
            txtDescriptionr = view.findViewById(R.id.txt_descriptionr);
            imgPhotor = view.findViewById(R.id.img_photor);
        }
        void bind(Romance romance) {
            txtNamer.setText(romance.getNamer());
            txtDescriptionr.setText(romance.getDescriptionr());
            imgPhotor.setImageResource(romance.getPhotor());
        }

    }

}
