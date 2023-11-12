package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class Ajustes extends AppCompatActivity {

    EditText campoTexto;

    BigInteger numerodemonedasinicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        this.setTitle("Ajustes");

        campoTexto = (EditText) findViewById(R.id.numeromonedasinput);

        Bundle parametros = this.getIntent().getExtras();
        numerodemonedasinicio = new BigInteger(parametros.getString("contadorValue"));
        campoTexto.setText(numerodemonedasinicio.toString());
    }

    public void safe(View v){

        Intent i = new Intent(this, Inicio.class);
        i.putExtra("contadorValue", campoTexto.getText().toString());
        startActivity(i);
        this.finish();
    }

}