package com.example.henrr.appmath;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.*;
import android.net.*;
import android.content.*;

public class Registro extends AppCompatActivity {

    private EditText Nombre, Apellidos, Email, User, Pass; //Variables para relacionar los EditText de la pantalla.
    private Button Insertar, Cancelar; //Variables para relacionar los Button de la pantalla.
    private String inApellidos="", inNombre="", inEmail="", inUser="", inPass="", inLevel="", inTrofeos="", inExamenes="";
    //Variables para asginar los datos obtenidos del usuario.
    BDRegistro database; //Variables para relacionar la base de datos.
    boolean error;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        //Asginación de variables.
        Nombre = (EditText) findViewById(R.id.Nom);
        Apellidos = (EditText) findViewById(R.id.Ape);
        Email = (EditText) findViewById(R.id.Email);
        User = (EditText) findViewById(R.id.User);
        Pass = (EditText) findViewById(R.id.Pass);
        Insertar = (Button) findViewById(R.id.Aceptar);
        Cancelar = (Button) findViewById(R.id.Cancelar);

        //Se vacían los campos de texto.
        Nombre.setText("");
        Apellidos.setText("");
        Email.setText("");
        User.setText("");
        Pass.setText("");

        //Evento onClick del botón Insertar. Se agrega un usuario a la base de datos..
        Insertar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SQLiteDatabase bd = database.getWritableDatabase();
                ContentValues registro = new ContentValues();

                inLevel="0";
                inExamenes="0";
                inNombre = Nombre.getText().toString();
                inApellidos = Apellidos.getText().toString();
                inEmail = Email.getText().toString();
                inUser = User.getText().toString();
                inPass = Pass.getText().toString();

                if ((Pass.getText().length() < 8) || TextUtils.equals(User.getText(),Pass.getText())){
                    Pass.setText("");
                    User.setText("");
                    error=true;
                }


                try {

                    registro.put("nombre", inNombre);
                    registro.put("apellidos", inApellidos);
                    registro.put("correo", inEmail);
                    registro.put("user", inUser);
                    registro.put("password", inPass);
                    registro.put("nivel", inLevel);
                    registro.put("examenes", inExamenes);

                    if(!error) {
                        bd.insert("usuario", null, registro);
                        bd.close();
                        Toast.makeText(getApplicationContext(), "usuario agregado", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registro.this, Login.class);
                        startActivity(intent);
                    }
                    else{
                        error=false;
                        Toast.makeText(getApplicationContext(), "Contraseña muy corta/usuario y contraseña iguales", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error en el registro!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Evento onClick del botón cancelar. Se vacían los campos de texto de la pantalla.
       Cancelar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Nombre.setText(null);
                Apellidos.setText(null);
                Email.setText(null);
                User.setText(null);
                Pass.setText(null);

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

    //Método onResume. Se crea la base de datos.
    @Override
    protected void onResume() {
        super.onResume();

        try
        {
            database=new BDRegistro(getApplicationContext());
            //database2=new BDMedico(getApplicationContext());
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error al crear la base  de datos", Toast.LENGTH_SHORT).show();
        }
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
