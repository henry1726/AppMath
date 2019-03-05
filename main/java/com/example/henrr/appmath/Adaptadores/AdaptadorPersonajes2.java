package com.example.henrr.appmath.Adaptadores;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.henrr.appmath.Entidades.PersonajeVo2;
import com.example.henrr.appmath.R;
import com.example.henrr.appmath.Utilidades.Utilidades2;

import java.util.ArrayList;

public class AdaptadorPersonajes2 extends RecyclerView.Adapter<AdaptadorPersonajes2.ViewHolderPersonajes>
        implements View.OnClickListener {


    ArrayList<PersonajeVo2> listaPersonajes;
    private View.OnClickListener listener;

    public AdaptadorPersonajes2(ArrayList<PersonajeVo2> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=0;
        if (Utilidades2.visualizacion==Utilidades2.LIST){
            layout= R.layout.iem_list_personajes;
        }else {
            layout=R.layout.item_grid_personajes;
        }

        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

        view.setOnClickListener(this);

        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderPersonajes holder, int position) {
        holder.etiNombre.setText(listaPersonajes.get(position).getNombre());

        if (Utilidades2.visualizacion==Utilidades2.LIST){
            holder.etiInformacion.setText(listaPersonajes.get(position).getInfo());
        }

        holder.foto.setImageResource(listaPersonajes.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {

        TextView etiNombre,etiInformacion;
        ImageView foto;

        public ViewHolderPersonajes(View itemView) {
            super(itemView);
            etiNombre= (TextView) itemView.findViewById(R.id.idNombre);
            if (Utilidades2.visualizacion==Utilidades2.LIST){
                etiInformacion= (TextView) itemView.findViewById(R.id.idInfo);
            }
            foto= (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
