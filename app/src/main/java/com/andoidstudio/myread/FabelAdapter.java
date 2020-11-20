package com.andoidstudio.myread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class FabelAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Fabel> fabels = new ArrayList<>();

    public void setContext(Context context) {
        this.context = context;
    }

    public void setHeroes(ArrayList<Fabel> fabels) {
        this.fabels = fabels;
    }

    public FabelAdapter(Context context, ArrayList<Fabel> fabels) {
        this.context = context;
        this.fabels = fabels;
    }

    public FabelAdapter(Context context) {
        this.context = context;
    }



    @Override
    public int getCount() {
        return fabels.size();
    }

    @Override
    public Object getItem(int i) {
        return fabels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_fabel, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Fabel fabel = (Fabel) getItem(i);
        viewHolder.bind(fabel);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Fabel fabel) {
            txtName.setText(fabel.getName());
            txtDescription.setText(fabel.getDescription());
            imgPhoto.setImageResource(fabel.getPhoto());
        }

    }
}
