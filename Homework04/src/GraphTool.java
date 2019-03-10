
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphTool {

	public static void main(String[] args) throws FileNotFoundException {
		
		File inFile = new File("output.txt"); 
		Scanner in = new Scanner(inFile); 
		while(in.hasNextLine())
			System.out.println(in.nextLine());
	}

	
	
}
