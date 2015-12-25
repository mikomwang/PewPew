package game;

public class PewPews implements gamePieces{

	public PewPews(int player) {
		if (player == 1) {
			_orientation = "up";
		}
		if (player == 2) {
			_orientation = "down";
		}
	}
	
	public String getOrientation() {
		return _orientation;
	}
	
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}

	private String _orientation;
}
