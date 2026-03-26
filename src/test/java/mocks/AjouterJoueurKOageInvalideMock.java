package mocks;

import universite_Paris8.iut.qdev.tp2026.gr15.interfaces.IservicesJoueur;
import universite_Paris8.iut.qdev.tp2026.gr15.utils.exceptions.*;
import java.util.ArrayList;

public class AjouterJoueurKOageInvalideMock implements IservicesJoueur {

    @Override
    public void creerJoueur(String prenom, String login, int anneeNaissance, int langue, String interets)
            throws PrenomInvalideException, LoginInvalideException, LoginDejaUtiliseException,
            AgeInvalideException, LangueException, CentresInteretsInvalideException {
        throw new AgeInvalideException();
    }

    @Override public ArrayList listerJoueurs() throws PasdeJoueursException { return null; }
    @Override public ArrayList fournirClassement() throws PasdeJoueursException { return null; }

    @Override
    public int conulterScore(String login) throws JoueurInconnuException {
        return 0;
    }

    @Override public void supprimerJoueur(String login) throws JoueurInconnuException {}
}