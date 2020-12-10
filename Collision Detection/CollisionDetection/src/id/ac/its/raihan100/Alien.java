package id.ac.its.raihan100;

public class Alien extends Sprite {
	
	private static int ALIEN_SPEED ;
	
	public Alien(int x, int y) {
		super(x, y);
		
		initAlien() ;
	}
	
	public static void setAlienSpeed(int speed) {
		ALIEN_SPEED = speed;
	}
	
	public void initAlien() {
		super.loadImage("ufo30.png");
		super.getImageDimension();
	}

	@Override
	public void move() {
		
		if (x < -30) {
	        x = Board.BOARD_WIDTH;
	    }

	    x -= ALIEN_SPEED;
	}

}
