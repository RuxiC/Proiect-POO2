package com.unibuc.proiect.pao;

import java.util.Date;

public class Imprumut {
    private Carte carte;
    private String titlu;
    private Cititor cititor;
    private Date dataImprumut;
    private Date dataReturnare;
    private boolean returnat;
    @Override
    public String toString() {
        return "Imprumutul pentru cartea '" + carte.getTitlu() + "' realizat de către cititorul " + cititor.getNume();
    }


    public Imprumut(Carte carte, Cititor cititor) {
        this.carte = carte;
        this.cititor = cititor;
        this.titlu = titlu;
        this.dataImprumut = dataImprumut;
        this.dataReturnare = dataReturnare;
    }

    public Carte getCarte() {
        return carte;
    }
    public String getTitlu() {
        return titlu;
    }

    public Cititor getCititor() {
        return cititor;
    }

    public Date getDataImprumut() {
        return dataImprumut;
    }

    public Date getDataReturnare() {
        return dataReturnare;
    }

    public boolean isReturnat() {
        return returnat;
    }
}
