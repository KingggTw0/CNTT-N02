package com.example.admin.kiemtrab.main_activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.kiemtrab.R;

public class kiemtrab extends AppCompatActivity {
    EditText edt1,edt2;
    Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiemtrab);
        mapping();
      go.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if (edt1.getText().toString()=="admin"){
                  startActivity(new Intent(kiemtrab.this,ac_quantri.class));
              }
              else {
                  startActivity(new Intent(kiemtrab.this,testacti.class));
              }
          }
      });
    }
    void mapping(){
        edt1 =(EditText)findViewById(R.id.post_tk);
        edt2 =(EditText)findViewById(R.id.post_mk);
        go= (Button)findViewById(R.id.gui);
    }
}
