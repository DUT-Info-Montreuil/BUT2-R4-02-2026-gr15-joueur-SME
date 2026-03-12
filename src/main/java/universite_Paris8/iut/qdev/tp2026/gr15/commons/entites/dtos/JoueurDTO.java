package universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos;

public class JoueurDTO {
    private String prenom, pseudo,interets;
    private enum langue;
    private int anneNaissance, score;

    public JoueurDTO(String prenom, String pseudo, int langue, int anneNaissance, String interets) {
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.langue = langue;
        this.anneNaissance = anneNaissance;
        this.interets = interets;
        this.score = 0;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getInterets() {
        return interets;
    }

    public int getAnneNaissance() {
        return anneNaissance;
    }

    public int getScore() {
        return score;
    }

    public int getLangue() {
        return langue;
    }

    public String getPrenom() {
        return prenom;
    }
}
