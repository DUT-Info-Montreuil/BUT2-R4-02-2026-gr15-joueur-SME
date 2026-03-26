package mocks;

import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr15.interfaces.IservicesJoueur;
import universite_Paris8.iut.qdev.tp2026.gr15.utils.exceptions.*;

import java.util.ArrayList;

public class ListerJoueursKoPasDeJoueur implements IservicesJoueur {
        @Override
        public void creerJoueur(String prenom, String login, int anneeNaissance, int langue, String interets)
                throws PrenomInvalideException, LoginInvalideException, LoginDejaUtiliseException,
                AgeInvalideException, LangueException, CentresInteretsInvalideException {
        }

        @Override
        public ArrayList<JoueurDTO> listerJoueurs() throws PasdeJoueursException {
            throw new PasdeJoueursException();
        }

        @Override
        public ArrayList<JoueurDTO> fournirClassement() throws PasdeJoueursException {
            return null;
        }

        @Override
        public int conulterScore(String login) throws JoueurInconnuException {
            return 0;
        }

        @Override
        public void supprimerJoueur(String login) throws JoueurInconnuException {
        }
    }

