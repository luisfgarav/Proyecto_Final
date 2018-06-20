package com.example.ppc.proyecto_final.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ppc.proyecto_final.DetalleActivity;
import com.example.ppc.proyecto_final.model.Producto;
import com.example.ppc.proyecto_final.R;

import java.util.List;

/**
 * Created by ppc on 19/06/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Producto> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Producto> mData) {
        this.mContext = mContext;
        this.mData = mData;

        option=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view=inflater.inflate(R.layout.producto_row_item,parent,false);
        final MyViewHolder viewHolder=new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(mContext, DetalleActivity.class);
                i.putExtra("Producto_clave",mData.get(viewHolder.getAdapterPosition()).getClave());

                mContext.startActivity(i);

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_nombre.setText(mData.get(position).getNombre());
        holder.tv_categoria.setText(mData.get(position).getCategoria());
        holder.tv_disponibilidad.setText(mData.get(position).getDisponibilidad());
        holder.tv_clave.setText(mData.get(position).getClave());
        Glide.with(mContext).load(mData.get(position).getImagen()).apply(option).into(holder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_nombre;
        TextView tv_categoria;
        TextView tv_disponibilidad;
        TextView tv_clave;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);

            view_container=itemView.findViewById(R.id.container);
            tv_nombre=itemView.findViewById(R.id.producto_nombre);
            tv_categoria=itemView.findViewById(R.id.producto_categoria);
            tv_disponibilidad=itemView.findViewById(R.id.producto_disponibilidad);
            tv_clave=itemView.findViewById(R.id.producto_clave);
            img_thumbnail=itemView.findViewById(R.id.thumbnail);



        }
    }
}
