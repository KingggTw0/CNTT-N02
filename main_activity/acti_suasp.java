package com.example.admin.kiemtrab.main_activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;

public class acti_suasp extends AppCompatActivity {
    EditText edt1,edt2,edt3,edt4,edt5;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acti_suasp);
        Intent i=getIntent();
        final Database_main db_m= new Database_main(this,"hocky.sqlite",null,1);
        mapping();
        final String emp=String.valueOf(i.getIntExtra("getId",0));
        Cursor cr=db_m.getItemsID("SP",emp,"id");
        if (cr.moveToFirst()){
            do {
                edt1.setText(cr.getString(2));
                edt2.setText(cr.getString(1));
                edt3.setText(cr.getString(3));
                edt4.setText(cr.getString(4));
                edt5.setText(String.valueOf(cr.getInt(5)));
            }while (cr.moveToNext());
        }
        cr.close();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j =new Intent();
                String row ="masp = '"+edt2.getText().toString()+"', tensp = '"+edt1.getText().toString()+"', mahang = '"+edt3.getText().toString()+"', loai = '"+edt4.getText().toString()+
                        "', gia = '"+Integer.parseInt(edt5.getText().toString())+"'";
                db_m.UpdateItem("SP",row,Integer.parseInt(emp));
                j.putExtra("backrow","xin chao");
                j.putExtra("backid",Integer.parseInt(emp));
                setResult(RESULT_OK,j);
                finish();
            }
        });
    }
    void mapping(){
        edt1 =(EditText)findViewById(R.id.sua_tensp);
        edt2 =(EditText)findViewById(R.id.sua_masp);
        edt3 =(EditText)findViewById(R.id.sua_tenh);
        edt4 =(EditText)findViewById(R.id.sua_loai);
        edt5 =(EditText)findViewById(R.id.sua_gia);
        btn =(Button)findViewById(R.id.btn_update);
    }
}
