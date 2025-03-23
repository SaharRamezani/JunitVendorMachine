package vendormachine;
import vendormachine.vendors.DefaultSnacks;
import vendormachine.vendors.item.Snack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefaultSnacksTEST {

    @Test
    public void testSnackListNotNull() {
        assertNotNull(DefaultSnacks.snackList, "Snack list should not be null");
    }

    @Test
    public void testClassInitialization() throws ClassNotFoundException {
        Class.forName("vendormachine.vendors.DefaultSnacks"); // Covers static block
    }

    @Test
    public void testSnackListLength() {
        assertEquals(4, DefaultSnacks.snackList.length, "Snack list should contain 4 items");
    }

    // @Test
    // public void testSnackListContents() {
    //     Snack[] expectedSnacks = {
    //             new Snack("Water", 0.20f),
    //             new Snack("VanillaBurst", 1.75f),
    //             new Snack("GoblinSpring", 0.90f),
    //             new Snack("Comet Trails", 2.15f)
    //     };

    //     for (int i = 0; i < expectedSnacks.length; i++) {
    //         assertEquals(expectedSnacks[i].getName(), DefaultSnacks.snackList[i].getName(), "Snack name should match");
    //         assertEquals(expectedSnacks[i].getPrice(), DefaultSnacks.snackList[i].getPrice(), "Snack price should match");
    //     }
    // }

    @Test
    public void testEachSnackInList() {
        for (Snack snack : DefaultSnacks.snackList) {
            assertNotNull(snack);
            assertNotNull(snack.getName());
            assertTrue(snack.getPrice() >= 0);
        }
    }

    @Test
    public void testSnackListContents() {
        new DefaultSnacks(); // Covers the private constructor
    }

    @Test
    public void testStaticInitializerExplicitly() {
        // Access each snack and assert their properties
        assertEquals("Water", DefaultSnacks.snackList[0].getName());
        assertEquals(0.20f, DefaultSnacks.snackList[0].getPrice());

        assertEquals("VanillaBurst", DefaultSnacks.snackList[1].getName());
        assertEquals(1.75f, DefaultSnacks.snackList[1].getPrice());

        assertEquals("GoblinSpring", DefaultSnacks.snackList[2].getName());
        assertEquals(0.90f, DefaultSnacks.snackList[2].getPrice());

        assertEquals("Comet Trails", DefaultSnacks.snackList[3].getName());
        assertEquals(2.15f, DefaultSnacks.snackList[3].getPrice());
    }
}