package com.example.henrr.appmath;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
import com.example.henrr.appmath.Registro;

import java.util.logging.Level;

public class PerfilF extends AppCompatActivity{

    private Button Home; //Variables para relacionar los botones de la pantalla.
    private TextView Nombre, Nick, Nivel, Examenes; //Variables para relacionar los TextView de la pantalla.
    String Nombre1=null, user1=null,nivel1=null,trofeos1=null,examen1=null; //Variables para relacionar los datos del perfil.
    BDRegistro database; //Variables para relacionar la base de datos.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        //Asignación de variables.
        Home = (Button) findViewById(R.id.btnHome);
        Nombre = (TextView) findViewById(R.id.UserNombre);
        Nick = (TextView) findViewById(R.id.NickName);
        Nivel = (TextView) findViewById(R.id.UserNivel);
        Examenes = (TextView) findViewById(R.id.UserExamen);

        //Evento onClick del botón Home. Regresa a menú principal.
        Home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PerfilF.this, Principal.class);
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

    //Método onResume. Crea la base de datos e imprime todos los datos obtenidos.
    @Override
    protected void onResume() {
        super.onResume();

        try
        {
            database=new BDRegistro(getApplicationContext());
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error al crear la base  de datos", Toast.LENGTH_SHORT).show();
        }

        try{
            obtener_datos();
            Nombre.setText("Nombre: "+Nombre1);
            Nick.setText("UserName: "+user1);
            Nivel.setText("Level: "+nivel1);
            Examenes.setText("Exámenes completos: "+examen1);
        }catch (Exception e){}
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

    //Método obtener_datos. Obtiene los datos del usuario desde la base de datos.
   public void obtener_datos(){

        SQLiteDatabase db=database.getWritableDatabase();
        String[] projection={"nombre, user, nivel, examenes"};
        Cursor fila=db.query("usuario",projection,null,null,null,null,null,null);
        try{
            if(fila.moveToFirst())
            {
               Nombre1 = fila.getString(0);
               user1= fila.getString(1);
               nivel1= fila.getString(2);
               examen1= fila.getString(3);
            }
            else
                Toast.makeText(getApplicationContext(),"Datos no encontrados!!",Toast.LENGTH_SHORT).show();
            db.close();
        }catch (Exception e){Toast.makeText(getApplicationContext(),"Error de lectura",Toast.LENGTH_SHORT).show(); }

       // L1.setVisibility(View.VISIBLE);
        //L2.setVisibility(View.VISIBLE);
       // L3.setVisibility(View.VISIBLE);
   }


}
