package com.unibuc.proiect.pao;

import java.util.*;

public class ApplicationStartup {
        public static void main(String[] args) {
            Autor autor1 = new Autor("Liviu Rebreanu");
            Autor autor2 = new Autor("Mircea Eliade");
            Autor autor3 = new Autor("ABC");

            // Creare și adăugare bibliotecari
            Bibliotecar bibliotecar1 = new Bibliotecar("Popescu Ion", "fictiune");
            Bibliotecar bibliotecar2 = new Bibliotecar("Georgescu Vasile", "non-fictiune");

            // Creare și adăugare cărți
            Carte carte1 = new Carte("Ion", autor1, new Editura("Humanitas", "Bucuresti"), new Sectiune("non-fictiune"));
            Carte carte2 = new Carte("Maitreyi", autor2, new Editura("Humanitas", "Bucuresti"), new Sectiune("non-fictiune"));
            Carte carte3 = new Carte("Carte1", autor3, new Editura("Humanitas", "Bucuresti"), new Sectiune("non-fictiune"));

            // Creare și adăugare cititori
            Cititor cititor1 = new Cititor("Bogdan");
            Cititor cititor2 = new Cititor("Cosmin");

            // Creare și adăugare edituri
            Editura editura1 = new Editura("Humanitas", "Bucuresti");
            Editura editura2 = new Editura("Libris", "Bucuresti");

            // Creare și adăugare imprumuturi
            Imprumut imprumut1 = new Imprumut(carte1, cititor1);
            Imprumut imprumut2 = new Imprumut(carte2, cititor2);

            // Creare și adăugare recenzii
            Recenzie recenzie1 = new Recenzie(carte1, "Continu1",4);
            Recenzie recenzie2 = new Recenzie(carte2, "Continut2",5);

            // Adăugare recenzii la cărți
            carte1.adaugaRecenzie(recenzie1);
            carte2.adaugaRecenzie(recenzie2);
           // carte1.adaugaCititor(cititor1);
           // carte2.adaugaCititor(cititor2);

            // Creare și adăugare secțiuni
            Sectiune sectiune1 = new Sectiune("fictiune");
            Sectiune sectiune2 = new Sectiune("non-fictiune");

            // Adăugare cărți în serviciul bibliotecii
            ServiciuBiblioteca serviciu = new ServiciuBiblioteca();
            serviciu.adaugaCarte(carte1);
            serviciu.adaugaCarte(carte2);
            serviciu.adaugaCarte(carte3);

            serviciu.adaugaImprumut(imprumut1);
            serviciu.adaugaImprumut(imprumut2);

            serviciu.adaugaSectiune(sectiune1);
            serviciu.adaugaSectiune(sectiune2);

            serviciu.adaugaCititor(cititor1);
            serviciu.adaugaCititor(cititor2);

            // Interogarea 1: Găsirea tuturor cărților scrise de un anumit autor
            Autor autorCautat = new Autor("Liviu Rebreanu");
            List<Carte> cartiAutor = serviciu.cartiScriseDeAutor(autorCautat);
            System.out.println("Cărțile scrise de " + autorCautat.getNume() + " sunt:");
            for (Carte carte : cartiAutor) {
                System.out.println("- " + carte.getTitlu());
            }

            // Interogarea 2: Obținerea numărului total de cărți scrise de fiecare autor
            Map<Autor, Integer> numarCartiAutor = serviciu.numarCartiPeAutor();
            System.out.println("Numărul de cărți scrise de fiecare autor:");
            for (Map.Entry<Autor, Integer> entry : numarCartiAutor.entrySet()) {
                Autor autor = entry.getKey();
                int numarCarti = entry.getValue();
                System.out.println("- " + autor.getNume() + ": " + numarCarti + " cărți");
            }

            // Interogarea 3: Afișarea listei de autori în ordine alfabetică
            List<Autor> autoriAlfabetic = serviciu.autoriInOrdineAlfabetica();
            System.out.println("Lista de autori în ordine alfabetică:");
            for (Autor autor : autoriAlfabetic) {
                System.out.println("- " + autor.getNume());
            }

/*
            // Interogare 4: Afișarea istoricului împrumuturilor unui cititor
            List<Imprumut> istoricCititor = serviciu.istoricImprumuturiCititor(cititor1);
            for (Imprumut imprumut : istoricCititor) {
                System.out.println("Cartea: " + imprumut.getCarte().getTitlu() + ", Data împrumutului: " + imprumut.getDataImprumut());
            }
*/
            // Interogare 5: Verificarea dacă o anumită editură a publicat o carte specifică
            Editura edituraCautata = new Editura("Humanitas", "Bucuresti");
            for (Carte carte : serviciu.getCarti()) {
                boolean publicataDeEditura = serviciu.edituraAPublicatCartea(edituraCautata, carte);
                System.out.println("Cartea " + carte.getTitlu() + " a fost publicată de editura " + edituraCautata.getNume() + "? " + publicataDeEditura);
            }

            // Interogare 6: Obținerea listei de împrumuturi active
            List<Imprumut> imprumuturiActive = serviciu.imprumuturiActive();
            System.out.println("Imprumuturile active sunt:");
            for (Imprumut imprumut : imprumuturiActive) {
                System.out.println("- " + imprumut);
            }
            // Interogare 7: Găsirea tuturor recenziilor pentru o anumită carte
            List<Recenzie> recenzii = serviciu.recenziiPentruCarte(carte1);
            for (Recenzie recenzie : recenzii) {
                System.out.println("Recenzie: " + recenzie.getContinut() + ", Nota: " + recenzie.getNota());
            }

            // Interogare 8: Afișarea listei de cărți dintr-o anumită secțiune a bibliotecii
            List<Carte> cartiSectiune = serviciu.cartiInSectiune(sectiune1);
            for (Carte carte : cartiSectiune) {
                System.out.println("Carte: " + carte.getTitlu() + ", Autor: " + carte.getAutor().getNume());
            }

            //Interogare 9: Afișarea listei de cititori înregistrați în bibliotecă
            List<Cititor> cititoriInregistrati = serviciu.cititoriInregistrati();
            for (Cititor cititor : cititoriInregistrati) {
                System.out.println("Cititor: " + cititor.getNume());
            }
        }

}
