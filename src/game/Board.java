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
		
	/** Print game board. */
	public void printBoard() {
		for (int r = 0; r < 4; r +=1) {
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
