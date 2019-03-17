package djava.collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import djava.MainClass;

public class MainClassTest {

	@Test
	public void testMainClass() {
		MainClass mc = new MainClass();
		assertNotNull(mc);
	}

}
