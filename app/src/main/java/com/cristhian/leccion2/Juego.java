package com.cristhian.leccion2;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Juego extends Activity {

    private TextView jugador;
    private LinearLayout layout;
    private TextView num1,num2,num3;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        String nombre = getIntent().getStringExtra("jugador");
        jugador = (TextView)findViewById(R.id.lblJugador);
        jugador.setText(nombre);
        layout = (LinearLayout)findViewById(R.id.layJuego);
        handler = new Handler(getMainLooper());

        num1 = new TextView(this);
        num2 = new TextView(this);
        num3 = new TextView(this);
        num1.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        num1.setText("1");
        num1.setTextSize(50f);
        num1.setPadding(60,0,0,0);
        num2.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        num2.setText("2");
        num2.setTextSize(50f);
        num2.setPadding(100,0,0,0);
        num3.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        num3.setText("3");
        num3.setTextSize(50f);
        num3.setPadding(100,0,0,0);

        layout.addView(num1);
        layout.addView(num2);
        layout.addView(num3);

        handler.post(new Runnable() {
            @Override
            public void run() {
                boolean mover = true;
                float pos = num3.getTranslationY();
                while(mover){
                    num3.setTranslationY(pos + 25f);
                    pos = num3.getTranslationY();
                    if (pos >= 600f){
                        mover = false;
                    }
                    try{
                        Thread.sleep(200);
                    }catch (InterruptedException e){
                        Log.e("JUEGO",e.getMessage());
                    }
                }
            }
        });
    }
}

class numeros extends AsyncTask<TextView,Void,Void> {

    @Override
    protected Void doInBackground(TextView[] num) {
        //float pos = num[0].getTranslationY();
        //num[0].setTranslationY(pos + 10f);
        return null;
    }

}
