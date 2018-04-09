import consolehelper.util.Console;
import java.nio.*;

public class FlagGameApp {
	static String turn = "";
	static int flags = 0;
	public static void main(String[] args) {
		System.out.println("Welcome to the flag game!");
		flags = Console.getInt("How many flags would you like to play with?:", 3, 99);
		do {
			if(turn.equalsIgnoreCase("player")) {
				playerTurn();
				if(flags == 0) {
					System.out.println("You win!");
				}
			} else
				computerTurn();
			if(flags == 0) {
				System.out.println("The computer wins this round!");
			}
		} while (flags > 1);
		if (flags < 0) {
			System.out.println("No one won. Because someone took more flags than there were left. Try again!");
		}
	}

	public static void playerTurn() {
		int f = Console.getInt("How many flags yould you like to take?", 0, 4);
		turn = "computer";
		flags -= f;
		System.out.println("You took " + f +" flags. "+ flags + " flags remain.");
	} 

	public static void computerTurn() {
		int result = 0;
		if(flags-1 % 4 == 0)
			result=1;
		else if(flags-2 % 4 == 0)
			result=2;
		else if(flags-3 % 4 == 0)
			result=3;
		else 
			result = (int) Math.random()*3+1;
		turn = "player";
		flags -= result;
		System.out.println("The computer took" + result + " flags. " + flags + " flags remain");
	} 
}

