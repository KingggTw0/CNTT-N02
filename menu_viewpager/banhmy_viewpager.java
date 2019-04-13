package com.example.admin.kiemtrab.menu_viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.Recycview.main_recycv_home;

public class banhmy_viewpager extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_banhmy,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final String[] title =new String[]{"Banh Kep","Banh Ngot"};
        ViewPager vpager=(ViewPager)view.findViewById(R.id.view_pager);
        TabLayout tLayout=(TabLayout)view.findViewById(R.id.tab_layout);
        FragmentPagerAdapter fAdapter=new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                if (i==0){
                    return  main_recycv_home.getType("kep");
                }
                else if(i==1){
                    return main_recycv_home.getType("ngot");
                }
                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        };
        tLayout.setupWithViewPager(vpager);
        vpager.setAdapter(fAdapter);
    }
}
