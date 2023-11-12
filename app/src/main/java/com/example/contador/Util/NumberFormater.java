package com.example.contador.Util;

import android.util.Log;

import java.math.BigInteger;
import java.util.ArrayList;

public class NumberFormater {

    public String formarNumber(BigInteger number) {

        String result = number.toString();

        if (number.compareTo(BigInteger.valueOf(1000)) < 0) {
            return String.format("%s%s", number, "");
        }

        /*

            Hace el logaritmo de del numero en base 1000

            Ln(10000) / Ln (1000) => Log(1000) 10000 => 2

         */
        int exp = (int) (Math.log(number.doubleValue()) / Math.log(1000));

        ArrayList<String>  valoresNumericos = new ArrayList<>();

        valoresNumericos.add("Miles");
        valoresNumericos.add("Millones");
        valoresNumericos.add("Billones");
        valoresNumericos.add("Trillones");
        valoresNumericos.add("Cuatrillones");
        valoresNumericos.add("Quintillones");
        valoresNumericos.add("Sextillones");
        valoresNumericos.add("Septillones");

        try {
            Log.v("NumberFormater", valoresNumericos.get(exp-1));
            result = String.format("%.2f\n%s", number.doubleValue() / Math.pow(1000, exp),  valoresNumericos.get(exp-1));
        } catch (IndexOutOfBoundsException e) {
            result = "MAX";
        }


        return result;

    }

}
