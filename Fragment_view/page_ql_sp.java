package com.example.admin.kiemtrab.Fragment_view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.Recycview.main_banhngot;

public class page_ql_sp extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.from(getContext()).inflate(R.layout.layout_ql_sp,container,false);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_ql_sp,new main_banhngot()).commit();
        return v;
    }
}
