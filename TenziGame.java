import java.util.ArrayList;
import java.util.Scanner;

public class TenziGame {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		TenziPlayer p = new TenziPlayer();
		int round = 1;
		System.out.print("Would you like to play against a computer? (Y/N): ");
		String comp = input.nextLine().toLowerCase();
		if (comp.equals("y")) {
			computer();
		}
		else if (comp.equals("n")) {
			System.out.print("Would you like to play multiplayer? (Y/N): ");
			String playerAns = input.nextLine().toLowerCase();
			if (playerAns.equals("y")) {
				multiplayer();
			}
			else if (playerAns.equals("n")){
		System.out.println("         TENZI!");
		System.out.println("\n------ Round #" + round + "-------");
		round++;
		p.roll();
		p.print();
		System.out.print("Which number would you like to collect?: ");
		int target = input.nextInt();
		input.nextLine();
		p.setTargetNum(target);
		p.removeTargetDice();
		System.out.println("Left with:");
		p.print();
		System.out.println("Press Enter to Roll again");
		input.nextLine();
		// Keep rolling and printing until player is done

		while (!p.done()) {

			// Print round number
			// Roll and print result
			// remove target number
			// print again
			// prompt to press enter
			// wait for enter with input.nextLine();

			System.out.println("\n------ Round #" + round + "-------");
			p.roll();
			System.out.println("Rolled: ");
			p.print();
			p.removeTargetDice();
			System.out.println("Left with:");
			p.print();
			System.out.println("Press Enter to Roll again");
			input.nextLine();
			p.roll();
			round++;
		}
			}
		}
		// print win message with number of rounds
		Boolean play = true;
		while (play == true) {
			System.out.print("Would you like to play again?(Y/N): ");
			String again = input.nextLine().toLowerCase();
			if (again.equals("n")) {
				System.out.println("Thanks for playing!");
				break;
			}
			playAgain();
		}

	}

	public static void playAgain() {

		Scanner input = new Scanner(System.in);
		TenziPlayer p = new TenziPlayer();
		int round = 1;
		System.out.print("Would you like to play against a computer? (Y/N): ");
		String comp = input.nextLine().toLowerCase();
		if (comp.equals("y")) {
			computer();
		}
		else if (comp.equals("n")) {
			System.out.print("Would you like to play multiplayer? (Y/N): ");
			String playerAns = input.nextLine().toLowerCase();
			if (playerAns.equals("y")) {
				multiplayer();
			}
			else if (playerAns.equals("n")){
		System.out.println("         TENZI!");
		System.out.println("\n------ Round #" + round + "-------");
		round++;
		p.roll();
		p.print();
		System.out.print("Which number would you like to collect?: ");
		int target = input.nextInt();
		input.nextLine();
		p.setTargetNum(target);
		p.removeTargetDice();
		System.out.println("Left with:");
		p.print();
		System.out.println("Press Enter to Roll again");
		input.nextLine();
		// Keep rolling and printing until player is done

		while (!p.done()) {

			// Print round number
			// Roll and print result
			// remove target number
			// print again
			// prompt to press enter
			// wait for enter with input.nextLine();

			System.out.println("\n------ Round #" + round + "-------");
			p.roll();
			System.out.println("Rolled: ");
			p.print();
			p.removeTargetDice();
			System.out.println("Left with:");
			p.print();
			System.out.println("Press Enter to Roll again");
			input.nextLine();
			p.roll();
			round++;
			}
	}
}
}

	public static void computer() {
		Scanner input = new Scanner(System.in);
		TenziPlayer p = new TenziPlayer();
		TenziPlayer c = new TenziPlayer();
		int round = 1;
		System.out.println("         TENZI!");
		System.out.println("\n------ Round #" + round + "-------");
		round++;
		p.roll();
		c.roll();
		System.out.print("Your roll: ");
		p.print();
		System.out.print("Computer roll: ");
		c.print();
		System.out.print("Which number would you like to collect?: ");
		int target = input.nextInt();
		input.nextLine();
		int compTarget = c.CompTargetNum();
		p.setTargetNum(target);
		c.setTargetNum(compTarget);
		System.out.print("You have ");
		p.removeTargetDice();
		System.out.print("Computer has ");
		c.removeTargetDice();
		System.out.print("You are left with: ");
		p.print();
		System.out.print("Computer is left with: ");
		c.print();
		System.out.println("Press Enter to Roll again");
		input.nextLine();
		// Keep rolling and printing until player is done

		while (!p.done() && !c.done()) {

			// Print round number
			// Roll and print result
			// remove target number
			// print again
			// prompt to press enter
			// wait for enter with input.nextLine();

			System.out.println("\n------ Round #" + round + "-------");
			p.roll();
			c.roll();
			System.out.print("You rolled: ");
			p.print();
			System.out.print("Computer rolled: ");
			c.print();
			System.out.print("You have ");
			p.removeTargetDice();
			System.out.print("Computer has ");
			c.removeTargetDice();
			System.out.println("You are left with:");
			p.print();
			System.out.println("Computer is left with:");
			c.print();
			System.out.println("Press Enter to Roll again");
			input.nextLine();
			round++;
		}
		// print win message with number of rounds
		if (p.getNumSavedDice() == 10) {
		System.out.println("Tenzi! You win! It took you " + (round - 1) + " rounds to win.\n");
		}
		else if(c.getNumSavedDice() == 10) {
			System.out.println("Tenzi! Computer wins! It took the computer " + (round - 1) + " rounds to win.\n");
		}
		}

	public static void multiplayer() {
		Scanner input = new Scanner(System.in);
		int round = 1;
		System.out.print("How many human players would you like to play with? (1/2/3/4): ");
		int numPlayers = input.nextInt();
		System.out.print("How many computer players would you like to play with? (1/2/3/4): ");
		int numPlayers1 = input.nextInt();
		ArrayList<TenziPlayer> players = new ArrayList<TenziPlayer>();
		for (int i = 0; i < numPlayers; i++) {
			players.add(new TenziPlayer(10, "Player " + (i + 1)));
		}
		for (int j = 0; j < numPlayers1; j++) {
			players.add(new TenziPlayer(10, "Computer " + (j + 1)));
		}
		Boolean play = true;
		int collectNum = 0;
		int compNum = 0;
		while (play == true) {
		for (TenziPlayer p : players) {
			System.out.println("\n------ Round #" + round + "-------");
			if (p.getName().contains("Player")) {
			System.out.println("\n>> " + p.getName() + " <<");
			p.roll();
			p.print();
			if (collectNum < numPlayers) {
			System.out.print("Which number would you like to collect?: ");
			int target = input.nextInt();
			input.nextLine();
			p.setTargetNum(target);
			collectNum++;
			}
			p.removeTargetDice();
			if (p.done() && play == true) {
				System.out.println("Tenzi! " + p.getName() + " wins! It took " + (round) + " rounds to win.\n");
				play = false;
				break;
			}
			System.out.println("Left with: ");
			p.print();
			System.out.println("Press Enter to Roll again");
			input.nextLine();
			}

			else {
			System.out.println("\n>> " + p.getName() + " <<");
			p.roll();
			p.print();
			if (compNum < numPlayers1) {
			int compTarget = p.CompTargetNum();
			p.setTargetNum(compTarget);
			compNum++;
			}
			p.removeTargetDice();
			if (p.done() && play == true) {
				System.out.println("Tenzi! " + p.getName() + " wins! It took " + (round) + " rounds to win.\n");
				play = false;
				break;
			}
			System.out.println("Left with: ");
			p.print();
			System.out.println("Press Enter to Roll again");
			input.nextLine();
		}
		}
		round++;
		}
	}
}