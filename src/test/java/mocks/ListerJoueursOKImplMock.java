package mocks;

import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos.GestionJoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.enums.LangueEnum;
import universite_Paris8.iut.qdev.tp2026.gr15.interfaces.IservicesJoueur;
import universite_Paris8.iut.qdev.tp2026.gr15.utils.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ListerJoueursOKImplMock implements IservicesJoueur {

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() throws PasdeJoueursException {
        GestionJoueurDTO gestion = new GestionJoueurDTO();
        gestion.getJoueurs().add(new JoueurDTO("Alice", "alice99", LangueEnum.values()[1], 2000, Arrays.asList("sport")));
        gestion.getJoueurs().add(new JoueurDTO("Bob", "bob42", LangueEnum.values()[1], 1995, Arrays.asList("musique")));
        return gestion.getJoueurs();
    }

    @Override public void creerJoueur(String prenom, String login, int anneeNaissance, int langue, String interets) throws PrenomInvalideException, LoginInvalideException, LoginDejaUtiliseException, AgeInvalideException, LangueException, CentresInteretsInvalideException {}
    @Override public ArrayList<JoueurDTO> fournirClassement() throws PasdeJoueursException { return null; }

    @Override
    public int conulterScore(String login) throws JoueurInconnuException {
        return 0;
    }

    @Override public void supprimerJoueur(String login) throws JoueurInconnuException {}
}