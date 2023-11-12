package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.example.contador.Util.NumberFormater;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    NumberFormater fn = new NumberFormater();

    TextView valueContador;
    TextView manualClickValueView;
    TextView autoClickValueView;
    TextView autoClickDelayValueView;

    BigInteger contadorValue;
    BigInteger manualClickValue;
    BigInteger autoClickValue;

    int autoClickDelay;

    Boolean autoclick = true;

    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueContador = findViewById(R.id.valueContador);
        manualClickValueView = findViewById(R.id.manualClickValueView);
        autoClickValueView = findViewById(R.id.autoClickValueView);
        autoClickDelayValueView = findViewById(R.id.autoClickDelayValueView);

        Bundle parametros = this.getIntent().getExtras();
        contadorValue = new BigInteger(parametros.getString("contadorValue"));
        manualClickValue = new BigInteger(parametros.getString("manualClickValue"));
        autoClickValue = new BigInteger(parametros.getString("autoClickValue"));
        autoClickDelay= parametros.getInt("autoClickDelay");

        updateUi();
        this.setTitle("Juego de las monedas");
        autoClick();
    }
    void autoClick() {
        new Thread(() -> {
            while (true) {
                if(autoclick) {
                    try {
                        Thread.sleep(autoClickDelay);
                        sumar(autoClickValue);
                        runOnUiThread(() -> updateUi());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void updateUi() {

        String number = fn.formarNumber(contadorValue);

        if (number == "MAX") {
            autoclick = false;
            showAlertDialog();
        }else{
            autoclick = true;
        }

        valueContador.setText(number);
        manualClickValueView.setText("Click\n" + manualClickValue.toString());
        autoClickValueView.setText("AutoClick\n" + autoClickValue.toString());
        autoClickDelayValueView.setText("Delay\n" + String.valueOf(autoClickDelay) + " ms");
    }

    public void incrementoManual(View v) {
        sumar(manualClickValue);
        animacion(v);
        updateUi();
    }

    public void comprarMejoras(View v) {
        Intent i = new Intent(this, Mejoras.class);
        i.putExtra("contadorValue", contadorValue.toString());
        i.putExtra("manualClickValue", manualClickValue.toString());
        i.putExtra("autoClickValue", autoClickValue.toString());
        i.putExtra("autoClickDelay", autoClickDelay);
        startActivity(i);
        this.finish();
    }

    public void animacion(View v) {
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);
        v.startAnimation(fade_in);
    }

    public void sumar(BigInteger incremento) {
        contadorValue = contadorValue.add(incremento);
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Maximo de monedas");
        builder.setMessage("No puedes sumar mas monedas");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // You can perform actions when the "OK" button is clicked.
                dialog.dismiss(); // Close the dialog.
                try {
                    this.finalize();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}