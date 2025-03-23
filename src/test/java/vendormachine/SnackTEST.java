package vendormachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vendormachine.vendors.item.*;;

public class SnackTEST {

    private Snack snack;

    @BeforeEach
    public void setUp() {
        snack = new Snack("Chips", 1.50f);
    }

    @Test
    public void testCost() {
        assertEquals(1.50f, snack.cost());
    }

    @Test
    public void testSetValue() {
        snack.setValue(2.00f);
        assertEquals(2.00f, snack.cost());
    }

    @Test
    public void testConstructorWithName() {
        Snack snackWithName = new Snack("Chocolate", 2.50f);
        assertEquals("Chocolate", snackWithName.name);
        assertEquals(2.50f, snackWithName.cost());
    }

    @Test
    public void testConstructorWithoutName() {
        Snack snackWithoutName = new Snack(1.00f);
        assertEquals(1.00f, snackWithoutName.cost());
    }
}