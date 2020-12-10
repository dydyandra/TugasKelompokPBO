package id.ac.its.raihan100;

public class Missile extends Sprite {
	
	private static int MISSILE_SPEED ;
	
	public Missile(int x, int y) {
		super(x, y);
		
		initMissile() ;
	}
	
	public static void setMissileSpeed(int speed) {
		MISSILE_SPEED = speed;
	}
	
	public void initMissile() {
		super.loadImage("bullet20.png");
		super.getImageDimension();
	}
	
	@Override
	public void move() {
		x += MISSILE_SPEED ;
		
		if (x > Board.BOARD_WIDTH)
			super.setVisible(false) ;
	}
}
