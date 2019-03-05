
package com.example.henrr.appmath;
//Clase relacionada con el documento ejercicio.xml para la pantalla del botón "ejercicios".


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class EjerciciosF extends AppCompatActivity {

    private Button validar1,validar2,validar3,validar4,terminar,reset; //Variables para relacionar los Button de la pantalla.
    private CheckBox a,b,c,d; //Variables para relacionar los CheckBox de la pantalla.
    private EditText r1,r2,r3; //Variables para relacionar los EdtiText de la pantalla.
    private String result1="5.1"; //Variables para comparar el resultado del primer ejercicio de la pantalla.
    private String result2="7/8"; //Variables para comparar el resultado del segundo ejercicio de la pantalla.
    private String equi1="14/16"; //Variables para comparar el resultado del segundo ejercicio de la pantalla.
    private String equi2="21/24"; //Variables para comparar el resultado del segundo ejercicio de la pantalla.
    private String result3="1/8"; //Variables para comparar el resultado del tercer ejercicio de la pantalla.
    private String equi3="2/16"; //Variables para comparar el resultado del tercer ejercicio de la pantalla.
    private Integer contBuenas=0,level=0; //Variables contadores para el número de buena y level obtenido.
    BDRegistro database; //Variable de tipo BDRegistro para crear la base de datos.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicios);

        //Asiganación de variables.
        a = (CheckBox) findViewById(R.id.idCheck1);
        b = (CheckBox) findViewById(R.id.idCheck2);
        c = (CheckBox) findViewById(R.id.idCheck3);
        d = (CheckBox) findViewById(R.id.idCheck4);
        validar1 = (Button) findViewById(R.id.btnCheckBox);
        validar2 = (Button) findViewById(R.id.btnRes1);
        validar3 = (Button) findViewById(R.id.btnRes2);
        validar4 = (Button) findViewById(R.id.btnRes3);
        r1 = (EditText) findViewById(R.id.res1);
        r2 = (EditText) findViewById(R.id.res2);
        r3 = (EditText) findViewById(R.id.res3);
        terminar = (Button) findViewById(R.id.btnFinish);
        reset = (Button) findViewById(R.id.btnReset);

        //Evento onClick del botón validar1. Se comparan los resultados obtenidos del usuario.
        validar1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(b.isChecked()&&(a.isChecked())&&(c.isChecked())&&(d.isChecked())){
                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Intenta de nuevo!",Toast.LENGTH_LONG).show();
                }

                else if(b.isChecked()){
                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Intenta de nuevo!",Toast.LENGTH_LONG).show();
                }

                else if (d.isChecked()){
                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Intenta de nuevo!",Toast.LENGTH_LONG).show();
                }

                else if (c.isChecked()){
                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Intenta de nuevo!",Toast.LENGTH_LONG).show();
                }

                else{
                        contBuenas=contBuenas+1;
                        Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                }

            }
        });

        //Evento onClick del botón validar2. Se comparan los resultados obtenidos del usuario.
        validar2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if (TextUtils.equals(r1.getText(),result1)){
                    contBuenas=contBuenas+1;
                    Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Intenta de nuevo!",Toast.LENGTH_LONG).show();
                }
            }
        });

        //Evento onClick del botón validar3. Se comparan los resultados obtenidos del usuario.
        validar3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if (TextUtils.equals(r2.getText(),result2)||(TextUtils.equals(r2.getText(),equi1))||(TextUtils.equals(r2.getText(),equi2))){
                    contBuenas=contBuenas+1;
                    Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Intenta de nuevo!",Toast.LENGTH_LONG).show();
                }
            }
        });

        //Evento onClick del botón validar4. Se comparan los resultados obtenidos del usuario.
        validar4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if (TextUtils.equals(r3.getText(),result3)||(TextUtils.equals(r3.getText(),equi3))){
                    contBuenas=contBuenas+1;
                    Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Intenta de nuevo!",Toast.LENGTH_LONG).show();
                }
            }
        });

        //Evento onClick del botón terminar. Se obtiene el número de buenas y además se sincronizan los datos con el perfil.
        terminar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {



                level = contBuenas / 2;
                Toast.makeText(getApplicationContext(), "Obtuviste: " + contBuenas + " buenas y " + level + " puntos de nivel", Toast.LENGTH_LONG).show();
                try {

                    SQLiteDatabase bd = database.getWritableDatabase();
                    ContentValues registro = new ContentValues();

                    registro.put("nivel", level.toString());
                    bd.insert("usuario", null, registro);
                    bd.close();
                    Toast.makeText(getApplicationContext(), "Datos guardados", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EjerciciosF.this, Principal.class);
                    startActivity(intent);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error en el registro!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Evento onClick del botón reset. Se vacían los campos de texto en la pantalla..
        reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

               r1.setText("");
               r2.setText("");
               r3.setText("");
               a.setChecked(false);
               b.setChecked(false);
               c.setChecked(false);
               d.setChecked(false);
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
