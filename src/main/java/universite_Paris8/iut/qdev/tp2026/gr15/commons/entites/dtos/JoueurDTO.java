package universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos;
import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.enums.LangueEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoueurDTO {
    private String prenom, pseudo;
    private LangueEnum langue;
    private int anneeNaissance, score;
    private List<String> interets;

    public JoueurDTO(String prenom, String pseudo, LangueEnum langue, int anneeNaissance, List<String> interets) {
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.langue = langue;
        this.anneeNaissance = anneeNaissance;
        this.score = 0;
        this.interets = interets;
    }

    public String getPseudo() { return pseudo; }

    public String getPrenom() { return prenom; }

    public LangueEnum getLangue() { return langue; }

    public int getAnneeNaissance() { return anneeNaissance; }

    public int getScore() { return score; }

    public List<String> getInterets() { return interets; }


    public boolean aCommeInteret(String interet) {
        return interets.stream().anyMatch(i -> i.equalsIgnoreCase(interet));
    }
}