package com.example.henrr.appmath;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    //Deaclaración de variables.
    private EditText Email, Pass; //Variables para relacionar los EditText de la pantalla.
    private Button cancelar, aceptar; //Variables para relacionar los Button de la pantalla.
    private String Email2, Pass2; //Variables para asignar el user y password obtenidas de la base de datos.
    BDRegistro database; //Variables para relacionar la base de datos.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicia);

        //Asignación de variables.
        Email = (EditText) findViewById(R.id.user);
        Pass = (EditText) findViewById(R.id.pass);
        cancelar = (Button) findViewById(R.id.Cancel);
        aceptar = (Button) findViewById(R.id.Acept);

        //Evento onClick del botón aceptar. Se comparan los datos obtenidos de la base de datos y los obtenidos del usuario.
        aceptar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                    SQLiteDatabase bd = database.getWritableDatabase();

                    Email2 = Email.getText().toString();
                    Pass2 = Pass.getText().toString();
                    //Recorremos el cursor hasta que no haya más registros
                    //Cursor c = bd.rawQuery("SELECT nombre, apellidos, direccion, telefono, correo, peso, altura, usuer, password FROM usuario WHERE ID = ?", null);
                    //Cursor c = bd.rawQuery("SELECT usuario, contraseña FROM usuario WHERE usario="+Email2 + "' and contraseña='"+Pass2,  null);

                    String[] projection={"ID, user, password"};
                    Cursor c=bd.query("usuario",projection,"user = ? AND password = ? ",new String[]{Email2, Pass2},null,null,null,null);

                try{
                    if(c.moveToFirst())
                    {
                        Intent intent = new Intent(Login.this, Principal.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"¡Bienvenido!",Toast.LENGTH_SHORT).show();

                    }
                    else
                        Toast.makeText(getApplicationContext(),"Usuario y/o contraseña incorrecto",Toast.LENGTH_SHORT).show();
                    bd.close();
                    Email.setText("");
                    Pass.setText("");
                }catch (Exception e){Toast.makeText(getApplicationContext(),"Error de lectura",Toast.LENGTH_SHORT).show();}

            }
        });

        //Evento onClick del botón cancelar. Se vacían los campos de la pantalla.
        cancelar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                try {
                    Email.setText(null);
                    Pass.setText(null);
                    Toast.makeText(Login.this, "Se ha cancelado", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    //Método onResume. Se crea la base de datos.
    @Override
    protected void onResume() {
        super.onResume();

        try
        {
            database=new BDRegistro(getApplicationContext());
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error al crear la base  de datos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void Registrarse(View v){
        Intent intent = new Intent(Login.this, Registro.class);
        startActivity(intent);
    }

}





