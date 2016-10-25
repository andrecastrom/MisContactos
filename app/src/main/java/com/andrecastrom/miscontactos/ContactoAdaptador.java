package com.andrecastrom.miscontactos;

import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.TestMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 47369176d on 25/10/2016.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;

    public ContactoAdaptador(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }


    //Infla el layout y lo pasa al viewholder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
        }
    }

}
