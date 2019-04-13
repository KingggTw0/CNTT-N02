package com.example.admin.kiemtrab.Recycview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.ReAdapter.main_item_one;
import com.example.admin.kiemtrab.ReAdapter.recycle_ql_user;

import java.util.ArrayList;
import java.util.List;

public class main_ql_user extends Fragment {
    EditText edt1,edt2,edt3;
    Button btn1;
    RecyclerView recyclerView;
    List<main_item_one> list_emp;
    recycle_ql_user recle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.quanly_user,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapping(view);
        Cursor cs=new Database_main(getContext(),"hocky.sqlite",null,1).getItems("Nguoidung");
        list_emp =new ArrayList<>();
        if (cs.moveToFirst()){
            do {
                list_emp.add(new main_item_one(cs.getInt(0),cs.getString(1),cs.getString(2),
                        cs.getInt(3)));
            }while (cs.moveToNext());
        }
        cs.close();
        recle =new recycle_ql_user(list_emp,getContext());
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recle);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database_main(getContext(),"hocky.sqlite",null,1).InsertItem("Nguoidung",
                        null+", '"+edt1.getText().toString()+"', '"+edt2.getText().toString()+"', '"+Integer.parseInt(edt3.getText().toString())+"'");
               // list_emp.add(new main_item_one(0,edt1.getText().toString(),edt2.getText().toString(),
                 //       Integer.parseInt(edt3.getText().toString())));
                recle.notifyDataSetChanged();
            }
        });
    }
    void mapping(View v){
        edt1=(EditText)v.findViewById(R.id.tk_user);
        edt2=(EditText)v.findViewById(R.id.mk_user);
        edt3=(EditText)v.findViewById(R.id.level_user);
        btn1=(Button)v.findViewById(R.id.them_users);
        recyclerView=(RecyclerView)v.findViewById(R.id.rec_users);
    }
}
