package com.edwinacubillos.clase8;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceptorFragment extends Fragment {
    private TextView nombre, apellido;

    public ReceptorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_receptor, container, false);

        nombre = (TextView) rootView.findViewById(R.id.tNombreR);
        apellido = (TextView) rootView.findViewById(R.id.tApellidoR);

        Bundle bundle = getArguments();
        nombre.setText(bundle.getString("nombre"));
        apellido.setText(bundle.getString("apellido"));

        return rootView;
    }


}
