package universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.enums;

public enum LangueEnum {
    FRANCAIS("Français", 1),
    ENGLISH("English", 2),
    DEUTSCH("Deutsch", 3),
    ESPANOL("Español", 4),
    ITALIANO("Italiano", 5);

    private final String nom;
    private final int id;

    LangueEnum(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public int getId() {
        return this.id;
    }

}
