package com.edwinacubillos.clase8;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements comunicador{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        EnvioFragment envioFragment = new EnvioFragment();
        ft.add(android.R.id.content, envioFragment).commit();
    }

    @Override
    public void envioDatos(String nombre, String apellido) {
        Bundle args = new Bundle();
        args.putString("nombre",nombre);
        args.putString("apellido",apellido);

        ReceptorFragment receptorFragment = new ReceptorFragment();
        receptorFragment.setArguments(args);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.replace(android.R.id.content, receptorFragment).commit();
    }
}
