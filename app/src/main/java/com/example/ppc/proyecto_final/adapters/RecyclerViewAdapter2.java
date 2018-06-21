package com.example.ppc.proyecto_final.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ppc.proyecto_final.DescripcionActivity;
import com.example.ppc.proyecto_final.EliminarActivity;
import com.example.ppc.proyecto_final.model.Descripcion;
import com.example.ppc.proyecto_final.R;

import java.util.List;

/**
 * Created by ppc on 21/06/2018.
 */

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.MyViewHolder>{

    private Context mContext;
    private List<Descripcion> mData;

    public RecyclerViewAdapter2(Context mContext, List<Descripcion> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        view=inflater.inflate(R.layout.descripcion_row_item,parent,false);
        final MyViewHolder viewHolder=new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mContext,EliminarActivity.class);
                i.putExtra("clave",mData.get(viewHolder.getAdapterPosition()).getClave());
                i.putExtra("producto",mData.get(viewHolder.getAdapterPosition()).getProducto());
                i.putExtra("subtotal",mData.get(viewHolder.getAdapterPosition()).getSubtotal());

                mContext.startActivity(i);

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_producto.setText(mData.get(position).getProducto());
        holder.tv_cantidad.setText("Cantidad:  "+mData.get(position).getCantidad());
        holder.tv_precio.setText("Precio del producto:  "+mData.get(position).getPrecio_producto());
        holder.tv_ubicacion.setText("Ubicacion actual:  "+mData.get(position).getUbicacion());
        holder.tv_subtotal.setText("Subtotal:  "+mData.get(position).getSubtotal());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_producto;
        TextView tv_cantidad;
        TextView tv_precio;
        TextView tv_ubicacion;
        TextView tv_subtotal;
        LinearLayout view_container;


        public MyViewHolder(View itemView) {
            super(itemView);

            view_container=itemView.findViewById(R.id.container);
            tv_producto=itemView.findViewById(R.id.desc_producto);
            tv_cantidad=itemView.findViewById(R.id.desc_cantidad);
            tv_precio=itemView.findViewById(R.id.desc_Precio);
            tv_ubicacion=itemView.findViewById(R.id.desc_ubicacion);
            tv_subtotal=itemView.findViewById(R.id.desc_subtotal);
        }
    }

}
