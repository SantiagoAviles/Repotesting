package tudelft.sum;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TwoNumbersSumTest {

    @Test
    public void testSimpleAddition() {
        TwoNumbersSum sum = new TwoNumbersSum();
        ArrayList<Integer> result = sum.addTwoNumbers(
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(3, 4))
        );
        assertEquals(Arrays.asList(4, 6), result);
    }

    @Test
    public void testWithCarry() {
        TwoNumbersSum sum = new TwoNumbersSum();
        ArrayList<Integer> result = sum.addTwoNumbers(
                new ArrayList<>(Arrays.asList(9)),
                new ArrayList<>(Arrays.asList(9))
        );
        assertEquals(Arrays.asList(1, 8), result);
    }

    @Test
    public void testDifferentSizes() {
        TwoNumbersSum sum = new TwoNumbersSum();
        ArrayList<Integer> result = sum.addTwoNumbers(
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(9))
        );
        assertEquals(Arrays.asList(1, 3, 2), result);
    }

    @Test
    public void testFinalCarryPropagation() {
        TwoNumbersSum sum = new TwoNumbersSum();
        ArrayList<Integer> result = sum.addTwoNumbers(
                new ArrayList<>(Arrays.asList(9, 9)),
                new ArrayList<>(Arrays.asList(1))
        );
        assertEquals(Arrays.asList(1, 0, 0), result);
    }
}

