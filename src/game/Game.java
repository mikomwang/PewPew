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
    	switch (move[0]) {
    	case "help":
    		System.out.println("____________________________________________________");
    		System.out.print(" + Commands will be in form of <ACTION><ROW><COLUMN> \n"
    				+ " + Pieces will be located by their ROW and COLUMN.\n"
    				+ " + The two ACTIONS consists of ROTATE and MOVE. \n"
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
    	case "R":
    		_board.rotatePiece((Integer.parseInt(move[1])), Integer.parseInt(move[2]));
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
	
	
	
	private Board _board;
	
	private BufferedReader _input;
}
