package game;

public class Mirror implements gamePieces{
	
	/** Mirror constructor. */
	public Mirror(String orientation) {
		_orientation = orientation;
	}
	
	public String getOrientation() {
		return _orientation;
	}
	
	@Override
	public void moveUp() {
		
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
		
	
	/** Orientation on board. */
	private String _orientation;

}
