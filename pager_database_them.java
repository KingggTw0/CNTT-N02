package com.example.admin.kiemtrab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.kiemtrab.Fragment_view.page_ql_sp;
import com.example.admin.kiemtrab.Recycview.main_banhngot;
import com.example.admin.kiemtrab.main_activity.ac_quantri;

public class pager_database_them extends Fragment {
    EditText edt1,edt2,edt3,edt4,edt5,edt6;
    Button btn;
    giaotiep gt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.lout_them_table,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapping(view);
         btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String row=""+null+", '"+edt1.getText().toString()+"', '"+edt2.getText().toString()+"', '" +
                      edt3.getText().toString()+"', '"+edt4.getText().toString()+"', '"+Integer.parseInt(edt5.getText().toString())+"', '"+
                        edt6.getText().toString()+"'";
                Toast.makeText(getContext(),"them thanh cong",Toast.LENGTH_LONG).show();
                setEditText();
                gt.ganrow(row);
            }
        });
    }
    private void mapping(View v){
        edt1=(EditText)v.findViewById(R.id.edt_masp);
        edt2=(EditText)v.findViewById(R.id.edt_tensp);
        edt3=(EditText)v.findViewById(R.id.edt_tenhang);
        edt4=(EditText)v.findViewById(R.id.edt_type);
        edt5=(EditText)v.findViewById(R.id.edt_gia);
        edt6=(EditText)v.findViewById(R.id.edt_img);
        btn=(Button) v.findViewById(R.id.btn_them);
    }
    private void setEditText(){
        edt1.setText(null);
        edt2.setText(null);
        edt3.setText(null);
        edt4.setText(null);
        edt5.setText(null);
        edt6.setText(null);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        gt=(giaotiep)getActivity();
    }
}
