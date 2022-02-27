import java.util.Scanner;

public class Game {

	static String nameOfPlayer;
	static final int rock = 1;
	static final int paper = 2;
	static final int scissor = 3;
	static int usersPoint = 0;
	static int computersPoint = 0;
	static int numberOfRounds = 3;
	static String rules = "ROCKS DEFEATS SCISSOR\nPAPER DEFEATS ROCK\nSCISSOR DEFEATS PAPER";

	public static void main(String[] args) throws InterruptedException{

		Scanner input = new Scanner(System.in);

		System.out.println("WELCOME TO THE GAME : ROCK PAPER AND SCISSORS!!!\n");
		System.out.print("ENTER YOU NAME : ");
		String name = input.nextLine() + " ";
		name = name.substring(0,name.indexOf(" ")).toUpperCase();

		System.out.print("\nWELCOME " + name + " ONCE AGAIN\nHERE ARE THE RULES.\n");
		System.out.println("THERE ARE GOING TO BE 3 ROUNDS AND THE BEST OF 3 IS TAKEN FOR CALCULATING THE WINNER.\n");

		System.out.println("AS IT IS NOT A GUI(Graphical User Interface) SO I AM ASSIGNING NUMBERS TO ITEMS IN THE GAME.\n");
		System.out.println("HERE ARE THE ASSIGNMENTS OF THE GAME :\nROCK    : 1\nPAPER   : 2\nSCISSOR : 3\n\n");

		resultCalculator(name);
		input.close();
	}

	static void resultCalculator(String name) throws InterruptedException{
		Scanner sc = new Scanner(System.in); 
		for (int currentRound = 1; currentRound <= 4; currentRound++) {

			if (numberOfRounds == 0) {
				System.out.println("\nGAME OVER!!!\n");
				// Thread.sleep(300);
				finalResult(usersPoint, computersPoint, name);
				break;
			}

			Thread.sleep(200);
			System.out.println("\t\t\tROUND " + currentRound + "\n");

			System.out.print("ENTER YOUR ITEM : ");
			int userItem = sc.nextInt();

			int computerItem = (int) (Math.random() * (3 - 1) + 1);

			System.out.println("\nYOUR'S ITEM : " + getItem(userItem) + "\n");
			Thread.sleep(200);
			System.out.println("\nCOMPUTER'S ITEM : " + getItem(computerItem) + "\n");
			Thread.sleep(200);
			output(userItem, computerItem, name);
			System.out.println("\nYOU  :  COMPUTER");
			Thread.sleep(200);
			System.out.println(" " + usersPoint + "   :      " + computersPoint + "\n");
			numberOfRounds--;
		}
		sc.close();
	}

	static String getItem(int item) {
		if (item == 1)
			return "ROCK";
		else if (item == 2)
			return "PAPER";
		else if (item == 3)
			return "SCISSOR";
		else
			return "INPUT A VALID ITEM";
	}

	static void output(int user, int computer,String name) {
		if (computer == 1 && user == 1) {
			System.out.println("IT'S A TIE AS BOTH OF YOU TOOK OUT ROCK.");
		} 
		else if (computer == 1 && user == 2) {
			System.out.println(name + " WINS.");
			usersPoint++;
		}
		else if (computer == 1 && user == 3) {
			System.out.println("COMPUTER WINS.");
			computersPoint++;
		} 
		else if (computer == 2 && user == 1) {
			System.out.println("COMPUTER WINS.");
			computersPoint++;
		} 
		else if (computer == 2 && user == 2) {
			System.out.println("IT'S A TIE AS BOTH OF YOU TOOK OUT PAPER.");
		} 
		else if (computer == 2 && user == 3) {
			System.out.println(name + " WINS.");
			usersPoint++;
		} 
		else if (computer == 3 && user == 1) {
			System.out.println(name + " WINS.");
			usersPoint++;
		} 
		else if (computer == 3 && user == 2) {
			System.out.println("COMPUTER WINS.");
			computersPoint++;
		} 
		else if (computer == 3 && user == 3) {
			System.out.println("IT'S A TIE AS BOTH OF YOU TOOK OUT SCISSOR.");
		} 
		else if (user == 4) {
			System.out.println("ENTER AN ITEM WITHIN A RANGE OF (1 - 3).");
			user = 3;
		}
		else
			System.out.println("WORKING ON THIS BUG WILL SOON RELEASE A UPDATE TO FIX IT.");
	}

	static void finalResult (int userpoint, int computerpoint, String name) throws InterruptedException{
		Thread.sleep(200);
		if (userpoint > computerpoint)
			System.out.println("CONGRATULATIONS " + name + " WINS THE GAME!!!");
		else if (computerpoint > userpoint)
			System.out.println("COMPUTER WINS THE GAME!!!\nBETTER LUCK NEXT TIME " + name + "!!!");
		else
			System.out.println("IT'S A TIE BETWEEN YOU AND THE COMPUTER.");
	}
}