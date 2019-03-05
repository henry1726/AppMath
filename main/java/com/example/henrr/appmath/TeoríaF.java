package com.example.henrr.appmath;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentTransitionImpl;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.henrr.appmath.Entidades.PersonajeVo;
import com.example.henrr.appmath.Fragments.DetallePersonajeFragment;
import com.example.henrr.appmath.Fragments.FragmentDecimal;
import com.example.henrr.appmath.Fragments.FragmentFracc;
import com.example.henrr.appmath.Fragments.FragmentGeo;
import com.example.henrr.appmath.Interfaces.IComunicaFragments;
import com.example.henrr.appmath.Utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TeoríaF extends AppCompatActivity
        implements FragmentFracc.OnFragmentInteractionListener,
        FragmentGeo.OnFragmentInteractionListener, FragmentDecimal.OnFragmentInteractionListener,
        DetallePersonajeFragment.OnFragmentInteractionListener, IComunicaFragments {

    private Button Fracciones, Geo, Decimal; //Variables para relacionar los Button de la pantalla.
    FragmentFracc fragmentFracc; //Variable de tipo FragmentFracc. Se relaciona con el fragmento para el texto de la teoría de fracciones.
    FragmentGeo fragmentGeo; //Variable de tipo FragmentGeo. Se relaciona con el fragmento para el texto de la teoría de geometría.
    FragmentDecimal fragmentDecimal, listaFragment; //Variable de tipo FragmentDecimal. Se relaciona con el fragmento para el texto de la teoría de decimales.
    DetallePersonajeFragment detalleFragment; //Variable de tipo DetallePersonajeFragment. Se relaciona con la pantalla del detallo de un fragmento.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teoria);

        //Asignación de variables.
        fragmentFracc = new FragmentFracc();
        fragmentGeo = new FragmentGeo();
        fragmentDecimal = new FragmentDecimal();
        Fracciones = (Button) findViewById(R.id.TFracc);
        Geo = (Button) findViewById(R.id.TGeo);
        Decimal = (Button) findViewById(R.id.TDecimal);

        //getSupportFragmentManager().beginTransaction().add(R.id.contenedorFrag, fragmentFracc).commit();

        //Asgina la pantalla con el fragment correspondiente.
        if(findViewById(R.id.contenedorFragment)!=null){
            Utilidades.PORTRAIT=true;
            if (savedInstanceState!=null){
                return;
            }
            listaFragment = new FragmentDecimal();
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.contenedorFragment, listaFragment).commit();
        }else{
            Utilidades.PORTRAIT=false;
        }


    }

    //Método enviarPersonaje. Envía una varibale de tipo PersonajeVO.
    @Override
    public void enviarPersonaje(PersonajeVo personaje) {

            detalleFragment=new DetallePersonajeFragment();
            Bundle bundleEnvio=new Bundle();
            bundleEnvio.putSerializable("objeto",personaje);
            detalleFragment.setArguments(bundleEnvio);

            //cargamos el fragment en el Activity
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.contenedorFragment,detalleFragment).
                    addToBackStack(null).commit();
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    //Método OnClick. Realiza la iteración entre fragmentos.
    public void OnClick(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment miFragment=null;

        switch (view.getId()){

            case R.id.TFracc:
                transaction.replace(R.id.contenedorFragment, fragmentFracc);
                break;
            case R.id.TGeo:
                transaction.replace(R.id.contenedorFragment, fragmentGeo);
                break;
            case R.id.TDecimal:
                transaction.replace(R.id.contenedorFragment, fragmentDecimal);
                break;

        }
        transaction.commit();
    }


}
