package com.andoidstudio.myread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuPendidikan extends AppCompatActivity {

    private PendidikanAdapter adapter;
    private String[] dataNamep;
    private String[] dataDescriptionp;
    private TypedArray dataPhotop;
    private ArrayList<Pendidikan> pendidikans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pendidikan);

        ListView listView = findViewById(R.id.lv_listpendidikan);
        adapter = new PendidikanAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MenuPendidikan.this, pendidikans.get(i).getNamep(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private  void  prepare() {
        dataNamep = getResources().getStringArray(R.array.data_namependidikan);
        dataDescriptionp = getResources().getStringArray(R.array.data_descriptionpendidikan);
        dataPhotop = getResources().obtainTypedArray(R.array.data_photopendidikan);
    }
    private  void addItem() {
        pendidikans = new ArrayList<>();
        for (int i = 0; i < dataNamep.length; i++) {
            Pendidikan pendidikan = new Pendidikan();
            pendidikan.setPhotop(dataPhotop.getResourceId(i, -1));
            pendidikan.setNamep(dataNamep[i]);
            pendidikan.setDescriptionp(dataDescriptionp[i]);
            pendidikans.add(pendidikan);
        }
        adapter.setPendidikan(pendidikans);
    }
}