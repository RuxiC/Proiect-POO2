package com.unibuc.proiect.pao;

public class Recenzie {
    private Carte carte;
    private String continut;
    private int nota;


    public Recenzie(Carte carte, String continut, int nota) {
        this.carte = carte;
        this.continut = continut;
        this.nota = nota;
    }

    public Carte getCarte() {
        return carte;
    }

    public String getContinut() {
        return continut;
    }

    public int getNota() {
        return nota;
    }
}
