package com.example.admin.kiemtrab.Fragment_view;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;

public class page_chitietsanpham extends Fragment {
    public static page_chitietsanpham getGt(int id, String s){
        Bundle bundle=new Bundle();
        bundle.putString("loai",s);
        bundle.putInt("id",id);
        page_chitietsanpham p_sp=new page_chitietsanpham();
        p_sp.setArguments(bundle);
        return p_sp;
    }
    TextView txt,txt2,txt_bot;
    Button btn;
    Cursor cr_ct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.layout_chitietsp,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapping(view);
        Bundle bd=getArguments();
        cr_ct=new Database_main(getContext(),"hocky.sqlite",null,1).getItemsID("SP",String.valueOf(bd.getInt("id")),"id");
        if (cr_ct.moveToFirst()){
            do {
                txt.setText(cr_ct.getString(2));
                txt2.setText(String.valueOf(cr_ct.getInt(5)));
            }while (cr_ct.moveToNext());
        }
        cr_ct.close();
        cr_ct=new Database_main(getContext(),"hocky.sqlite",null,1).getItemsID("SP",String.valueOf(bd.getString("loai")),"loai");

        if (cr_ct.moveToFirst()){
            do {
                txt_bot.setText(cr_ct.getString(4));
            }while (cr_ct.moveToNext());
        }
        cr_ct.close();

    }

    private void mapping(View x) {
         txt=(TextView)x.findViewById(R.id.ct_ten_txt);
         txt2=(TextView)x.findViewById(R.id.xt_gia_txt);
         txt_bot=(TextView)x.findViewById(R.id.chitiet_txt);
         btn=(Button)x.findViewById(R.id.btn_dathang);
    }
}
