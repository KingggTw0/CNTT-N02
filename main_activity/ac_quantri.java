package com.example.admin.kiemtrab.main_activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.Recycview.main_banhngot;
import com.example.admin.kiemtrab.giaotiep;
import com.example.admin.kiemtrab.menu_viewpager.database_pagers;

public class ac_quantri extends AppCompatActivity implements giaotiep {
    Database_main dbm=new Database_main(this,"hocky.sqlite",null,1);
    String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_quantri);
        dbm.CreateTable("Nguoidung");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_quantri,new database_pagers()).commit();
    }
    @Override
    public void ganID(int id) {
        dbm.DeleteItem("SP",id);

    }

    @Override
    public void suasp(int vt) {
        this.startActivityForResult(new Intent(this,acti_suasp.class).putExtra("getId",vt),1);
        this.onRestart();
    }

    @Override
    public void ganrow(String row) {
        dbm.InsertItem("SP",row);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK && requestCode==1){
            Toast.makeText(this,data.getStringExtra("backrow")+"//"+String.valueOf(data.getIntExtra("backid",0)),Toast.LENGTH_LONG).show();
        }
    }
}
