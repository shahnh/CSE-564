import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class JUnit {

	@Test
	void test() throws FileNotFoundException {
		P8.inputReadIn("tale.txt");
	}

}
