package com.example.henrr.appmath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class FigurasF extends AppCompatActivity {

    //Declaración de variables.
    private Button validar1,validar2,validar3,validar4,t1,t2;  //Variables para relacionar los Button de la pantalla.
    private LinearLayout l1,l2,l3,l4;  //Variables para relacionar el layout de cada ejercicio de la pantalla.
    private RelativeLayout l0;  //Variables para relacionar el layout de la pantalla principal.
    private EditText r1,r2,r3,r4;  //Variables para relacionar los EditText de la pantalla.
    private Integer rnd,contBuenas=0,level=0;  //Variables contadores para el número de buenas, level obtenido.
    private String res1="32",res2="144",res3="20",res4="99";  //Variables para relacionar los resultados de la pantalla.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figuras);

        //Asignación de variables.
        l0 = (RelativeLayout) findViewById(R.id.figura0);
        l1 = (LinearLayout) findViewById(R.id.figura1);
        l2 = (LinearLayout) findViewById(R.id.figura2);
        l3 = (LinearLayout) findViewById(R.id.figura3);
        l4 = (LinearLayout) findViewById(R.id.figura4);
        validar1 = (Button) findViewById(R.id.btnResFig1);
        validar2 = (Button) findViewById(R.id.btnResFig2);
        validar3 = (Button) findViewById(R.id.btnResFig3);
        validar4 = (Button) findViewById(R.id.btnResFig4);
        t1 = (Button) findViewById(R.id.btnFinish1);
        t2 = (Button) findViewById(R.id.btnRnd);
        r1 = (EditText) findViewById(R.id.resFig1);
        r2 = (EditText) findViewById(R.id.resFig2);
        r3 = (EditText) findViewById(R.id.resFig3);
        r4 = (EditText) findViewById(R.id.resFig4);

        //Se genera un número aleatorio entre 0 y 4.
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        rnd = random.nextInt(4);

        //Case para la asignación de layouts a cada problema dependiendo del número aleatorio obtenido.
        switch (rnd){
            case 0:
                l0.setVisibility(View.VISIBLE);
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.INVISIBLE);
                l3.setVisibility(View.INVISIBLE);
                l4.setVisibility(View.INVISIBLE);

                validar1.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                    if (TextUtils.equals(r1.getText(),res1)){
                        contBuenas=contBuenas+1;
                        Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Incorrecto ¡Vuelve a intentarlo!",Toast.LENGTH_LONG).show();
                    }
                });


                break;
            case 1:
                l0.setVisibility(View.VISIBLE);
                l1.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.VISIBLE);
                l3.setVisibility(View.INVISIBLE);
                l4.setVisibility(View.INVISIBLE);

                validar2.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        if (TextUtils.equals(r2.getText(),res2)){
                            contBuenas=contBuenas+1;
                            Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Incorrecto ¡Vuelve a intentarlo!",Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 2:

                l0.setVisibility(View.VISIBLE);
                l1.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.INVISIBLE);
                l3.setVisibility(View.VISIBLE);
                l4.setVisibility(View.INVISIBLE);

                validar3.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        if (TextUtils.equals(r3.getText(),res3)){
                            contBuenas=contBuenas+1;
                            Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Incorrecto ¡Vuelve a intentarlo!",Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 3:

                l0.setVisibility(View.VISIBLE);
                l1.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.INVISIBLE);
                l3.setVisibility(View.INVISIBLE);
                l4.setVisibility(View.VISIBLE);

                validar4.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        if (TextUtils.equals(r4.getText(),res4)){
                            contBuenas=contBuenas+1;
                            Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Incorrecto ¡Vuelve a intentarlo!",Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }

        t1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                level = contBuenas / 2;
                Toast.makeText(getApplicationContext(), "Obtuviste: " + contBuenas + " buenas y " + level + " puntos de nivel", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FigurasF.this, Principal.class);
                startActivity(intent);
            }
        });

        t2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Random random = new Random();
                random.setSeed(System.currentTimeMillis());

                rnd = random.nextInt(4);

                switch (rnd){

                    case 0:
                        l0.setVisibility(View.VISIBLE);
                        l1.setVisibility(View.VISIBLE);
                        l2.setVisibility(View.INVISIBLE);
                        l3.setVisibility(View.INVISIBLE);
                        l4.setVisibility(View.INVISIBLE);

                        validar1.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                if (TextUtils.equals(r1.getText(),res1)){
                                    contBuenas=contBuenas+1;
                                    Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Vuelve a intentarlo!",Toast.LENGTH_LONG).show();
                            }
                        });


                        break;
                    case 1:
                        l0.setVisibility(View.VISIBLE);
                        l1.setVisibility(View.INVISIBLE);
                        l2.setVisibility(View.VISIBLE);
                        l3.setVisibility(View.INVISIBLE);
                        l4.setVisibility(View.INVISIBLE);

                        validar2.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                if (TextUtils.equals(r2.getText(),res2)){
                                    contBuenas=contBuenas+1;
                                    Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Vuelve a intentarlo!",Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    case 2:

                        l0.setVisibility(View.VISIBLE);
                        l1.setVisibility(View.INVISIBLE);
                        l2.setVisibility(View.INVISIBLE);
                        l3.setVisibility(View.VISIBLE);
                        l4.setVisibility(View.INVISIBLE);

                        validar3.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                if (TextUtils.equals(r3.getText(),res3)){
                                    contBuenas=contBuenas+1;
                                    Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Vuelve a intentarlo!",Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    case 3:

                        l0.setVisibility(View.VISIBLE);
                        l1.setVisibility(View.INVISIBLE);
                        l2.setVisibility(View.INVISIBLE);
                        l3.setVisibility(View.INVISIBLE);
                        l4.setVisibility(View.VISIBLE);

                        validar4.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                if (TextUtils.equals(r4.getText(),res4)){
                                    contBuenas=contBuenas+1;
                                    Toast.makeText(getApplicationContext(),"Correcto ¡Bien hecho!",Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(getApplicationContext(),"Incorrecto ¡Vuelve a intentarlo!",Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                }

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
