package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private static Scanner myScanner = new Scanner(System.in);
	private static int inp;

	public static void menu() {
		System.out.println("Enter 1 for Requests");
		System.out.println("Enter 2 for Complaints");
	}

	public static int validateInput(int min, int max) {
		int input = -1;
		while (input < min || input > max) {
			try {
				input = myScanner.nextInt();

				if (input == -1) {
					break;
				}

				if (input < min || input > max) {
					System.out.println("Incorrect Input.. Please try again");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
				myScanner.next();
			}
		}
		return input;
	}
}
