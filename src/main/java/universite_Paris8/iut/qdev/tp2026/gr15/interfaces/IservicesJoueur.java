package universite_Paris8.iut.qdev.tp2026.gr15.interfaces;

import universite_Paris8.iut.qdev.tp2026.gr15.commons.dtos.entites.JoueurDTO;

import java.util.ArrayList;

public interface IservicesJoueur {
    public void creeJoueur();
    public ArrayList<JoueurDTO> listerJoueurs();
    public ArrayList<JoueurDTO> fournirClassement();
    public int conulterScore();
    public void supprimerJoueur();


}
