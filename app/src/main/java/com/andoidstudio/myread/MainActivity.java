package com.andoidstudio.myread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMasukMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMasukMenu = (Button)findViewById(R.id.btn_masuk_menu);
        btnMasukMenu.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_masuk_menu:
                Intent moveMenu = new Intent(MainActivity.this, MenuUtama.class);
                startActivity(moveMenu);
            break;
        }
    }

}