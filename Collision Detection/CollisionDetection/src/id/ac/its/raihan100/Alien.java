package id.ac.its.raihan100;

public class Alien extends Sprite {
	
	private static int ALIEN_SPEED ;
	
	public Alien(int x, int y) {
		super(x, y);
		
		initAlien() ;
	}

	public void initAlien() {
		super.loadImage("alien.jpg");
		super.getImageDimension();
	}

	@Override
	public void move() {
		
		if (x < 0) {
	        x = BOARD_WIDTH;
	    }

	    x -= ALIEN_SPEED;
	}

}
