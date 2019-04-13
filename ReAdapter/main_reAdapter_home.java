package com.example.admin.kiemtrab.ReAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.giaotiep;

import java.util.List;

public class main_reAdapter_home extends RecyclerView.Adapter<main_reAdapter_home.Re_viewhodel> {
    List<main_item_one> list;
    Context context;
    giaotiep gt;

    public main_reAdapter_home(List<main_item_one> list, Context context, giaotiep gt) {
        this.list = list;
        this.context = context;
        this.gt = gt;
    }

    public main_reAdapter_home(List<main_item_one> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public main_reAdapter_home(){

    }

    @NonNull
    @Override
    public Re_viewhodel onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
         View item= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_one_layout_home,viewGroup,false);

        return new Re_viewhodel(item);
    }

    @Override
    public void onBindViewHolder(@NonNull Re_viewhodel re_viewhodel, int i) {
        re_viewhodel.txt.setText(list.get(i).getText());
        re_viewhodel.txt_gia.setText(String.valueOf(list.get(i).getGia())+" vnd");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class Re_viewhodel extends RecyclerView.ViewHolder {
        TextView txt,txt_gia;
        Button tbn;
        public Re_viewhodel(@NonNull final View itemView) {
            super(itemView);
            Database_main re_db=new Database_main(itemView.getContext(),"hocky.db",null ,1);
            txt=(TextView)itemView.findViewById(R.id.txt_tsp);
            txt_gia=(TextView)itemView.findViewById(R.id.txt_gsp) ;
            tbn=(Button)itemView.findViewById(R.id.btn_show);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            tbn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),String.valueOf(list.get(getAdapterPosition()).getText())
                            +String.valueOf(list.get(getAdapterPosition()).getId()),Toast.LENGTH_SHORT).show();
                    gt.ganID(list.get(getAdapterPosition()).id);
                }
            });
        }

    }

}
