package universite_Paris8.iut.qdev.tp2026.gr15;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import mocks.AjouterJoueurKOprenomnull;
import org.junit.jupiter.api.Test;
import universite_Paris8.iut.qdev.tp2026.gr15.interfaces.IservicesJoueur;
import universite_Paris8.iut.qdev.tp2026.gr15.utils.exceptions.PrenomInvalideException;

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
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
