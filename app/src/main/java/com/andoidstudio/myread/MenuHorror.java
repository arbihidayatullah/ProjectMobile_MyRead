package com.andoidstudio.myread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuHorror extends AppCompatActivity {

    private HorrorAdapter adapter;
    private String[] dataNameh;
    private String[] dataDescriptionh;
    private TypedArray dataPhotoh;
    private ArrayList<Horror> horrors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_horror);

        ListView listView = findViewById(R.id.lv_listhorror);
        adapter = new HorrorAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MenuHorror.this, horrors.get(i).getNameh(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private  void  prepare() {
        dataNameh = getResources().getStringArray(R.array.data_namehorror);
        dataDescriptionh = getResources().getStringArray(R.array.data_descriptionhorror);
        dataPhotoh = getResources().obtainTypedArray(R.array.data_photohorror);
    }
    private  void addItem() {
        horrors = new ArrayList<>();
        for (int i = 0; i < dataNameh.length; i++) {
            Horror horror = new Horror();
            horror.setPhotoh(dataPhotoh.getResourceId(i, -1));
            horror.setNameh(dataNameh[i]);
            horror.setDescriptionh(dataDescriptionh[i]);
            horrors.add(horror);
        }
        adapter.setHorror(horrors);
    }
}