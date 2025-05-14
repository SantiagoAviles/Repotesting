package tudelft.mirror;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MirrorTest {

    @Test
    public void testMirrorEnds1() {
        Mirror mirror = new Mirror();
        assertEquals("ab", mirror.mirrorEnds("abXYZba"));
    }

    @Test
    public void testMirrorEnds2() {
        Mirror mirror = new Mirror();
        assertEquals("a", mirror.mirrorEnds("abca"));
    }

    @Test
    public void testMirrorEnds3() {
        Mirror mirror = new Mirror();
        assertEquals("aba", mirror.mirrorEnds("aba"));
    }

    @Test
    public void testMirrorEndsEmpty() {
        Mirror mirror = new Mirror();
        assertEquals("", mirror.mirrorEnds(""));
    }

    @Test
    public void testMirrorEndsFull() {
        Mirror mirror = new Mirror();
        assertEquals("abcba", mirror.mirrorEnds("abcba"));
    }

    @Test
    public void testMirrorEndsNone() {
        Mirror mirror = new Mirror();
        assertEquals("", mirror.mirrorEnds("abcdef"));
    }
}
