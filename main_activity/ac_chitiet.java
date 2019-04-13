package com.example.admin.kiemtrab.main_activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.Fragment_view.page_chitietsanpham;
import com.example.admin.kiemtrab.R;

public class ac_chitiet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_chitiet);
        Intent i=getIntent();
        int emp=i.getIntExtra("id",0);
        Cursor cr=new Database_main(this,"hocky.sqlite",null,1).getItemsID("SP",String.valueOf(emp),"id");
        if (cr.moveToFirst()) {
            do {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_bottom,new page_chitietsanpham().getGt(cr.getInt(0),cr.getString(4))).commit();
            } while (cr.moveToNext());
        }
        cr.close();
    }
}
