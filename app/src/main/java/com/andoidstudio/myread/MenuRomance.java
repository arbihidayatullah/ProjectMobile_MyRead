package com.andoidstudio.myread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuRomance extends AppCompatActivity {

    private RomanceAdapter adapter;
    private String[] dataNamer;
    private String[] dataDescriptionr;
    private TypedArray dataPhotor;
    private ArrayList<Romance> romances;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_romance);

        ListView listView = findViewById(R.id.lv_listromance);
        adapter = new RomanceAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MenuRomance.this, romances.get(i).getNamer(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private  void  prepare() {
        dataNamer = getResources().getStringArray(R.array.data_nameromance);
        dataDescriptionr = getResources().getStringArray(R.array.data_descriptionromance);
        dataPhotor = getResources().obtainTypedArray(R.array.data_photoromance);
    }
    private  void addItem() {
        romances = new ArrayList<>();
        for (int i = 0; i < dataNamer.length; i++) {
            Romance romance = new Romance();
            romance.setPhotor(dataPhotor.getResourceId(i, -1));
            romance.setNamer(dataNamer[i]);
            romance.setDescriptionr(dataDescriptionr[i]);
            romances.add(romance);
        }
        adapter.setRomance(romances);
    }

}