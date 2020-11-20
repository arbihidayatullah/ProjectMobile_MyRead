package com.andoidstudio.myread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuLegenda extends AppCompatActivity {

    private LegendaAdapter adapter;
    private String[] dataNamelegendal;
    private String[] dataDescriptionlegendal;
    private TypedArray dataPhotolegendal;
    private ArrayList<Legenda> legendas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_legenda);

        ListView listView = findViewById(R.id.lv_listlegenda);
        adapter = new LegendaAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MenuLegenda.this, legendas.get(i).getNamel(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private  void  prepare() {
        dataNamelegendal = getResources().getStringArray(R.array.data_namelegenda);
        dataDescriptionlegendal = getResources().getStringArray(R.array.data_descriptionlegenda);
        dataPhotolegendal = getResources().obtainTypedArray(R.array.data_photolegenda);
    }
    private  void addItem() {
        legendas = new ArrayList<>();
        for (int i = 0; i < dataNamelegendal.length; i++) {
            Legenda legenda = new Legenda();
            legenda.setPhotol(dataPhotolegendal.getResourceId(i, -1));
            legenda.setNamel(dataNamelegendal[i]);
            legenda.setDescriptionl(dataDescriptionlegendal[i]);
            legendas.add(legenda);
        }
        adapter.setLegendas(legendas);
    }
}