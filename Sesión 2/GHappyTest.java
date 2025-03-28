package tudelft.ghappy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GHappyTest {
    @Test
    public void singleG() {
        GHappy checker = new GHappy();
        assertFalse(checker.gHappy("g")); // Debe retornar false, no lanzar excepción
    }
    @Test
    public void happyStart() {
        GHappy checker = new GHappy();
        assertTrue(checker.gHappy("ggx")); // 'g's al inicio
    }
    @Test
    public void lonelyMiddleG() {
        GHappy checker = new GHappy();
        assertFalse(checker.gHappy("xxgxx")); // 'g' solitario
    }
    @Test
    public void allHappy() {
        GHappy checker = new GHappy();
        assertTrue(checker.gHappy("xxggxx")); // Todos felices
    }
    @Test
    public void unhappyEnd() {
        GHappy checker = new GHappy();
        assertFalse(checker.gHappy("xxggyyg")); // 'g' solitario al final
    }
    @Test
    public void noG() {
        GHappy checker = new GHappy();
        assertTrue(checker.gHappy("xyz")); // Sin 'g's
    }
    @Test
    public void multipleGroups() {
        GHappy checker = new GHappy();
        assertFalse(checker.gHappy("ggxxggyg")); // Grupo con 'g' solitario
    }
}