package com.andoidstudio.myread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PendidikanAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pendidikan> pendidikans = new ArrayList<>();

    public void setContext(Context context) {
        this.context = context;
    }

    public void setPendidikan(ArrayList<Pendidikan> pendidikans) {
        this.pendidikans = pendidikans;
    }

    public PendidikanAdapter(Context context, ArrayList<Pendidikan> pendidikans) {
        this.context = context;
        this.pendidikans = pendidikans;
    }

    public PendidikanAdapter(Context context) {
        this.context = context;
    }



    @Override
    public int getCount() {
        return pendidikans.size();
    }

    @Override
    public Object getItem(int i) {
        return pendidikans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_pendidikan, viewGroup, false);
        }
        PendidikanAdapter.ViewHolder viewHolder = new PendidikanAdapter.ViewHolder(itemView);
        Pendidikan pendidikan = (Pendidikan) getItem(i);
        viewHolder.bind(pendidikan);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtNamep;
        private TextView txtDescriptionp;
        private ImageView imgPhotop;
        ViewHolder(View view) {
            txtNamep = view.findViewById(R.id.txt_namep);
            txtDescriptionp = view.findViewById(R.id.txt_descriptionp);
            imgPhotop = view.findViewById(R.id.img_photop);
        }
        void bind(Pendidikan pendidikan) {
            txtNamep.setText(pendidikan.getNamep());
            txtDescriptionp.setText(pendidikan.getDescriptionp());
            imgPhotop.setImageResource(pendidikan.getPhotop());
        }

    }

}
