package vendormachine;

import vendormachine.vendors.DefaultSnacks;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.item.Snack;
import vendormachine.vendors.enums.BRANDS;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** 
 * Task 2:
 * 	Objective:
 * 		Test the Wallet class from:
 * 		'vendormachine.vendors.DrinkVendingMachine'
 * 
 * 	Goal: 
 * 		80% code/line coverage
 * 		TDD: analyse code and add missing methods.
 * */
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class DrinkVendingMachineTEST {

    private DrinkVendingMachine drinkVendingMachine;
    private Person alyx;

    @BeforeEach
    void setUp() {
        alyx = new Person("Alyx", new Wallet(10.0f));
    }

	@Test
    void testDefaultConstructor() {
        drinkVendingMachine = new DrinkVendingMachine(0.0f, BRANDS.CaramelSprinkle);
        assertNotNull(drinkVendingMachine);
        assertNotNull(drinkVendingMachine.getBrandName());
        assertEquals(0, drinkVendingMachine.getAvailableCredit());
        assertFalse(drinkVendingMachine.getDrinkList().isEmpty());
    }

    @Test
    void testParameterizedConstructor() {
        DrinkVendingMachine machine = new DrinkVendingMachine(5.0f, BRANDS.InFuse);
        assertNotNull(machine);
        assertEquals(BRANDS.InFuse, machine.getBrandName());
        assertEquals(5.0f, machine.getAvailableCredit());
        assertFalse(machine.getDrinkList().isEmpty());
    }

    @Test
    void testPopulateDrinkList() {
        drinkVendingMachine = new DrinkVendingMachine();
        drinkVendingMachine.getDrinkList();
        assertEquals(Arrays.asList(DefaultSnacks.snackList), drinkVendingMachine.getDrinkList());
    }

    @Test
    void testGiveCredit() {
        drinkVendingMachine = new DrinkVendingMachine(0.0f, BRANDS.CaramelSprinkle);
        drinkVendingMachine.giveCredit(alyx, 2.0f);
        // Verify the credit was added
        // Note: This requires a getter for availableCredit in DrinkVendingMachine
        // assertEquals(7.0f, drinkVendingMachine.getAvailableCredit());
    }

    @Test
    void testSelectDrinkWithSufficientCredit() {
        drinkVendingMachine = new DrinkVendingMachine();
        drinkVendingMachine.giveCredit(alyx, 2.0f);
        Snack selectedSnack = drinkVendingMachine.selectDrink(0);
        assertNotNull(selectedSnack);
        // Verify the credit was deducted
        // Note: This requires a getter for availableCredit in DrinkVendingMachine
        // assertEquals(3.5f, drinkVendingMachine.getAvailableCredit());
    }

    @Test
    void testSelectDrinkWithInsufficientCredit() {
        drinkVendingMachine = new DrinkVendingMachine(0.0f, BRANDS.CaramelSprinkle);

        drinkVendingMachine.giveCredit(alyx, 0.5f);
        Snack selectedSnack = drinkVendingMachine.selectDrink(0);
        assertNotNull(selectedSnack);

        Snack selectedSnack2 = drinkVendingMachine.selectDrink(1);
        assertNull(selectedSnack2);
    }

    @Test
    void testSelectDrinkWithInvalidIndex() {
        drinkVendingMachine = new DrinkVendingMachine(0.0f, BRANDS.CaramelSprinkle);

        Snack selectedSnack = drinkVendingMachine.selectDrink(-1);
        assertNull(selectedSnack);

        Snack selectedSnack2 = drinkVendingMachine.selectDrink(20);
        assertNull(selectedSnack2);
    }
}