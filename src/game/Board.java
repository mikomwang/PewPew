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
		
	/** Current game board as a matrix of pieces. */
	private gamePieces[][] _gameBoard;
}
