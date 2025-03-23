package vendormachine;
import vendormachine.vendors.DefaultSnacks;
import vendormachine.vendors.item.Snack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DefaultSnacksTEST {

    @Test
    public void testSnackListNotNull() {
        assertNotNull(DefaultSnacks.snackList, "Snack list should not be null");
    }

    @Test
    public void testSnackListLength() {
        assertEquals(4, DefaultSnacks.snackList.length, "Snack list should contain 4 items");
    }

    @Test
    public void testSnackListContents() {
        Snack[] expectedSnacks = {
                new Snack("Water", 0.20f),
                new Snack("VanillaBurst", 1.75f),
                new Snack("GoblinSpring", 0.90f),
                new Snack("Comet Trails", 2.15f)
        };

        for (int i = 0; i < expectedSnacks.length; i++) {
            assertEquals(expectedSnacks[i].getName(), DefaultSnacks.snackList[i].getName(), "Snack name should match");
            assertEquals(expectedSnacks[i].getPrice(), DefaultSnacks.snackList[i].getPrice(), "Snack price should match");
        }
    }
}