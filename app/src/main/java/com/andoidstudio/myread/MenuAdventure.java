package com.andoidstudio.myread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuAdventure extends AppCompatActivity {

    private AdventureAdapter adapter;
    private String[] dataNamea;
    private String[] dataDescriptiona;
    private TypedArray dataPhotoa;
    private ArrayList<Adventure> adventures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adventure);

        ListView listView = findViewById(R.id.lv_listadventure);
        adapter = new AdventureAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MenuAdventure.this, adventures.get(i).getNamea(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private  void  prepare() {
        dataNamea = getResources().getStringArray(R.array.data_nameadventure);
        dataDescriptiona = getResources().getStringArray(R.array.data_descriptionadventure);
        dataPhotoa = getResources().obtainTypedArray(R.array.data_photoadventure);
    }
    private  void addItem() {
        adventures = new ArrayList<>();
        for (int i = 0; i < dataNamea.length; i++) {
            Adventure adventure = new Adventure();
            adventure.setPhotoa(dataPhotoa.getResourceId(i, -1));
            adventure.setNamea(dataNamea[i]);
            adventure.setDescriptiona(dataDescriptiona[i]);
            adventures.add(adventure);
        }
        adapter.setAdventure(adventures);
    }

}