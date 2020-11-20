package com.andoidstudio.myread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdventureAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Adventure> adventures = new ArrayList<>();

    public void setContext(Context context) {
        this.context = context;
    }

    public void setAdventure(ArrayList<Adventure> adventures) {
        this.adventures = adventures;
    }

    public AdventureAdapter(Context context, ArrayList<Adventure> adventure) {
        this.context = context;
        this.adventures = adventures;
    }

    public AdventureAdapter(Context context) {
        this.context = context;
    }



    @Override
    public int getCount() {
        return adventures.size();
    }

    @Override
    public Object getItem(int i) {
        return adventures.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_adventure, viewGroup, false);
        }
        com.andoidstudio.myread.AdventureAdapter.ViewHolder viewHolder = new com.andoidstudio.myread.AdventureAdapter.ViewHolder(itemView);
        Adventure adventure = (Adventure) getItem(i);
        viewHolder.bind(adventure);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtNamea;
        private TextView txtDescriptiona;
        private ImageView imgPhotoa;
        ViewHolder(View view) {
            txtNamea = view.findViewById(R.id.txt_namea);
            txtDescriptiona = view.findViewById(R.id.txt_descriptiona);
            imgPhotoa = view.findViewById(R.id.img_photoa);
        }
        void bind(Adventure adventure) {
            txtNamea.setText(adventure.getNamea());
            txtDescriptiona.setText(adventure.getDescriptiona());
            imgPhotoa.setImageResource(adventure.getPhotoa());
        }

    }
}
