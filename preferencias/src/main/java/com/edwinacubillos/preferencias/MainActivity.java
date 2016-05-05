package com.edwinacubillos.preferencias;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText numero;
    Button guardar, limpiar;
    TextView dato;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = (EditText) findViewById(R.id.eNumero);
        guardar = (Button) findViewById(R.id.bGuardar);
        limpiar = (Button) findViewById(R.id.bLimpiar);
        dato = (TextView) findViewById(R.id.tDato);

        prefs = getPreferences(MODE_PRIVATE);
        editor = prefs.edit();

        refreshPrefs();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = numero.getText().toString();
                if (date !=null && !date.isEmpty()) {
                    int inf = Integer.valueOf(date);
                    editor.putInt("info", inf);
                }
                editor.commit();
                refreshPrefs();
            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                refreshPrefs();
            }
        });
    }

    public void refreshPrefs(){
        String valor = String.valueOf(prefs.getInt("info",-1));
        dato.setText(valor);
    }
}
