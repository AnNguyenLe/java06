package demojava06.BaiTapNopBuoi9;

import java.util.Scanner;

public class Game {
	private String title;
	private int noOfRemainingPlays;
	
	public Game(String title, int noOfRemainingPlays) {
		setTitle(title);
		setNoOfRemainingPlays(noOfRemainingPlays);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(Validator.isEmptyString(title)) {
			throw new IllegalArgumentException("Game title cannot be empty!");
		}
		this.title = title;
	}

	public int getNoOfRemainingPlays() {
		return noOfRemainingPlays;
	}

	public void setNoOfRemainingPlays(int noOfRemainingPlays) {
		if(Validator.isOutOfRange(noOfRemainingPlays, 1, 10)) {
			throw new IllegalArgumentException("Remaining play must be in range of 1 - 10!");
		}
		this.noOfRemainingPlays = noOfRemainingPlays;
	}
	
	public void start() {
		Scanner s = new Scanner(System.in);
		System.out.println("Start game...");
		while(true) {
			System.out.print("Press any keys to continue: ");
			if(!s.nextLine().isEmpty()) {
				System.out.println("Remaining play: " + noOfRemainingPlays--);
			}
			if(noOfRemainingPlays == 0) {
				break;
			}
		}
		s.close();
		stop();
	}
	
	private void stop() {
		System.out.println("Game stopped...");
		return;
	}
}
