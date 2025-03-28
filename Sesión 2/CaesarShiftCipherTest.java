package tudelft.caesarshift;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarShiftCipherTest {
    @Test
    public void shiftForward() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        assertEquals("def", cipher.caesarShiftCipher("abc", 3));
    }
    @Test
    public void shiftBackward() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        assertEquals("xyz", cipher.caesarShiftCipher("abc", -3));
    }
    @Test
    public void wrapAround() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        assertEquals("abc", cipher.caesarShiftCipher("xyz", 3));
    }
    @Test
    public void spaceHandling() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        assertEquals("khoor zruog", cipher.caesarShiftCipher("hello world", 3));
    }
    @Test
    public void invalidCharacters() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        assertEquals("invalid", cipher.caesarShiftCipher("Hello", 3));
    }
    @Test
    public void nullMessage() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        assertEquals("invalid", cipher.caesarShiftCipher(null, 3));
    }
    @Test
    public void zeroShift() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        assertEquals("abc", cipher.caesarShiftCipher("abc", 0));
    }
    @Test
    public void largeShift() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        assertEquals("def", cipher.caesarShiftCipher("abc", 29)); // 29 ≡ 3 mod 26
    }
}