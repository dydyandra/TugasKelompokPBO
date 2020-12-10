package id.ac.its.raihan100;

public class Alien extends Sprite {
	
	// Kecepatan gerak alien
	private static int ALIEN_SPEED ;
	
	// Constructor
	public Alien(int x, int y) {
		super(x, y);
		
		initAlien() ;
	}
	
	// Setter
	public static void setAlienSpeed(int speed) {
		ALIEN_SPEED = speed;
	}
	
	// Inisialisasi gambar dan ukuran alien
	public void initAlien() {
		super.loadImage("ufo30.png");
		super.getImageDimension();
	}

	@Override // Method untuk menggeser posisi alien
	public void move() {
		
		if (x < -30) { // Ketika sudah lewat batas kiri, kembali ke batas kanan
	        x = Board.BOARD_WIDTH;
	    }

	    x -= ALIEN_SPEED;
	}

}
