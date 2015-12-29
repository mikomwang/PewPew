package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
	
	public Game() {
		_input = new BufferedReader(new InputStreamReader(System.in));
		_board = new Board();
	}
	
	public void play() throws IOException {
		initialize();
		
		while (true) {
			System.out.print("> ");
			String s = _input.readLine();
			s.trim();
			processCommand(s);
		}
	}
	

    /** If LINE is a recognized command other than a move, process it
     *  and return true.  Otherwise, return false. */
    private void processCommand(String line) {
    	String[] move = line.split("\\s+");
    	if (move.length == 3) {
    		if ((!(Integer.parseInt(move[1]) <= 3)) && (!(Integer.parseInt(move[1]) >= 0))
				&& (!(Integer.parseInt(move[2]) <= 3)) && (!(Integer.parseInt(move[2]) >= 0))) {
    			System.out.println("Coordinates out of range!");
    			return;
    		}
    	} else if (move.length == 1) {
    		if (! ((move[0].equals("help")) || (move[0].equals("P")))) {
    			System.out.println("Invalid commands! Try \"help\"");
    			return;
    		}
    	} else {
    		System.out.println("Invalid commands!");
    		return;
    	}
    	
    	switch (move[0]) {
    	case "help":
    		System.out.println("____________________________________________________");
    		System.out.print(" + Commands will be in form of <ACTION>[<ROW>][<COLUMN>] \n"
    				+ " + Pieces will be located by their ROW and COLUMN.\n"
    				+ " + The two game ACTIONS consists of ROTATE and MOVE. \n"
    				+ " + You may print the board using \"P\". \n"
    				+ " + Indicate ROTATE using action command \"R\". \n"
    				+ " + MOVES are keyed as: MU (Move up) \n"
    				+ " 		       MD (Move down)\n"
    				+ "  		       MR (Move right)\n"
    				+ "		       ML (Move left)\n");
    		System.out.println("____________________________________________________");
    		return;
    	case "MU":
    		_board.moveUp((Integer.parseInt(move[1])), Integer.parseInt(move[2]));
    		_board.printBoard();
    		return;
    	case "MD":
    		_board.moveDown((Integer.parseInt(move[1])), Integer.parseInt(move[2]));
    		_board.printBoard();
    		return;
    	case "MR":
    		_board.moveRight((Integer.parseInt(move[1])), Integer.parseInt(move[2]));
    		_board.printBoard();
    		return;
    	case "ML":
    		_board.moveLeft((Integer.parseInt(move[1])), Integer.parseInt(move[2]));
    		_board.printBoard();
    		return;
    	case "R": case "rotate": case "r":
    		if (_board.get((Integer.parseInt(move[1])), Integer.parseInt(move[2])) == null) {
    			System.out.println("Nothing there to rotate!");
    			return;
    		}
    		_board.rotatePiece((Integer.parseInt(move[1])), Integer.parseInt(move[2]));
    		_board.printBoard();
    		return;
    	case "P":
    		_board.printBoard();
    		return;
    	default:
    		System.out.println("Invalid command!");
    		return;
    	}
    }
	
	
	/** Creates initial board setting. */
	public void initialize() { 
		PewPews player1 = new PewPews(1);
		PewPews player2 = new PewPews(2);
		_turn  = 1;
		Mirror mirror1 = new Mirror("left");
		Mirror mirror2 = new Mirror("right");
		Mirror mirror3 = new Mirror("left");
		Mirror mirror4 = new Mirror("right");
		_board.set(player1, 3, 0);
		_board.set(player2, 0, 3);
		_board.set(mirror1, 1, 1);
		_board.set(mirror2, 1, 2);
		_board.set(mirror3, 2, 2);
		_board.set(mirror4, 2, 1);
		_board.printBoard();
	}
	
	
	// DONT FORGET TO SWITCH TURNS
	public int findPlayerRow() {
		for (int r = 0; r < 4; r += 1) {
			for (int c = 0; c < 4; c +=1 ){
				gamePieces currPiece = _board.get(r, c);
				if (currPiece instanceof PewPews) {
					if (((PewPews) currPiece).getPlayer() == _turn) {
						System.out.println(r);
						return r;
					}
				}
			}
		}
		return _turn; //dummy
	}
	
	public int findPlayerCol() {
		for (int r = 0; r < 4; r += 1) {
			for (int c = 0; c < 4; c +=1 ){
				gamePieces currPiece = _board.get(r, c);
				if (currPiece instanceof PewPews) {
					if (((PewPews) currPiece).getPlayer() == _turn) {
						System.out.println(c);
						return c;
					}
				}
			}
		}
		return _turn;
	}
	
	private int _turn;
	
	private Board _board;
	
	private BufferedReader _input;
}
