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
        IservicesJoueur serviceJoueur = new AjouterJoueurKOprenomnullMock();
        assertThrows(PrenomInvalideException.class, () ->
                serviceJoueur.creerJoueur(null, "alice99", 2000, 1, "sport")
        );
    }

    @Test
    public void creerJoueur_prenomValide_aucuneException() {
        IservicesJoueur serviceJoueur = new AjouterJoueurOKImplMock();
        assertDoesNotThrow(() ->
                serviceJoueur.creerJoueur("Alice", "alice99", 2000, 1, "sport,musique")
        );
    }

    @Test
    public void creerJoueur_prenomInvalide_levePrenomInvalideException() {
        IservicesJoueur serviceJoueur = new AjouterJoueurKOjoueurCommenceParChiffreMock();
        assertThrows(PrenomInvalideException.class, () ->
                serviceJoueur.creerJoueur("1Alice", "alice99", 2000, 1, "sport")
        );
    }

    @Test
    public void creerJoueur_loginInvalide_leveLoginInvalideException() {
        IservicesJoueur serviceJoueur = new AjouterJoueurKOloginInvalideMock();
        assertThrows(LoginInvalideException.class, () ->
                serviceJoueur.creerJoueur("Alice", "!invalid", 2000, 1, "sport")
        );
    }

    @Test
    public void creerJoueur_loginDejaUtilise_leveLoginDejaUtiliseException() {
        IservicesJoueur serviceJoueur = new AjouterJoueurKOloginDejaPrisMock();
        assertThrows(LoginDejaUtiliseException.class, () ->
                serviceJoueur.creerJoueur("Alice", "alice99", 2000, 1, "sport")
        );
    }

    @Test
    public void creerJoueur_ageInvalide_leveAgeInvalideException() {
        IservicesJoueur serviceJoueur = new AjouterJoueurKOageInvalideMock();
        assertThrows(AgeInvalideException.class, () ->
                serviceJoueur.creerJoueur("Alice", "alice99", 1800, 1, "sport")
        );
    }

    @Test
    public void creerJoueur_langueInvalide_leveLangueException() {
        IservicesJoueur serviceJoueur = new AjouterJoueurKOlangueInvalideMock();
        assertThrows(LangueException.class, () ->
                serviceJoueur.creerJoueur("Alice", "alice99", 2000, 99, "sport")
        );
    }

    @Test
    public void creerJoueur_interetsInvalides_leveCentresInteretsInvalideException() {
        IservicesJoueur serviceJoueur = new AjouterJoueurKOcentreInvalideMock();
        assertThrows(CentresInteretsInvalideException.class, () ->
                serviceJoueur.creerJoueur("Alice", "alice99", 2000, 1, "")
        );
    }

    @Test
    public void listerJoueurs_joueursExistants_retourneListe() throws PasdeJoueursException {
        IservicesJoueur serviceJoueur = new ListerJoueursOKImplMock();
        ArrayList<JoueurDTO> result = serviceJoueur.listerJoueurs();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void listerJoueurs_aucunJoueur_levePasDeJoueursException() {
        IservicesJoueur serviceJoueur = new ListerJoueursKOImplMock();
        assertThrows(PasdeJoueursException.class, () ->
                serviceJoueur.listerJoueurs()
        );
    }






    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
