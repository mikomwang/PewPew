package game;

public class Mirror implements gamePieces{
	
	/** Mirror constructor. */
	public Mirror(String orientation) {
		_orientation = orientation;
	}
	
	public String getOrientation() {
		return _orientation;
	}


	public void rotate() {
		if (_orientation.equals("left")) {
			_orientation = "right";
		} else if (_orientation.equals("right")) {
			_orientation = "left";
		}
	}
		
	
	/** Orientation on board. */
	private String _orientation;

}
