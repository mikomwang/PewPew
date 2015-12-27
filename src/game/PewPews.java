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
	public void rotate() {
		if (_orientation.equals("up")) {
			_orientation = "right";
			return;
		}
		if (_orientation.equals("right")) {
			_orientation = "up";
			return;
		}
		if (_orientation.equals("down")) {
			_orientation = "left";
			return;
		}
		if (_orientation.equals("left")) {
			_orientation = "down";
			return;
		}
	}

	private String _orientation;
}
