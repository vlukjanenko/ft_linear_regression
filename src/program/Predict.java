package program;

import java.io.File;
import java.util.Scanner;

public class Predict {
	public static void main(String args[]) {
		Scanner scanner = null;
		double milage = 0;
		double theta0 = 0;
		double theta1 = 0;
		int scale = 1000;
		try {
			scanner = new Scanner(new File("thetas.txt"));
			String line = scanner.nextLine();
			theta0 = Double.parseDouble(line.split(",")[0]);
			theta1 = Double.parseDouble(line.split(",")[1]);
		} catch (Exception e) {
			theta0 = 0;
			theta1 = 0;
		}
		if (scanner != null)
			scanner.close();
		scanner = new Scanner(System.in);
		System.out.print("Input milage: ");
		try {
			milage = Double.parseDouble(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("Invalid value");
			System.exit(1);
		}
		System.out.printf("Predicted price: %d$\n",
				(int)((theta0 + theta1 * milage / scale) * scale));
	}
}
