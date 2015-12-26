package game;

public class Board {
	
	/** Board constructor. */
	public Board() {
		_gameBoard = new gamePieces[4][4];
	}
	
	/** Returns playing board. */
	public gamePieces[][] getBoard() {
		return _gameBoard;
	}
	
	public void set(gamePieces piece, int r, int c) {
		_gameBoard[r][c] = piece;
	}
	
	public gamePieces get(int r, int c) {
		return _gameBoard[r][c];
	}
		
	/** Print game board. */
	public void printBoard() {
		System.out.print("  " + "0" + " " + "1" + " " + "2" + " " + "3");
		System.out.println();
		for (int r = 0; r < 4; r +=1) {
			System.out.print(r + " ");
			for (int c = 0; c < 4; c +=1) {
				if (_gameBoard[r][c] == null) {
					System.out.print("-");
				}
				if (_gameBoard[r][c] instanceof Mirror) {
					Mirror mirror = (Mirror) _gameBoard[r][c];
					if (mirror.getOrientation().equals("left")) {
						System.out.print("\\");
					}
					if (mirror.getOrientation().equals("right")) {
						System.out.print("/");
					}
				}
				if (_gameBoard[r][c] instanceof PewPews) {
					PewPews shooter = (PewPews) _gameBoard[r][c];
					if (shooter.getOrientation().equals("up")) {
						System.out.print("^");
					}
					if (shooter.getOrientation().equals("down")) {
						System.out.print("v");
					}
					if (shooter.getOrientation().equals("left")) {
						System.out.print("<");
					}
					if (shooter.getOrientation().equals("right")) {
						System.out.print(">");
					}
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	/** Current game board as a matrix of pieces. */
	private gamePieces[][] _gameBoard;
}
