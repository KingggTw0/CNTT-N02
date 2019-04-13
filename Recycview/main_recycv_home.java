package com.example.admin.kiemtrab.Recycview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.ReAdapter.main_reAdapter_home;
import com.example.admin.kiemtrab.ReAdapter.main_item_one;
import com.example.admin.kiemtrab.giaotiep;

import java.util.ArrayList;
import java.util.List;

public class main_recycv_home extends Fragment {
   public static main_recycv_home getType(String color){
       Bundle bd_color=new Bundle();
       bd_color.putString("color",color);
       main_recycv_home frag=new main_recycv_home();
       frag.setArguments(bd_color);
       return frag;
   }
   LinearLayout ln;
   giaotiep gt;
   private static String tyle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_pager_banhngot,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ln=(LinearLayout)view.findViewById(R.id.setbackground);
        RecyclerView reView=(RecyclerView) view.findViewById(R.id.re_menu_acti);
        List<main_item_one> emp;
        main_reAdapter_home mAdapter;
        Bundle bd=getArguments();
        tyle=bd.getString("color");
        setBackground(tyle);
        //database
        Cursor cr_v=new Database_main(getContext(),"hocky.sqlite",null,1).getItemsID("SP",tyle,"mahang");
        emp=new ArrayList<>();
        if (cr_v.moveToFirst()){
            do {
                emp.add(new main_item_one(cr_v.getInt(0),cr_v.getString(2),cr_v.getInt(5)));
            }while (cr_v.moveToNext());
        }
        cr_v.close();
        mAdapter=new main_reAdapter_home(emp,getContext(),gt);
        mAdapter.notifyDataSetChanged();
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        reView.setLayoutManager(layoutManager);
        reView.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        gt=(giaotiep)getActivity();
    }
    @SuppressLint("ResourceAsColor")
    void setBackground(String BG){
        switch (BG){
            case "cookie":
                ln.setBackgroundColor(R.color.design_default_color_primary);
        }
    }
}
