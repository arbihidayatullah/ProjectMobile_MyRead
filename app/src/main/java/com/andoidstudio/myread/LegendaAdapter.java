package com.andoidstudio.myread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LegendaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Legenda> legendas = new ArrayList<>();

    public void setContext(Context context) {
        this.context = context;
    }

    public void setLegendas(ArrayList<Legenda> legendas) {
        this.legendas = legendas;
    }

    public LegendaAdapter(Context context, ArrayList<Legenda> legendas) {
        this.context = context;
        this.legendas = legendas;
    }

    public LegendaAdapter(Context context) {
        this.context = context;
    }



    @Override
    public int getCount() {
        return legendas.size();
    }

    @Override
    public Object getItem(int i) {
        return legendas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_legenda, viewGroup, false);
        }
        LegendaAdapter.ViewHolder viewHolder = new LegendaAdapter.ViewHolder(itemView);
        Legenda legenda = (Legenda) getItem(i);
        viewHolder.bind(legenda);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtNamel;
        private TextView txtDescriptionl;
        private ImageView imgPhotol;
        ViewHolder(View view) {
            txtNamel = view.findViewById(R.id.txt_namel);
            txtDescriptionl = view.findViewById(R.id.txt_descriptionl);
            imgPhotol = view.findViewById(R.id.img_photol);
        }
        void bind(Legenda legenda) {
            txtNamel.setText(legenda.getNamel());
            txtDescriptionl.setText(legenda.getDescriptionl());
            imgPhotol.setImageResource(legenda.getPhotol());
        }

    }
}
