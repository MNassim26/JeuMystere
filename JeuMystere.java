/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeumystere;

import java.util.Scanner;

/**
 *
 * @author Nassim
 */
public class JeuMystere {

    private int niveau;
    private int nbrTentMax;

    public int choisirNiveau() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-------------- Veuillez choisir le niveau --------------");
            System.out.println("-------------- :1 Niveau facile --------------");
            System.out.println("-------------- :2 Niveau moyen --------------");
            System.out.println("-------------- :3 Niveau difficile --------------");
            System.out.println("-------------- :0 Quitter --------------");
            niveau = sc.nextInt();
        } while (niveau < 0 || niveau > 3);
        return niveau;
    }

    public void niveauFacileMoyen(int max) {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        int nbrTentEf = 0;
        int numTent, mystere;
        /*max+1 pour que le mystere soit compris entre min et max et non pas min et max-1*/
        mystere = (int) (Math.random() * (max + 1));
        do {
            System.out.println("Donner le mystere entre 0 et " + max);
            numTent = sc.nextInt();
            nbrTentEf++;
            if (nbrTentMax - nbrTentEf == 0) {
                System.out.println("Dommage! Vous avez perdu, le mystere est: " + mystere);
                end = true;
            } else {
                if (numTent == mystere) {
                    System.out.println("Bravo! Vous avez gagner au bout de " + nbrTentEf + " tentatives");
                    end = true;
                } else if (numTent < mystere) {
                    System.out.println("C'est plus,il vous reste " + (nbrTentMax - nbrTentEf) + " tentatives");
                } else if (numTent > mystere) {
                    System.out.println("C'est moins,il vous reste " + (nbrTentMax - nbrTentEf) + " tentatives");
                }
            }
        } while (end == false);
    }


    public static void main(String[] args) {
          final int nFacileDifficileMax = 100;
        final int nMoyenMax = 10000;
        final int nDifficileMin = 10;
        JeuMystere jeu = new JeuMystere();
        System.out.println("-------------- Bienvenue au jeu du mystere --------------");
        jeu.niveau = jeu.choisirNiveau();
        if (jeu.niveau == 1) {
            System.out.println("Niveau facile, le mystere est un nombre entre 0 est 100");
            jeu.nbrTentMax = 15;
            jeu.niveauFacileMoyen(nFacileDifficileMax);
        } else if (jeu.niveau == 2) {
            System.out.println("Niveau Moyen, le mystere est un nombre entre 0 est 10000");
            jeu.nbrTentMax = 10;
            jeu.niveauFacileMoyen(nMoyenMax);
        } else if (jeu.niveau == 3) {
            /*Niveau 3*/
            System.out.println("Niveau Difficile, le mystere est un nombre entre 10 est 100");
            jeu.nbrTentMax = 10;
            jeu.niveauDifficile(nDifficileMin, nFacileDifficileMax);
        }
    }

}
