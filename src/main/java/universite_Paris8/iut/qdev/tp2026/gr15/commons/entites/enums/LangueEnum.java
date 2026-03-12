package universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.enums;

import universite_Paris8.iut.qdev.tp2026.gr15.utils.exceptions.LangueException;

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

    public static LangueEnum fromId(int id) throws LangueException {
        for (LangueEnum l : values()) {
            if (l.id == id) return l;
        }
        throw new LangueException();
    }

    public String getNom() {
        return this.nom;
    }

    public int getId() {
        return this.id;
    }

}
