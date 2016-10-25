package com.andrecastrom.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
*/
        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(llm);

        inicializarLitaContactos();
        inicializarAdaptador();

        /*
        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto:contactos) {
            nombresContacto.add(contacto.getNombre());
        }
        */
        /*
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
//                finish();
            }
        });
        */



    }


    public void inicializarLitaContactos() {
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.lollipop, "Pepito Grillo","666777888", "pepito@gmail.com"));
        contactos.add(new Contacto(R.drawable.mushroom, "Caperucita Roja","61234567", "caperu@gmail.com"));
        contactos.add(new Contacto(R.drawable.shock_rave, "Blanca Nieves","652123456", "blanca@gmail.com"));
        contactos.add(new Contacto(R.drawable.banana, "Lobo Feroz","698745623", "lobito@gmail.com"));
        //contactos.add(new Contacto("Santa Claus","699888555", "noelsanta@gmail.com"));
    }

    public void inicializarAdaptador() {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

}
