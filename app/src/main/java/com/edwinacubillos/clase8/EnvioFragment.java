package com.edwinacubillos.clase8;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnvioFragment extends Fragment {

    private EditText nombre, apellido;
    private Button guardar;
    comunicador interfaz;

    public EnvioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_envio, container, false);
        nombre = (EditText) rootView.findViewById(R.id.eNombre);
        apellido = (EditText) rootView.findViewById(R.id.eApellido);
        guardar = (Button) rootView.findViewById(R.id.bGuardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nombre.getText().toString();
                String lastname = apellido.getText().toString();
                interfaz.envioDatos(name, lastname);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            interfaz = (comunicador) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()+" must implemented comunicador");
        }
    }
}
