package com.example.contador.Util;

import java.math.BigInteger;

public class UserModel implements Comparable<UserModel> {
    private String name;
    private BigInteger monedas;

    public UserModel(String name, BigInteger monedas) {
        this.name = name;
        this.monedas = monedas;
    }

    public String getName() {
        return name;
    }

    public BigInteger getMonedas() {
        return monedas;
    }

    @Override
    public String toString() {
        return "Name: " + name  + "\n monedas: " + monedas;
    }

    @Override
    public int compareTo(UserModel o) {
        return Integer.compare(o.monedas.intValue(), this.monedas.intValue());
    }
}
