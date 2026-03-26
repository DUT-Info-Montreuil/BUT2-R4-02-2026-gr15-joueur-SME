package universite_Paris8.iut.qdev.tp2026.gr15.service.impl;

import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos.GestionJoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.enums.LangueEnum;
import universite_Paris8.iut.qdev.tp2026.gr15.service.interfaces.IservicesJoueur;
import universite_Paris8.iut.qdev.tp2026.gr15.utils.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class serviceJoueurImpl implements IservicesJoueur {

    private GestionJoueurDTO gestionJoueur;

    public serviceJoueurImpl() {
        this.gestionJoueur = GestionJoueurDTO.getInstance();
    }
    @Override
    public void creerJoueur(String prenom, String login, int langue,int anneeNaissance, String interet) throws PrenomInvalideException, LoginInvalideException, LoginDejaUtiliseException, AgeInvalideException, LangueException, CentresInteretsInvalideException {

        if (prenom.isEmpty()){
            throw new PrenomInvalideException();
        }
        if (login.isEmpty() || Character.isDigit(login.charAt(0))) {
            throw new LoginInvalideException();
        }
        for (JoueurDTO j : gestionJoueur.getJoueurs()) {
            if (j.getPseudo().equalsIgnoreCase(login)) {
                throw new LoginDejaUtiliseException();
            }
        }
        if (anneeNaissance <= 0) {
            throw new AgeInvalideException();
        }
        if (langue>5 || langue<1){
            throw new LangueException();
        }
        LangueEnum l = LangueEnum.fromId(langue);
        if (interet == null || interet.trim().isEmpty() || interet.trim().endsWith(",")) {
            throw new CentresInteretsInvalideException();
        }
        List<String> interets= Arrays.stream(interet.split(",")).map(String::trim).collect(Collectors.toList());

        gestionJoueur.addJoueur(new JoueurDTO(prenom,login,l,anneeNaissance,interets));
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() throws PasdeJoueursException {
        if (gestionJoueur.getJoueurs().isEmpty()) {
            throw new PasdeJoueursException();
        }
        return gestionJoueur.getJoueurs();
    }

    @Override
    public ArrayList<JoueurDTO> fournirClassement() throws PasdeJoueursException {
        if (gestionJoueur.getJoueurs().isEmpty()) {
            throw new PasdeJoueursException();
        }
        ArrayList<JoueurDTO> classement = new ArrayList<>(gestionJoueur.getJoueurs());

        classement.sort((j1, j2) -> {
            int compareScore = Integer.compare(j2.getScore(), j1.getScore());

            if (compareScore != 0) {
                return compareScore;
            }

            return j1.getPseudo().compareToIgnoreCase(j2.getPseudo());
        });

        return classement;

    }

    @Override
    public int conulterScore(String login) throws JoueurInconnuException {

        for (JoueurDTO j : gestionJoueur.getJoueurs()) {
            if (j.getPseudo().equalsIgnoreCase(login)) {
                return j.getScore();
            }
        }

        throw new JoueurInconnuException();
    }

    @Override
    public boolean supprimerJoueur(String login) throws JoueurInconnuException {
        for (JoueurDTO j : gestionJoueur.getJoueurs()) {
            if (j.getPseudo().equals(login)) {
                gestionJoueur.getJoueurs().remove(j);
                return true;
            }
        }
        throw new JoueurInconnuException();
    }
}
