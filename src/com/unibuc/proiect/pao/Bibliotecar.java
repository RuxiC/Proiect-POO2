package com.unibuc.proiect.pao;

public class Bibliotecar {
    private String nume;
    private Sectiune sectiuneResponsabila;
    public String getNume() {
        return nume;
    }
    public Bibliotecar(String nume, String numeSectiune) {
        this.nume = nume;
        this.sectiuneResponsabila = new Sectiune(numeSectiune);
    }
    public Sectiune getSectiuneResponsabila() {
        return sectiuneResponsabila;
    }

}
