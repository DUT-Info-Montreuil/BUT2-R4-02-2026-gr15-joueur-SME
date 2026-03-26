package universite_Paris8.iut.qdev.tp2026.gr15;

import mocks.*;
import org.junit.jupiter.api.Test;
import universite_Paris8.iut.qdev.tp2026.gr15.commons.entites.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr15.interfaces.IservicesJoueur;
import universite_Paris8.iut.qdev.tp2026.gr15.utils.exceptions.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {


    /**
     * Rigorous Test :-)
     */

    /**
     * Prénom null → PrenomInvalideException attendue.
     */
    @Test
    public void creerJoueur_prenomNull_levePrenomInvalideException() {
        IservicesJoueur serviceJoueur = new AjouterJoueurKOprenomnull();
        assertThrows(PrenomInvalideException.class, () ->
                serviceJoueur.creerJoueur(null, "alice99", 2000, 1, "sport")
        );
    }

    @Test
    public void testCreerJoueurLoginCommencantParChiffre() {
        IservicesJoueur serviceJoueur = new AjouterJoueurKoLoginInvalide();
        assertThrows(
                LoginInvalideException.class,
                () -> serviceJoueur.creerJoueur("Alice", "1alice", 2005, 2, "lecture, sortie")
        );
    }

    @Test
    public void testCreerJoueurLoginValideAucuneException() {
        IservicesJoueur service = new AjouterJoueurLoginValide();
        assertDoesNotThrow(
                () -> service.creerJoueur("Louise", "louise1803", 2005, 3, "melina")
        );
    }

    @Test
    public void testCreerJoueurLoginExistant(){
        IservicesJoueur service = new AjouterJoueurKoLoginExistant();
        assertThrows(
                LoginDejaUtiliseException.class,
                () -> service.creerJoueur("Melina", "melinaaa", 2006, 1, "manger, dormir")
        );
    }

    @Test
    public void testCreerJoueurAgeNegatif(){
        IservicesJoueur service = new AjouterJoueurKoAgeInvalide();
        assertThrows(
                AgeInvalideException.class,
                () -> service.creerJoueur("Kurtys", "sukali", -15, 1, "lire, dormir")
        );
    }

    @Test
    public void testCreerJoueurLangueSuperieureA5(){
        IservicesJoueur service = new AjouterJoueurKoLangueInvalide();
        assertThrows(
                LangueException.class,
                () -> service.creerJoueur("Kurtys", "sukali", 2005, 6, "lire, dormir")
        );
    }

    @Test
    public void testCreerJoueurLangueInferieurA1(){
        IservicesJoueur service = new AjouterJoueurKoLangueInvalide();
        assertThrows(
                LangueException.class,
                () -> service.creerJoueur("Kurtys", "sukali", 2005, 0, "lire, dormir")
        );
    }

    @Test
    public void testCreerJoueurInteretsPasChaineCaracteres(){
        IservicesJoueur service = new AjouterJoueurKoInteretsInvalide();
        assertThrows(
                CentresInteretsInvalideException.class,
                () -> service.creerJoueur("Kurtys", "sukali", 2005, 2, "l")
        );
    }

    @Test
    public void testCreerJoueurInteretsChiffres(){
        IservicesJoueur service = new AjouterJoueurKoInteretsInvalide();
        assertThrows(
                CentresInteretsInvalideException.class,
                () -> service.creerJoueur("Kurtys", "sukali", 2005, 2, "123")
        );
    }

    @Test
    public void testListerJoueursAucunJoueur() {
        IservicesJoueur service = new ListerJoueursKoPasDeJoueur();
        assertThrows(
                PasdeJoueursException.class,
                () -> service.listerJoueurs()
        );
    }

    @Test
    public void testListerJoueur() throws PasdeJoueursException {
        IservicesJoueur service = new ListerJoueursOk();

        ArrayList<JoueurDTO> joueurs = service.listerJoueurs();

        assertNotNull(joueurs);
        assertFalse(joueurs.isEmpty());
        assertEquals(2, joueurs.size());
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


}
