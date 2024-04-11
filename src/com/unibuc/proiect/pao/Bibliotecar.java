package com.unibuc.proiect.pao;

public class Bibliotecar {
    private String nume;
    private Sectiune sectiuneResponsabila;

    public Bibliotecar(String nume, String numeSectiune) {
        this.nume = nume;
        this.sectiuneResponsabila = this.sectiuneResponsabila = new Sectiune(numeSectiune);;
    }

    public String getNume() {
        return nume;
    }
    public Sectiune getSecțiuneResponsabila() {
        return sectiuneResponsabila;
    }

}
