package com.example.henrr.appmath;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActualizar extends Activity {

    private EditText Nombre, Apellidos, Email, User, Pass;
    private Button Update;
    private Button Cancelar;
    private String inID;
    private String inApellidos="";
    private String inNombre="";
    private String inEmail="";
    private String inUser="";
    private String inPass="";
    private String inLevel;
    private String inTrofeos;
    private String inExamenes;
    BDRegistro database;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actualizar);

        Nombre = (EditText) findViewById(R.id.NomUp);
        Apellidos = (EditText) findViewById(R.id.ApeUp);
        Email = (EditText) findViewById(R.id.EmailUp);
        User = (EditText) findViewById(R.id.UserUp);
        Pass = (EditText) findViewById(R.id.PassUp);

        Update = (Button) findViewById(R.id.Actualizar);
        Cancelar = (Button) findViewById(R.id.CancelarUp);

        consulta();

        Update.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                ContentValues registro = new ContentValues();
                SQLiteDatabase bd = database.getWritableDatabase();

                try {

                    inNombre = Nombre.getText().toString();
                    inApellidos = Apellidos.getText().toString();
                    inEmail = Email.getText().toString();
                    inUser = User.getText().toString();
                    inPass = Pass.getText().toString();


                    registro.put("nombre", inNombre);
                    registro.put("apellidos", inApellidos);
                    registro.put("correo", inEmail);
                    registro.put("user", inUser);
                    registro.put("password", inPass);

                    String[] argumento = {Nombre.getText().toString()};
                    int cant = bd.update("usuario", registro, "nombre=?" + argumento , null);
                    bd.close();

                    if(cant == 1)
                        Toast.makeText(getApplicationContext(), "Datos modificados con exito", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "No existe usuario", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(RegistroActualizar.this, PerfilF.class);
                    startActivity(intent);


                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error en el registro!", Toast.LENGTH_SHORT).show();
                }

                cancelar();

            }
        });


        Update.setOnClickListener(new View.OnClickListener(){

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

    public void cancelar(){
        Nombre.setText(null);
        Apellidos.setText(null);
        Email.setText(null);
        User.setText(null);
        Pass.setText(null);
    }

    public void consulta(){

        ContentValues registro = new ContentValues();
        SQLiteDatabase bd = database.getWritableDatabase();

        String[] campos = {"apellidos , correo, user, password, nivel, trofeos, examenes"};

        Cursor fila = bd.query("usuario", campos, "nombre = ?", new String[]{Nombre.getText().toString()}, null, null, null, null);

        //Cursor fila = bd.rawQuery("SELECT nombre, apellidos, direccion, telefono, correo, altura, peso, enfermedad, medicamento, usuario, contraseña FROM usuario WHERE nombre=?" + argumento, null);
        try{
            if (fila.moveToFirst())
            {
                Nombre.setText(fila.getString(0));
                Apellidos.setText(fila.getString(1));
                Email.setText(fila.getString(2));
                User.setText(fila.getString(3));
                Pass.setText(fila.getString(4));

            } else
                Toast.makeText(getApplicationContext(), "No hay coincidencia", Toast.LENGTH_LONG).show();
            fila.close();
        }catch (Exception e){Toast.makeText(getApplicationContext(), "Error en la consulta", Toast.LENGTH_LONG).show();

        }
    }


}
