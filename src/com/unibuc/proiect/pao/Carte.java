package com.unibuc.proiect.pao;

import java.util.ArrayList;
import java.util.List;

public class Carte {
    private String titlu;
    private Autor autor;
    private boolean disponibila;
    private Editura editura;
    private List<Recenzie> recenzii;
    private List<Cititor> cititori;
    private Sectiune sectiune;

    public Carte(String titlu, Autor autor, Editura editura, Sectiune sectiune) {
        this.titlu = titlu;
        this.autor = autor;
        this.disponibila = true;
        this.editura = editura;
        this.sectiune = sectiune;
        this.recenzii = new ArrayList<>();
    }

    public String getTitlu() {
        return titlu;
    }
    public Autor getAutor() {
        return autor;
    }
    public Editura getEditura() {
        return editura;
    }
    public List<Recenzie> getRecenzii() {
        return recenzii;
    }
    public Sectiune getSectiune() {
        return sectiune;
    }
    public void adaugaRecenzie(Recenzie recenzie) {
        recenzii.add(recenzie);
    }
    public void adaugaCititor(Cititor cititor) {
        cititori.add(cititor);
    }
}


