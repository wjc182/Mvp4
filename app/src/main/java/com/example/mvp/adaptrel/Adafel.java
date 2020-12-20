package com.example.mvp.adaptrel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.mvp.Bean.JavaBean;
import com.example.mvp.R;

import java.util.ArrayList;

public class Adafel extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<JavaBean.ResultsDTO> list;

    public Adafel(Context context, ArrayList<JavaBean.ResultsDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rec_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JavaBean.ResultsDTO dto = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.name.setText(dto.getDesc());
        Glide.with(context).load(dto.getUrl()).into(viewHolder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.rew_image);
            name=itemView.findViewById(R.id.rew_des);
        }
    }
}
