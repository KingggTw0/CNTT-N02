package com.example.admin.kiemtrab.Fragment_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.ReAdapter.main_item_one;
import com.example.admin.kiemtrab.ReAdapter.main_reAdapter_home;
import com.example.admin.kiemtrab.giaotiep;

import java.util.ArrayList;
import java.util.List;

public class main_home1 extends Fragment {
    RecyclerView view_re2;
    giaotiep gt;
    TextView txt;
    List<main_item_one> list_re2 ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lout_home_bot,container,false);
        return view;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt=(TextView)view.findViewById(R.id.text_new);
        view_re2=(RecyclerView)view.findViewById(R.id.re_layout);
        txt.setText("Hot");
        txt.setBackgroundColor(R.color.colorAccent);
        Cursor cr=new Database_main(getContext(),"hocky.sqlite",null,1).getItemsID("SP","hot","loai");
        list_re2=new ArrayList<>();
        if (cr.moveToFirst()){
            do {
                list_re2.add(new main_item_one(cr.getInt(0),String.valueOf(cr.getString(2)),
                        cr.getInt(5)));
            }while (cr.moveToNext());
        }
        cr.close();
        main_reAdapter_home re_dapter=new main_reAdapter_home(list_re2,getContext(),gt);
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        view_re2.setLayoutManager(layoutManager);
        view_re2.setAdapter(re_dapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        gt=(giaotiep)getActivity();
    }
}
