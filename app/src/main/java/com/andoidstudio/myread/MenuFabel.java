package com.andoidstudio.myread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuFabel extends AppCompatActivity {
    private FabelAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<Fabel> fabels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_fabel);

        ListView listView = findViewById(R.id.lv_listfabel);
        adapter = new FabelAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MenuFabel.this, fabels.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  void  prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private  void addItem() {
        fabels = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Fabel fabel = new Fabel();
            fabel.setPhoto(dataPhoto.getResourceId(i, -1));
            fabel.setName(dataName[i]);
            fabel.setDescription(dataDescription[i]);
            fabels.add(fabel);
        }
        adapter.setHeroes(fabels);
    }

}