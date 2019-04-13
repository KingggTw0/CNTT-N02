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

import com.example.admin.kiemtrab.Fragment_view.page_ql_sp;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.Recycview.main_banhngot;
import com.example.admin.kiemtrab.Recycview.main_ql_user;
import com.example.admin.kiemtrab.pager_database_them;

public class database_pagers extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_database,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final String[] title =new String[]{"Sản phẩm","Thêm hàng","QL User"};
        ViewPager vpager=(ViewPager)view.findViewById(R.id.view_pager);
        TabLayout tLayout=(TabLayout)view.findViewById(R.id.tab_layout);
        FragmentPagerAdapter fAdapter=new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                if (i==0){
                    return new page_ql_sp();
                }
                else if(i==1){
                    return new pager_database_them();
                }
                else if (i==2){
                    return new main_ql_user();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
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
