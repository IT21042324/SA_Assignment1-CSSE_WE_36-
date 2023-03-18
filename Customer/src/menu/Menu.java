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

	public static void reqMenu() {
		System.out.println("\nEnter 1 to make new request");
		System.out.println("Enter 2 to view request status");

	}

	public static void compMenu() {
		System.out.println("\nEnter 1 to make complaint");
		System.out.println("Enter 2 to view complaints");

	}

	public static int validateInput(int min, int max) {
		int input = -1;
		while (input < min || input > max) {
			try {
				System.out.print("Your choice: ");
				input = myScanner.nextInt();
				if (input < min || input > max) {
					System.out.println("Incorrect Input.. Please try again\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter an integer value.\n");
				myScanner.next();
			}
		}
		return input;
	}
}
