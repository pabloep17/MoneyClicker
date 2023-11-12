package com.example.contador;

import java.math.BigInteger;

public class Mejora {
    private int imageResId;
    private String text;
    private String buttonFuncion;
    private BigInteger precio;
    private BigInteger incPrecioMejora;

    // Futura implementacion;
    private int buttonBGColorId;
    private int ButtonBGColorDisabledId;


    public Mejora(int imageResId, String text, String buttonFuncion, BigInteger incPrecioMejora, BigInteger nivelMejora ) {
        this.imageResId = imageResId;
        this.text = text;
        this.buttonFuncion = buttonFuncion;
        this.incPrecioMejora = incPrecioMejora;
        this.precio = new BigInteger("100");
        for(int i = 0; i <= nivelMejora.doubleValue(); i++) {
            this.precio = this.precio.add(new BigInteger(String.valueOf(i)).multiply(incPrecioMejora));
        }
    }

    public Mejora(int imageResId, String text, String buttonFuncion, BigInteger incPrecioMejora, int nivelMejora ) {
        this.imageResId = imageResId;
        this.text = text;
        this.buttonFuncion = buttonFuncion;
        this.incPrecioMejora = incPrecioMejora;
        this.precio = new BigInteger("1000");

        int index = -1;
        for (int i = 3000; i > nivelMejora; i -= 50) {
            index++;
            this.precio = precio.add(new BigInteger(String.valueOf(nivelMejora + 1000)));
            this.precio = precio.add(incPrecioMejora.multiply(new BigInteger(String.valueOf(index))));
        }

    }

    public int getImageResId() {
        return imageResId;
    }

    public String getText() {
        return text;
    }

    public String getButtonFuncion() {
        return buttonFuncion;
    }

    public BigInteger getPrice() {
        return precio;
    }

    public void incPrice(BigInteger clickValue) {
        precio = precio.add(clickValue.multiply(incPrecioMejora));
    }

    public void incPrice(int clickValue) {
        precio = precio.add(new BigInteger(String.valueOf(clickValue + 1000)));
    }

}
