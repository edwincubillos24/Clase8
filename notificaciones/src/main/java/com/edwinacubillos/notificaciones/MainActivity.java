    package com.edwinacubillos.notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity {

    EditText etitulo, econtenido,eticker;
    Button notificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etitulo = (EditText) findViewById(R.id.eTitulo);
        econtenido = (EditText) findViewById(R.id.eContenido);
        eticker = (EditText) findViewById(R.id.eTicker);
        notificar = (Button) findViewById(R.id.bNotificar);

        notificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titulo="", contenido="", ticker="";
                titulo = etitulo.getText().toString();
                contenido = econtenido.getText().toString();
                ticker = eticker.getText().toString();

                NotificationCompat.Builder builder = new NotificationCompat.
                        Builder(getApplicationContext());

                builder.setContentTitle(titulo)
                        .setContentText(contenido)
                        .setTicker(ticker)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentInfo("Dato");

                Intent noIntent = new Intent(MainActivity.this, Main2Activity.class);

                PendingIntent contIntent = PendingIntent.
                        getActivity(MainActivity.this, 0, noIntent,0);

                builder.setContentIntent(contIntent);

                NotificationManager nm = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                nm.notify(1,builder.build());
            }
        });
    }
}
