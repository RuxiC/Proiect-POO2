package com.unibuc.proiect.pao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class ServiciuBiblioteca {
    private List<Carte> carti;
    private List<Cititor> cititori;
    private List<Bibliotecar> bibliotecari;
    private List<Imprumut> imprumuturi;
    public ServiciuBiblioteca() {
        this.carti = new ArrayList<>();
       // this.cititori = new ArrayList<>();
        this.bibliotecari = new ArrayList<>();
        this.imprumuturi= new ArrayList<>();
    }

    public void adaugaCarte(Carte carte) {
        carti.add(carte);
    }
    public void adaugaImprumut(Imprumut imprumut) {
        imprumuturi.add(imprumut);
    }

    public void adaugaCititor(Cititor cititor) {
        cititori.add(cititor);
    }

    public List<Carte> getCarti() {
        return carti;
    }

    public List<Cititor> getCititori() {
        return cititori;
    }

    // Interogarea 1: Găsirea tuturor cărților scrise de un anumit autor
    public List<Carte> cartiScriseDeAutor(Autor autorCautat) {
        List<Carte> cartiAutor = new ArrayList<>();
        for (Carte carte : carti) {
            if (carte.getAutor().equals(autorCautat)) {
                cartiAutor.add(carte);
            }
        }
        return cartiAutor;
    }

    // Interogarea 2: Obținerea numărului total de cărți scrise de fiecare autor
    public Map<Autor, Integer> numarCartiPeAutor() {
        Map<Autor, Integer> numarCartiAutor = new HashMap<>();
        for (Carte carte : carti) {
            Autor autorCarte = carte.getAutor();
            numarCartiAutor.put(autorCarte, numarCartiAutor.getOrDefault(autorCarte, 0) + 1);
        }
        return numarCartiAutor;
    }

    // Interogarea 3: Afișarea listei de autori în ordine alfabetică
    public List<Autor> autoriInOrdineAlfabetica() {
        List<Autor> autoriSortati = new ArrayList<>();
        for (Carte carte : carti) {
            Autor autorCarte = carte.getAutor();
            if (!autoriSortati.contains(autorCarte)) {
                autoriSortati.add(autorCarte);
            }
        }
        Collections.sort(autoriSortati, Comparator.comparing(Autor::getNume));
        return autoriSortati;
    }

    // 5: Verificarea dacă o anumită editură a publicat o carte specifică
    public boolean edituraAPublicatCartea(Editura editura, Carte carte) {
        for (Carte carteEditura : carti) {
            if (carteEditura.equals(carte) && carteEditura.getEditura().equals(editura)) {
                return true;
            }
        }
        return false;
    }
    public List<Bibliotecar> bibliotecariPentruSectiune(Sectiune sectiuneCautata) {
        List<Bibliotecar> bibliotecariSectiune = new ArrayList<>();
        for (Bibliotecar bibliotecar : bibliotecari) {
            if (bibliotecar.getSecțiuneResponsabila().equals(sectiuneCautata)) {
                bibliotecariSectiune.add(bibliotecar);
            }
        }
        return bibliotecariSectiune;
    }
    public void sortareCartiDupaAutor() {
        Collections.sort(carti, new Comparator<Carte>() {
            @Override
            public int compare(Carte carte1, Carte carte2) {
                return carte1.getAutor().getNume().compareTo(carte2.getAutor().getNume());
            }
        });
    }

    // Afișarea istoricului împrumuturilor unui cititor
    public List<Imprumut> istoricImprumuturiCititor(Cititor cititor) {
        List<Imprumut> istoric = new ArrayList<>();
        for (Imprumut imprumut : imprumuturi) {
            if (imprumut.getCititor().equals(cititor)) {
                istoric.add(imprumut);
            }
        }
        return istoric;
    }

    // Obținerea listei de împrumuturi active
    public List<Imprumut> imprumuturiActive() {
        List<Imprumut> active = new ArrayList<>();
        for (Imprumut imprumut : imprumuturi) {
            if (!imprumut.isReturnat()) {
                active.add(imprumut);
            }
        }
        return active;
    }
    // Găsirea tuturor recenziilor pentru o anumită carte
    public List<Recenzie> recenziiPentruCarte(Carte carte) {
        List<Recenzie> recenzii = new ArrayList<>();
        for (Recenzie recenzie : carte.getRecenzii()) {
            recenzii.add(recenzie);
        }
        return recenzii;
    }

    // Afișarea listei de cărți dintr-o anumită secțiune a bibliotecii
    public List<Carte> cartiInSectiune(Sectiune sectiune) {
        List<Carte> cartiSectiune = new ArrayList<>();
        for (Carte carte : carti) {
            if (carte.getSectiune().equals(sectiune)) {
                cartiSectiune.add(carte);
            }
        }
            return cartiSectiune;
    }

    // Afișarea listei de cititori înregistrați în bibliotecă
    public List<Cititor> cititoriInregistrati() {
        return cititori;
    }
}


