package universite_Paris8.iut.qdev.tp2026.gr15.commons.dtos.entites;

import java.util.ArrayList;

public class GestionJoueurDTO {
    private ArrayList<JoueurDTO> joueurs;

    public GestionJoueurDTO() {
        joueurs = new ArrayList<>();
    }

    public ArrayList<JoueurDTO> getJoueurs() {
        return joueurs;
    }
}
