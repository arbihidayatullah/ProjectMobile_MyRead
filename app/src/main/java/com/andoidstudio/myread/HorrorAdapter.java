package com.andoidstudio.myread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HorrorAdapter extends BaseAdapter{

        private Context context;
        private ArrayList<Horror> horrors = new ArrayList<>();

        public void setContext(Context context) {
            this.context = context;
        }

        public void setHorror(ArrayList<Horror> horrors) {
            this.horrors = horrors;
        }

        public HorrorAdapter(Context context, ArrayList<Horror> horror) {
            this.context = context;
            this.horrors = horrors;
        }

        public HorrorAdapter(Context context) {
            this.context = context;
        }



        @Override
        public int getCount() {
            return horrors.size();
        }

        @Override
        public Object getItem(int i) {
            return horrors.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View itemView = view;
            if (itemView == null) {
                itemView = LayoutInflater.from(context).inflate(R.layout.item_horror, viewGroup, false);
            }
            com.andoidstudio.myread.HorrorAdapter.ViewHolder viewHolder = new com.andoidstudio.myread.HorrorAdapter.ViewHolder(itemView);
            Horror horror = (Horror) getItem(i);
            viewHolder.bind(horror);
            return itemView;
        }

        private class ViewHolder {
            private TextView txtNameh;
            private TextView txtDescriptionh;
            private ImageView imgPhotoh;
            ViewHolder(View view) {
                txtNameh = view.findViewById(R.id.txt_nameh);
                txtDescriptionh = view.findViewById(R.id.txt_descriptionh);
                imgPhotoh = view.findViewById(R.id.img_photoh);
            }
            void bind(Horror horror) {
                txtNameh.setText(horror.getNameh());
                txtDescriptionh.setText(horror.getDescriptionh());
                imgPhotoh.setImageResource(horror.getPhotoh());
            }

        }


    }
