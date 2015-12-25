package game;

public class Main {

	public static void main(String[] args) {
		initialize();

	}
	
	
	
	public static void initialize() { 
		Board board = new Board();
		PewPews player1 = new PewPews(1);
		PewPews player2 = new PewPews(2);
		Mirror mirror1 = new Mirror("left");
		Mirror mirror2 = new Mirror("right");
		Mirror mirror3 = new Mirror("left");
		Mirror mirror4 = new Mirror("right");
		board.set(player1, 3, 0);
		board.set(player2, 0, 3);
		board.set(mirror1, 1, 1);
		board.set(mirror2, 1, 2);
		board.set(mirror3, 2, 2);
		board.set(mirror4, 2, 1);
		board.printBoard();
	}
}
