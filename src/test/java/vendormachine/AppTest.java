package vendormachine;

import org.junit.jupiter.api.Test;
import vendormachine.runner.*;;

public class AppTest {

	@Test
	public void MainTest() {
		App.main(null);
	}

	@Test
	public void testAppConstructor() {
		new App(); // covers the implicit constructor
	}
}