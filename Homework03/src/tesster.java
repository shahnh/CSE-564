
public class tesster {

	public static void main(String[] args) {

		char[] vars = { 'a', 'b', 'c' };
		for (char var : vars)
			for (int i = 0; i < 5; i++) {
				System.out.println(i + " " + var);
			}
	}

}
