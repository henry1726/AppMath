package com.example.henrr.appmath;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.henrr.appmath.Adaptadores.AdaptadorPersonajes2;
import com.example.henrr.appmath.Entidades.PersonajeVo2;
import com.example.henrr.appmath.Fragments.DetallePersonajeFragment;
import com.example.henrr.appmath.Fragments.FragmentDecimal;
import com.example.henrr.appmath.Interfaces.IComunicaFragments;
import com.example.henrr.appmath.Utilidades.Utilidades;

import java.net.URI;
import java.util.ArrayList;

public class TutorialesF extends AppCompatActivity{

    //ArrayList<PersonajeVo2> listaPersonajes; //Arraylist para guardar los recuadros que se van a mostrar.
    RecyclerView recyclerPersonajes; //ReclyclerView donde se mostrarán los recuadros.

    private Button ima1,ima2,ima3;
    private LinearLayout l1;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutoriales);

        l1 = (LinearLayout) findViewById(R.id.LayoutW);
        web = (WebView) findViewById(R.id.Web1);
        ima1 = (Button) findViewById(R.id.idImagen1);
        ima2 = (Button) findViewById(R.id.idImagen2);
        ima3 = (Button) findViewById(R.id.idImagen3);

        l1.setVisibility(View.GONE);

        ima1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                l1.setVisibility(View.VISIBLE);
                web.setWebViewClient(new MyWebViewClient());
                WebSettings settings = web.getSettings();
                web.loadUrl("https://www.youtube.com/watch?v=5U2ei-Cl0pc&t=3s");

            }
        });

        ima2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                l1.setVisibility(View.VISIBLE);
                web.setWebViewClient(new MyWebViewClient());
                WebSettings settings = web.getSettings();
                web.loadUrl("https://www.youtube.com/watch?v=Ta4cS9uwpTI");

            }
        });

        ima3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                l1.setVisibility(View.VISIBLE);
                web.setWebViewClient(new MyWebViewClient());
                WebSettings settings = web.getSettings();
                web.loadUrl("https://www.google.ca/");

            }
        });

        /*listaPersonajes=new ArrayList<>();
        recyclerPersonajes=findViewById(R.id.RecyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));

        llenarPersonajes();
        AdaptadorPersonajes2 adapter= new AdaptadorPersonajes2(listaPersonajes);
        recyclerPersonajes.setAdapter(adapter);*/



    }

    private class MyWebViewClient extends WebViewClient{

        public boolean shouldOverrideUriLoading(WebView view, String uri){
            view.loadUrl(uri);
            return true;
        }
    }


    //Método llenarPersonajes. Llena el ArrayList que se mostrará en pantalla.
    /*private void llenarPersonajes() {

        listaPersonajes.add(new PersonajeVo2("Facciones","Tutorial sencillo sobre problemas de fracciones.",R.drawable.tutor));
        listaPersonajes.add(new PersonajeVo2("Decimal","Tutorial sencillo sobre problemas de número decimales.",R.drawable.tutor));
        listaPersonajes.add(new PersonajeVo2("Geometría","Fórmulas para obtener área, perímetro, volumen de figuras..",R.drawable.tutor));
    }*/

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
