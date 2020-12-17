package id.ac.its.raihan100;

public class Missile extends Sprite {
	
	// Kecepatan Missile
	private static int MISSILE_SPEED ;
	
	// Constructor
	public Missile(int x, int y) {
		super(x, y);
		
		initMissile() ;
	}
	
	// Setter
	public static void setMissileSpeed(int speed) {
		MISSILE_SPEED = speed;
	}
	
	// Inisialisasi gambar dan ukuran missile
	public void initMissile() {
		super.loadImage("bullet20.png");
		super.getImageDimension();
	}
	
	@Override // Method untuk menggeser posisi missile
	public void move() {
		x += MISSILE_SPEED ;
		
		if (x > Board.BOARD_WIDTH) // Jika menyentuh batas kanan, missile hancur
			super.setVisible(false) ;
	}
}
