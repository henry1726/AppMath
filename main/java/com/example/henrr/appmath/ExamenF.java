package com.example.henrr.appmath;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExamenF extends AppCompatActivity {

    //Declaración de variables.
    private Button empezar, terminar, pausar; //Variables para relacionar los Button de la pantalla.
    private Chronometer clk; //Variable para relacionar el Chronometer de la pantalla.
    private long pause; //Variable por si se pausa el cronómetro.
    private Integer level=0, contBuenas=0; //Variables contadores para el número de buena y level obtenido.
    private Button validar1,validar2,validar3,validar4, validar5; //Variables para relacionar los Button de la pantalla.
    private CheckBox a,b; //Variables para relacionar los CheckBox de la pantalla.
    private EditText r1,r2,r3,r4; //Variables para relacionar los EdtiText de la pantalla.
    private String result1="3/4"; //Variables para comparar el resultado del primer ejercicio de la pantalla.
    private String result2="1.91"; //Variables para comparar el resultado del segundo ejercicio de la pantalla.
    private String result3="1.3"; //Variables para comparar el resultado del tercer ejercicio de la pantalla.
    private String result4="113.04"; //Variables para comparar el resultado del cuarto ejercicio de la pantalla.
    private String FinishTime; //Variables para imprimir la cantidad de tiempo que tardó el usuario en resolver el examen.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examen);

        //Asiganación de variables.
        empezar = (Button) findViewById(R.id.btnInicio);
        terminar = (Button) findViewById(R.id.btnTerminar);
        pausar = (Button) findViewById(R.id.btnPause);
        clk = (Chronometer) findViewById(R.id.cronometro);
        a = (CheckBox) findViewById(R.id.idCheckE1);
        b = (CheckBox) findViewById(R.id.idCheckE2);
        validar1 = (Button) findViewById(R.id.btnECheckBox);
        validar2 = (Button) findViewById(R.id.btnResE1);
        validar3 = (Button) findViewById(R.id.btnResE2);
        validar4 = (Button) findViewById(R.id.btnResE3);
        validar5 = (Button) findViewById(R.id.btnResE4);
        r1 = (EditText) findViewById(R.id.resE1);
        r2 = (EditText) findViewById(R.id.resE2);
        r3 = (EditText) findViewById(R.id.resE3);
        r4 = (EditText) findViewById(R.id.resE4);

        //Se desactivan los botones al inicio la actividad y se reactivan cuando el cronómetro empieza a contar.
        validar1.setEnabled(false);
        validar2.setEnabled(false);
        validar3.setEnabled(false);
        validar4.setEnabled(false);
        validar5.setEnabled(false);

        //Evento onClick del botón empezar. Empieza a contar el cronómetro y se comparan los resultados obtenidos por el usuario.
        empezar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                clk.setBase(SystemClock.elapsedRealtime() - pause);
                clk.start();

                validar1.setEnabled(true);
                validar2.setEnabled(true);
                validar3.setEnabled(true);
                validar4.setEnabled(true);
                validar5.setEnabled(true);

                //Evento onClick del botón validar1. Se comparan los resultados obtenidos del usuario.
                validar1.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        if (a.isChecked()){
                            Toast.makeText(getApplicationContext(),"Incorrecto ¡Intenta de nuevo!",Toast.LENGTH_LONG).show();
                        }

                        else if (b.isChecked()){
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

                        if (TextUtils.equals(r2.getText(),result2)){
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

                        if (TextUtils.equals(r3.getText(),result3)){
                            contBuenas=contBuenas+1;
                            Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Incorrecto ¡Intenta de nuevo!",Toast.LENGTH_LONG).show();
                        }

                    }
                });

                //Evento onClick del botón validar15. Se comparan los resultados obtenidos del usuario.
                validar5.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        if (TextUtils.equals(r4.getText(),result4)){
                            contBuenas=contBuenas+1;
                            Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Incorrecto ¡Intenta de nuevo!",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        //Evento onClick del botón pausar. Se detiene el cronómetro y se desactivan los botones.
        pausar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                clk.stop();
                pause = SystemClock.elapsedRealtime() - clk.getBase();
                validar1.setEnabled(false);
                validar2.setEnabled(false);
                validar3.setEnabled(false);
                validar4.setEnabled(false);
                validar5.setEnabled(false);
            }
        });

        //Evento onClick del botón terminar. Se obtiene el número de buenas y además se sincronizan los datos con el perfil.
        terminar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                level = contBuenas / 2;
                //pause = SystemClock.elapsedRealtime() - clk.getBase();
                FinishTime = (String) clk.getText();

                Toast.makeText(getApplicationContext(), "Obtuviste: " + contBuenas + " buenas y " + level + " puntos de nivel con un tiempo de "+FinishTime+ " segundos", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ExamenF.this, Principal.class);
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
