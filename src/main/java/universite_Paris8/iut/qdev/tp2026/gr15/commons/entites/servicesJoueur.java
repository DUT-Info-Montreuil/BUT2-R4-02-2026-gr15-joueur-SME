package universite_Paris8.iut.qdev.tp2026.gr15.commons.entites;

import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.enums.LangueEnum;
import universite_Paris8.iut.qdev.tp2026.gr15.interfaces.IservicesJoueur;
import universite_Paris8.iut.qdev.tp2026.gr15.utils.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class servicesJoueur implements IservicesJoueur {
    @Override
    public void creerJoueur(String prenom, String login, int anneeNaissance, int langue, String interet) throws PrenomInvalideException, LoginInvalideException, LoginDejaUtiliseException, AgeInvalideException, LangueException, CentresInteretsInvalideException {
        try {
            LangueEnum l = LangueEnum.fromId(langue);
        } catch (Exception e) {
            throw new LangueException();
        }

        List<String> interets= Arrays.stream(interet.split(",")).map(String::trim).collect(Collectors.toList());
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() throws PasdeJoueursException {
        return null;
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
