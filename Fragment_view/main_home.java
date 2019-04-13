package com.example.admin.kiemtrab.Fragment_view;

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

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.ReAdapter.main_item_one;
import com.example.admin.kiemtrab.ReAdapter.main_reAdapter;
import com.example.admin.kiemtrab.ReAdapter.main_reAdapter_home;

import java.util.ArrayList;
import java.util.List;

public class main_home extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_home,container,false);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_phobien,new main_home2()).commit();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_hot,new main_home1()).commit();
        return view;
    }
}
