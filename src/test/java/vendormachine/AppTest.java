package vendormachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.item.Snack;

public class AppTest {

	private Person alyx;
	private DrinkVendingMachine drinkMachine;

	@BeforeEach
	public void setUp() {
		alyx = new Person("Alyx", new Wallet(10.0f));
		drinkMachine = new DrinkVendingMachine();
	}

	@Test
	public void testGiveCredit() {
		drinkMachine.giveCredit(alyx, 2.10f);
		assertEquals(2.10f, drinkMachine.getAvailableCredit(), 0.01f);
	}

	@Test
	public void testSelectDrink() {
		drinkMachine.giveCredit(alyx, 2.15f);
		Snack itemSelection = drinkMachine.selectDrink(1);
		assertNotNull(itemSelection);
		assertEquals("Comet Trails", itemSelection.name); // Replace with actual expected name
		assertEquals(0.0f, itemSelection.cost(), 0.01f); // Replace with actual expected cost
	}

	@Test
	public void testPersonWalletAfterTransaction() {
		drinkMachine.giveCredit(alyx, 2.10f);
		drinkMachine.selectDrink(1);
		assertEquals(7.90f, alyx.getWallet().getBalance(), 0.01f);
	}
}