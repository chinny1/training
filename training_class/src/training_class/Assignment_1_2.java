package training_class;

import java.util.Scanner;

public class Assignment_1_2 {

	// TO DO:
	// - test out error messages when choosing out of bounds points

	public void side() {
		// action: just some random code
		System.out.println("make some noise");

	}

	public int getTop(int pot) {
		// action retrieves the high range

		if (pot % 2 == 0) {
			// action: means the number is even in which case we just devide is
			// by 2
			pot /= 2;

		} else {
			// action: means the number is odd so we have to use below formula
			pot = (pot - 1) / 2;

		}

		return pot;

	}

	public int addPoint(int starting, int points) {
		// action: add points to current players total; might not use
		starting += points;

		return starting;
	}

	public void merryGR(String p1, String p2, int p1p, int p2p, int turn,
			int tnc) { // merry go round phrases
		// action give standard status of player points, current turn and ask
		// how many
		// points the next player wants

		// p1: name of player 1
		// p2: .............. 2
		// p1p: player 1 points
		// p2p: player 2 points
		// tnc: total number of chips

		System.out.println(p1 + " has " + p1p + " chips. ");
		System.out.println(p2 + " has " + p2p + " chips. ");

		String currP = "";// name of current player

		if (turn == 1) {

			currP = p1;
			System.out.println("It is your turn, " + p1);

		} else if (turn == 2) {

			currP = p2;
			System.out.println("It is your turn, " + p2);

		}

		System.out.println("There are " + tnc + " chips remaining.");
		// You may take any number of chips from 1 to 11. How many will you
		// take, Emily? 7

		int topNum = this.getTop(tnc);// upper bound of the range of coins
										// player can choose

		if (topNum + 1 == 2) {

			System.out
					.println("You may take any number of chips from 1 to 1.  How many will you take, "
							+ currP + " ?");

		} else if (topNum + 1 == 1) {

			System.out.println("How many will you take, " + currP + " ?");

		} else if (topNum + 1 == 0) {

			// if ( p1p % 2 == 0){
			//
			// System.out.println( p1 +" wins !");
			//
			// }else{
			//
			// System.out.println( p2 +" wins !");
			//
			// }

		} else {

			System.out.println("You may take any number of chips from 1 to "
					+ topNum + ".  How many will you take, " + currP + " ?");
		}

		// ... outside of this function, the player should now be allowed to
		// choose.

	}

	public static void main(String args[]) {

		Assignment_1_2 mep = new Assignment_1_2();

		int gameState = 0; // 0 = new game; 1= active game; 2 = stop game ;

		int noc = 0; // noc is "number of chips" at a give time

		String firstP = "";

		String secondP = "";

		int fPoint = 0;// first players points;

		int sPoint = 0; // second players points

		int currChoice = 0; // the number of points a player chooses to take
							// from the "noc" basket

		int turn = 1; // keeps the state of whose turn it is; initially player
						// 1's turn

		Scanner scan = new Scanner(System.in);

		while (gameState >= 0 && gameState < 2) {

			if (gameState == 0) {

				firstP = "";

				secondP = "";

				fPoint = 0;// first players points;

				sPoint = 0; // second players points

				currChoice = 0; // the number of points a player chooses to take
								// from the "noc" basket

				turn = 1; // keeps the state of whose turn it is; initially
							// player 1's turn

				gameState = 1;
			}

			// action: loop runs while number of chips is greater than 0

			while (firstP.length() == 0) {
				// waits to get first player name
				System.out.println("What is the name of the first player?");
				firstP = scan.next();
			}

			while (secondP.length() == 0 || secondP.equalsIgnoreCase(firstP)) {

				// action: waits to get second players name

				if (secondP.equalsIgnoreCase(firstP)) {

					// action:should be case sensitive, but doesn't seem to be
					// working

					System.out.println("Both players cannot be named "
							+ secondP + ".  Enter a different name:");

				} else {

					System.out.println("What is the name of the second player");

				}

				secondP = scan.next();
			}

			while (noc == 0) {

				// action: gets the size of the pile
				System.out
						.println("How many chips does the initial pile contain?");
				noc = scan.nextInt();
			}

			// action: gives players points and totals points left to receive
			mep.merryGR(firstP, secondP, fPoint, sPoint, turn, noc);

			int flip = 0;// uses as a toggle to allow for escaping a loop

			while (flip == 0) {

				// System.out.println("internal: asking for number again");
				currChoice = scan.nextInt();

				// action: scan in number from player and if number is out of
				// bound give message

				int lowBound = 1;
				int highBound = mep.getTop(noc);

				// action: pseudo method retrieves current player
				String currP = "";// name of current player

				if (turn == 1) {

					currP = firstP;

				} else if (turn == 2) {

					currP = secondP;

				}

				if ((currChoice < lowBound || currChoice > highBound)
						&& highBound != 0) {
					// action: for illegal move
					// System.out.println("enter bound conditional");

					if (currChoice < lowBound) {
						// action: for choosing too low
						System.out
								.println("Illegal move: you must take at least one chip.");
						System.out.println("How many will you take, " + currP
								+ "?");

					} else if (currChoice > highBound) {
						// action: for choosing too high
						System.out
								.println("Illegal move: you may not take more than "
										+ highBound + " chips. ");
						System.out.println("How many will you take, " + currP
								+ "?");
					}

				} else {

					// action: correct choise;remove number of chips taken by
					// player from pile
					flip = 1;
					noc -= currChoice;

				}

			}

			// Learned: switch case I used actually evaluates the second case
			// after updating turn to 2 - even just after evaluating first case.
			// action: toggles between turns
			// switch (turn){
			//
			// case 1: //person 1's turn
			// fPoint += currChoice;
			// turn = 2;
			// //System.out.println();
			// break;
			// case 2: // person 2's turn
			// sPoint += currChoice;
			// turn = 1;
			// break;
			//
			// }// closes the switch

			if (turn == 1) {
				fPoint += currChoice;
				turn = 2;

			} else if (turn == 2) {
				sPoint += currChoice;
				turn = 1;

			}

			if (noc == 0 && gameState == 1) {
				// action: when the game has a winner
				// -change game state
				// - ask users if they want to play again

				if (fPoint % 2 == 0) {

					System.out.println(firstP + " wins !");

				} else {

					System.out.println(secondP + " wins !");

				}

				System.out.println("Play another game? (y/n) ");
				String ans = scan.next();

				if (ans.equals("y")) {

					gameState = 0;

				} else if (ans.equals("n")) {

					gameState = 2;
				}

			}

		}// closes the while loop

	}

}// closes the class

