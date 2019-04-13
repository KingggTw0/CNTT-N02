package com.example.admin.kiemtrab.ReAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.kiemtrab.R;

import java.util.List;

public class recycle_ql_user extends RecyclerView.Adapter<recycle_ql_user.Re_viewhode> {
    List<main_item_one> list;
    Context context;

    public recycle_ql_user(List<main_item_one> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public Re_viewhode onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_nd,viewGroup,false);

        return new Re_viewhode(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Re_viewhode re_viewhode, int i) {
        re_viewhode.txt1.setText(list.get(i).getTaikhoan());
        re_viewhode.txt2.setText(list.get(i).getMatkhau());
        re_viewhode.txt3.setText(String.valueOf(list.get(i).getLevel()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Re_viewhode extends RecyclerView.ViewHolder {
        TextView txt1,txt2,txt3;
        public Re_viewhode(@NonNull View itemView) {
            super(itemView);
            mapping(itemView);
        }

    void mapping(View c){
        txt1 =(TextView)c.findViewById(R.id.item_tk);
        txt2 =(TextView)c.findViewById(R.id.item_mk);
        txt3 =(TextView)c.findViewById(R.id.item_level);
    }
    }
}
