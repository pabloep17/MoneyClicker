package com.example.contador;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.math.BigInteger;

public class Inicio extends AppCompatActivity {

    BigInteger contadorValue = new BigInteger("0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        this.setTitle("Inicio");

        try {
            Bundle parametros = this.getIntent().getExtras();
            contadorValue = new BigInteger(parametros.getString("contadorValue"));
        }catch (RuntimeException e) {
            e.printStackTrace();
        }


    }

    public void jugar(View v) {

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("contadorValue", contadorValue.toString());
        i.putExtra("manualClickValue", "1");
        i.putExtra("autoClickValue", "0");
        i.putExtra("autoClickDelay", 3000);

        startActivity(i);

    }

    public void info(View v) {
        Intent i = new Intent(this, Info.class);
        startActivity(i);
    }

    public void ajustes(View v) {
        Intent i = new Intent(this, Ajustes.class);
        i.putExtra("contadorValue", contadorValue.toString());
        startActivity(i);
    }

}