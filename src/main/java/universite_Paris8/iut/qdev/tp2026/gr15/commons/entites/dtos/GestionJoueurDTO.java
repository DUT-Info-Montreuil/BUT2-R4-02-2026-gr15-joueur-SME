package universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos;

import java.util.ArrayList;

public class GestionJoueurDTO {

    private static GestionJoueurDTO instance;

    private ArrayList<JoueurDTO> joueurs;

    private GestionJoueurDTO() {
        joueurs = new ArrayList<>();
    }

    public static GestionJoueurDTO getInstance() {
        if (instance == null) {
            instance = new GestionJoueurDTO();
        }
        return instance;
    }

    public ArrayList<JoueurDTO> getJoueurs() {
        return joueurs;
    }

    public void addJoueur(JoueurDTO j) {
        joueurs.add(j);
    }
}