package vendormachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendormachine.users.util.Wallet;

public class WalletTEST {
	
	/** 
	 * Task 1:
	 * 	Objective:
	 * 		Test the Wallet class from:
	 * 		'vendormachine.users.util.Wallet'
	 * 
	 * 		Goal: 80% code/line coverage
	 * */
	
	// Hint: 
	// Others Tests for other classes that use Wallet may impact code coverage
	// Avoid relying on these tests, one test for one class; keep "Single Responsibility" in mind.
	
    private Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals("Generic", wallet.getBrand(null));
        assertEquals(0.5f, wallet.getAllCredit());
    }

    @Test
    public void testConstructorWithStartCredit() {
        Wallet walletWithCredit = new Wallet(10.0f);
        assertEquals("Generic", walletWithCredit.getBrand(null));
        assertEquals(10.0f, walletWithCredit.getAllCredit());
    }

    @Test
    public void testConstructorWithBrandAndStartCredit() {
        Wallet walletWithBrandAndCredit = new Wallet("BrandX", 20.0f);
        assertEquals("BrandX", walletWithBrandAndCredit.getBrand(null));
        assertEquals(20.0f, walletWithBrandAndCredit.getAllCredit());
    }

    @Test
    public void testAddCredit() {
        wallet.addCredit(5.0f);
        assertEquals(5.5f, wallet.getAllCredit());
    }

    @Test
    public void testGetCredit() {
        float retrieved = wallet.getCredit(0.3f);
        assertEquals(0.3f, retrieved);
        assertEquals(0.2f, wallet.getAllCredit());
    }

    @Test
    public void testGetCreditExceedsStoredValue() {
        float retrieved = wallet.getCredit(1.0f);
        assertEquals(0.0f, retrieved);
        assertEquals(0.5f, wallet.getAllCredit());
    }

    @Test
    public void testSetCredit() {
        wallet.setCredit(15.0f);
        assertEquals(15.0f, wallet.getAllCredit());
    }

    @Test
    public void testSetBrand() {
        wallet.setBrand("BrandY");
        assertEquals("BrandY", wallet.getBrand(null));
    }
}
