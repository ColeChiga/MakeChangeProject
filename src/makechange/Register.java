package makechange;

import java.util.Scanner;

public class Register {

	public static void main(String[] args) {
		// PROMPT: In the cash register we will calculate the amount of
		// change returned to a customer based on the purchase price and
		// the amount tendered. We will also notify the attendant how many
		// of each type of currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c,
		// .01c) is needed to make the change for the customer.
		//
		// Change will be provided using a combination of the largest
		// bill and coin denominations as possible.
		//
		// Denominations that are not used will not be displayed.

		// declare variables and scanner.
		// note: I used float in place of double because I wanted practice with using
		// different data types and casting
		Scanner sc = new Scanner(System.in);
		float changeAmt;
		int numberUsed;

		// 1) The user is prompted asking for the price of the item.
		System.out.print("What is the price of the item you are attempting to purchase? $");
		float objectPrice = sc.nextFloat();

		// 2) The user is then prompted asking how much money was tendered by the
		// customer
		System.out.print("How much money was used to purchase this item? $");
		float moneyUsed = sc.nextFloat();

		// 3) Display an appropriate message if the customer provided too little
		// money
		if (moneyUsed < objectPrice) {
			System.err.print("I'm sorry, that is not enough to cover this purchase.");
		} else if (moneyUsed == objectPrice) {

			// or the exact amount.
			System.out.println("You paid with exact change.\nThank you, come again!");
		} else {

			// 4) If the amount tendered is more than the cost of the item,
			// display the number of bills and coins that should be given to
			// the customer. Denominations that are not used will not be displayed.
			changeAmt = (float) (moneyUsed - objectPrice + 0.00001); // due to data loss from float/doubles, a
																		// correction of 0.00001********************************************************************************************
			System.out.printf("the change you are owed is: $%.2f.%n", changeAmt); // calculate and show how much is owed to the second decimal point

			float denomination;
			System.out.print("You are owed: ");

			// Loops the calculation for how much is owed. loops once for each possible
			// denomination
			for (int i = 0; i <= 7; i++) {
				numberUsed = 0;
				denomination = denType(i); // calls a method that determines which denomination should be used

				// if statement determines if change in a certain denomination is due,
				// then calculates the number of that denomination that is due back
				// and changes the amount due back
				if (changeAmt >= denomination) {

					numberUsed = (int) (changeAmt / denomination);

					changeAmt = (float) (changeAmt % denomination);

					// outputs the value number of each denomination used ex: 1 ten dollar bill
					System.out.print(numberUsed + " ");
					System.out.print(billType(i));
					if (numberUsed > 1 || i == 7) {

						if (numberUsed > 1 && i == 7) {
							System.out.print("ies"); // if else statement for penny vs pennies
						} else if (i == 7) {
							System.out.print("y");
						} else {
							System.out.print("s"); // adds an 's' if more than one bill/coin is used
						}
					}
					if (changeAmt > .005) {
						System.out.print(", "); // prints a comma and space to separate the
					} // denominations except when no change remains
				}
			}
			System.out.println(". \nThank you, come again!");
		}
		sc.close();
	}

	// method used to determine what denomination is used to calculate,
	// requires the value from the for loop to run through a switch to determine
	// denomination
	// returns a floating value
	public static float denType(int i) {
		float money;

		switch (i) {
		case 0:
			money = 20;
			break;
		case 1:
			money = 10;
			break;
		case 2:
			money = 5;
			break;
		case 3:
			money = 1;
			break;
		case 4:
			money = .25f;
			break;
		case 5:
			money = .1f;
			break;
		case 6:
			money = .05f;
			break;
		case 7:
			money = 0.01f;
			break;
		default:
			money = -1;

		}

		return money;
	}

	// method used to determine what denomination is output
	// requires the value from the for loop to determine what bill/coin is needed
	// returns a string value
	public static String billType(int i) {
		String money;
		switch (i) {
		case 0:
			money = "twenty dollar bill";
			break;
		case 1:
			money = "ten dollar bill";
			break;
		case 2:
			money = "five dollar bill";
			break;
		case 3:
			money = "one dollar bill";
			break;
		case 4:
			money = "quarter";
			break;
		case 5:
			money = "dime";
			break;
		case 6:
			money = "nickel";
			break;
		case 7:
			money = "penn";
			break;
		default:
			money = "error";
		}
		return money;
	}
}
