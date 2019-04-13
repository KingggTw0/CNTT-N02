package com.example.admin.kiemtrab.main_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.giaotiep;
import com.example.admin.kiemtrab.menu_viewpager.banhcat_viewpager;
import com.example.admin.kiemtrab.menu_viewpager.banhgato_viewpager;
import com.example.admin.kiemtrab.menu_viewpager.banhmy_viewpager;

public class ac_theloai extends AppCompatActivity implements giaotiep {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_theloai);
        Intent menu = getIntent();
        switch (menu.getIntExtra("menu", 0)) {
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.rela, new banhcat_viewpager()).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.rela, new banhgato_viewpager()).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.rela, new banhmy_viewpager()).commit();
                break;
        }

    }

    @Override
    public void ganID(int vt) {
        Intent id=new Intent(this,ac_chitiet.class);
        id.putExtra("id",vt);
        startActivity(id);
    }

    @Override
    public void suasp(int vt) {

    }

    @Override
    public void ganrow(String row) {

    }
}
