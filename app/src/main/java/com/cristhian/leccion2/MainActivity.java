package com.cristhian.leccion2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.txtNombre);
    }

    public void empezarJuego (View v){
        if (nombre.getText().toString().equals("")) {
            Toast.makeText(this, "Ingresa tu nombre", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(this,Juego.class);
            i.putExtra("jugador",nombre.getText().toString());
            startActivity(i);
        }
    }
}
