package com.example.admin.kiemtrab.ReAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.giaotiep;
import com.example.admin.kiemtrab.main_activity.acti_suasp;

import java.util.List;

public class main_reAdapter extends RecyclerView.Adapter<main_reAdapter.Re_viewhodel> {
    List<main_item_one> list;
    Context context;
    giaotiep gt;

    public main_reAdapter(List<main_item_one> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public main_reAdapter(){

    }

    public main_reAdapter(List<main_item_one> list, Context context, giaotiep gt) {
        this.list = list;
        this.context = context;
        this.gt = gt;
    }

    @NonNull
    @Override
    public Re_viewhodel onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
         View item= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_one_layout,viewGroup,false);

        return new Re_viewhodel(item);
    }

    @Override
    public void onBindViewHolder(@NonNull Re_viewhodel re_viewhodel, int i) {
        re_viewhodel.txt_masp.setText(list.get(i).getMasp());
        re_viewhodel.tensp.setText(list.get(i).getText());
        re_viewhodel.mahang.setText(list.get(i).getMahang());
        re_viewhodel.tl.setText(list.get(i).getLoaisp());
        re_viewhodel.gia.setText(String.valueOf(list.get(i).getGia()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class Re_viewhodel extends RecyclerView.ViewHolder{
        TextView txt_masp,tensp,mahang,tl,gia;
        ImageButton Ib_xoa,IB_sua;

        public Re_viewhodel(@NonNull final View itemView) {
            super(itemView);
            maping(itemView);
            Ib_xoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gt.ganID(list.get(getAdapterPosition()).id);
                    list.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
            IB_sua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gt.suasp(list.get(getAdapterPosition()).id);
                    //itemView.getContext().startActivity(new Intent(itemView.getContext(),acti_suasp.class));
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(itemView.getContext(),String.valueOf(list.get(getAdapterPosition()).getText()),Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }

        public void maping(View v){
            txt_masp=(TextView)v.findViewById(R.id.ql_masp);
            tensp=(TextView)v.findViewById(R.id.ql_tensp);
            mahang=(TextView)v.findViewById(R.id.ql_mahang);
            tl=(TextView)v.findViewById(R.id.ql_loai);
            gia=(TextView)v.findViewById(R.id.ql_gia);
            Ib_xoa=(ImageButton)v.findViewById(R.id.ql_del);
            IB_sua=(ImageButton)v.findViewById(R.id.ql_sua);
        }
    }

}
