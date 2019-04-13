package com.example.admin.kiemtrab.Recycview;

import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.ReAdapter.main_reAdapter;
import com.example.admin.kiemtrab.ReAdapter.main_item_one;
import com.example.admin.kiemtrab.giaotiep;
import com.example.admin.kiemtrab.main_activity.ac_quantri;

import java.util.ArrayList;
import java.util.List;

public class main_banhngot extends Fragment {
    List<main_item_one> emp;
    public main_reAdapter mAdapter;
    giaotiep gt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_pager_banhngot,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView reView=(RecyclerView) view.findViewById(R.id.re_menu_acti);
        //database
        Database_main dbm=new Database_main(getContext(),"hocky.sqlite",null,1);
        Cursor cr =dbm.getItems("SP");
        emp=new ArrayList<>();
                if(cr.moveToFirst()){
                    do {
                        emp.add(new main_item_one(cr.getInt(0),cr.getString(2),cr.getString(4),
                                cr.getString(1),cr.getString(3), cr.getInt(5)));
                        mAdapter=new main_reAdapter(emp,getContext(),gt);
                    }while (cr.moveToNext());
                }
                cr.close();
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reView.setLayoutManager(layoutManager);
        reView.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        gt=(giaotiep)getActivity();
    }
}
