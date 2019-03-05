package com.example.henrr.appmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    private Button Perfil, Teoria, Ejercicios, Examen, Figuras, Tutoriales; //Variables para relacionar los botones de la pantalla.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        Perfil = (Button) findViewById(R.id.btnPerfil);
        Teoria = (Button) findViewById(R.id.btnTeoria);
        Ejercicios = (Button) findViewById(R.id.btnEjercicios);
        Examen = (Button) findViewById(R.id.btnExamen);
        Figuras = (Button) findViewById(R.id.btnFiguras);
        Tutoriales = (Button) findViewById(R.id.btnTutoriales);

        //Evento onClick del botón Perfil. Se enlaza a la pantalla correspondiente.
        Perfil.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Principal.this, PerfilF.class);
                startActivity(intent);

            }
        });

        //Evento onClick del botón Perfil. Se enlaza a la pantalla correspondiente.
        Teoria.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Principal.this, TeoríaF.class);
                startActivity(intent);

            }
        });

        //Evento onClick del botón Perfil. Se enlaza a la pantalla correspondiente.
        Ejercicios.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Principal.this, EjerciciosF.class);
                startActivity(intent);

            }
        });

        //Evento onClick del botón Perfil. Se enlaza a la pantalla correspondiente.
        Examen.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Principal.this, ExamenF.class);
                startActivity(intent);

            }
        });

        //Evento onClick del botón Perfil. Se enlaza a la pantalla correspondiente.
        Figuras.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Principal.this, FigurasF.class);
                startActivity(intent);

            }
        });

        //Evento onClick del botón Perfil. Se enlaza a la pantalla correspondiente.
        Tutoriales.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Principal.this, TutorialesF.class);
                startActivity(intent);

            }
        });
    }

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
