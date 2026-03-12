package universite_Paris8.iut.qdev.tp2026.gr15.interfaces;

import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr15.utils.exceptions.*;

import java.util.ArrayList;

public interface IservicesJoueur {
    void creerJoueur(String prenom, String login, int anneeNaissance, int langue, String interets) throws PrenomInvalideException,
            LoginInvalideException,
            LoginDejaUtiliseException,
            AgeInvalideException,
            LangueException,
            CentresInteretsInvalideException;
    public ArrayList<JoueurDTO> listerJoueurs() throws PasdeJoueursException;
    public ArrayList<JoueurDTO> fournirClassement() throws PasdeJoueursException;
    public int conulterScore(String login) throws JoueurInconnuException;
    public void supprimerJoueur(String login) throws JoueurInconnuException;


}
