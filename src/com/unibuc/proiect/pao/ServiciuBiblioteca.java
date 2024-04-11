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
    private List<Sectiune> sectiuni;
    public ServiciuBiblioteca() {
        this.carti = new ArrayList<>();
        this.cititori = new ArrayList<>();
        this.bibliotecari = new ArrayList<>();
        this.imprumuturi= new ArrayList<>();
        this.sectiuni = new ArrayList<>();
    }
    public void adaugaImprumut(Imprumut imprumut) {
        imprumuturi.add(imprumut);
    }
    public void adaugaSectiune(Sectiune sectiune) {
        sectiuni.add(sectiune);
    }
    public void adaugaCarteInSectiune(Carte carte, Sectiune sectiune) {
        carte.setSectiune(sectiune);
        carti.add(carte);
    }
    public void adaugaBibliotecar(Bibliotecar bibliotecar) {
        bibliotecari.add(bibliotecar);
    }
    public void adaugaCititor(Cititor cititor) {
        cititori.add(cititor);
    }
    public List<Carte> getCarti() {
        return carti;
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

    // Interogare 2: Sortarea cărților după autor
    public void sortareCartiDupaAutor() {
        Collections.sort(carti, new Comparator<Carte>() {
            @Override
            public int compare(Carte carte1, Carte carte2) {
                return carte1.getAutor().getNume().compareTo(carte2.getAutor().getNume());
            }
        });
    }

    // Interogarea 3: Obținerea numărului total de cărți scrise de fiecare autor
    public Map<Autor, Integer> numarCartiPeAutor() {
        Map<Autor, Integer> numarCartiAutor = new HashMap<>();
        for (Carte carte : carti) {
            Autor autorCarte = carte.getAutor();
            numarCartiAutor.put(autorCarte, numarCartiAutor.getOrDefault(autorCarte, 0) + 1);
        }
        return numarCartiAutor;
    }

    // Interogarea 4: Afișarea listei de autori în ordine alfabetică
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
    // Interogare 6: Obținerea listei de împrumuturi active
    public List<Imprumut> imprumuturiActive() {
        List<Imprumut> active = new ArrayList<>();
        for (Imprumut imprumut : imprumuturi) {
            if (!imprumut.isReturnat()) {
                active.add(imprumut);
            }
        }
        return active;
    }
    // Interogare 7: Găsirea tuturor recenziilor pentru o anumită carte
    public List<Recenzie> recenziiPentruCarte(Carte carte) {
        List<Recenzie> recenzii = new ArrayList<>();
        for (Recenzie recenzie : carte.getRecenzii()) {
            recenzii.add(recenzie);
        }
        return recenzii;
    }
    // Interogare 8: Afișarea listei de cărți dintr-o anumită secțiune a bibliotecii
    public List<Carte> cartiInSectiune(Sectiune sectiune) {
        List<Carte> cartiSectiune = new ArrayList<>();
        for (Carte carte : carti) {
            if (carte.getSectiune().equals(sectiune)) {
                cartiSectiune.add(carte);
            }
        }
        return cartiSectiune;
    }
    // Interogare 9: Afișarea listei de cititori înregistrați în bibliotecă
    public List<Cititor> cititoriInregistrati() {
        return cititori;
    }

    // Interogare 10: Afisarea bibliotecarilor responsabili de o anumită secțiune
    public List<Bibliotecar> bibliotecariPentruSectiune(Sectiune sectiuneCautata) {
        List<Bibliotecar> bibliotecariSectiune = new ArrayList<>();
        for (Bibliotecar bibliotecar : bibliotecari) {
            if (bibliotecar.getSecțiuneResponsabila().equals(sectiuneCautata)) {
                bibliotecariSectiune.add(bibliotecar);
            }
        }
        return bibliotecariSectiune;
    }
}


