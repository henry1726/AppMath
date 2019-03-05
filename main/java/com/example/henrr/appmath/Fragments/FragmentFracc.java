package com.example.henrr.appmath.Fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.henrr.appmath.Adaptadores.AdaptadorPersonajes;
import com.example.henrr.appmath.Entidades.PersonajeVo;
import com.example.henrr.appmath.Interfaces.IComunicaFragments;
import com.example.henrr.appmath.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentFracc.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentFracc#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFracc extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerPersonajes;
    ArrayList<PersonajeVo> listaPersonaje;

    Activity actividad;
    IComunicaFragments interfaceComunicaFragments;

    public FragmentFracc() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentFracc.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentFracc newInstance(String param1, String param2) {
        FragmentFracc fragment = new FragmentFracc();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_fragment_decimal, container, false);
        listaPersonaje=new ArrayList<>();
        recyclerPersonajes=vista.findViewById(R.id.recycleIdFrag1);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();
        AdaptadorPersonajes adapter = new AdaptadorPersonajes(listaPersonaje);
        recyclerPersonajes.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Seleccion: "+
                        listaPersonaje.get(recyclerPersonajes.
                                getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.enviarPersonaje(listaPersonaje.get(recyclerPersonajes.getChildAdapterPosition(view)));

            }
        });

        return vista;
    }

    private void llenarLista() {

        listaPersonaje.add(new PersonajeVo(getString(R.string.Titulo_1_Fracciones), getString(R.string.Descripcion_1_Fracciones_corta),
                getString(R.string.Descripcion_1_Fracciones_larga), R.drawable.fracciones1,R.drawable.fracciones1));

        listaPersonaje.add(new PersonajeVo(getString(R.string.Titulo_2_Fracciones), getString(R.string.Descripcion_2_Fracciones_corta),
                getString(R.string.Descripcion_2_Fracciones_larga), R.drawable.fracciones2,R.drawable.fracciones2));

        listaPersonaje.add(new PersonajeVo(getString(R.string.Titulo_3_Fracciones), getString(R.string.Descripcion_3_Fracciones_corta),
                getString(R.string.Descripcion_3_Fracciones_larga), R.drawable.fracciones3,R.drawable.fracciones3));


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {

            if (context instanceof Activity) {
                this.actividad = (Activity) context;
                interfaceComunicaFragments = (IComunicaFragments) this.actividad;
            }

        }catch(Exception e){}

        if (context instanceof FragmentDecimal.OnFragmentInteractionListener) {
            mListener = (FragmentFracc.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
