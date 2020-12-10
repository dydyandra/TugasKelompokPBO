package id.ac.its.raihan100;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite {
	// Delta x dan y untuk perpindahan spaceship
	private int dx ;
	private int dy ;
	
	// List missile yang ada
	private List<Missile> missiles ;
	
	// Constructor
	public SpaceShip(int x, int y) {
		super(x, y);
		initCraft() ;
	}
	
	// Inisialisasi Spaceship
	public void initCraft() {
		// Buat list missile
		missiles = new ArrayList<> () ;
		
		// Ambil gambar dan simpan ukurannya
		super.loadImage("spaceship30.png");
		super.getImageDimension();
	}
	
	@Override // Method move untuk pergerakan objek
	public void move() {

        x += dx;
        y += dy;
        
        if (x < 1) // Agar tidak melewati batas kiri
            x = 1 ;
        if (y < 1) // Agar tidak melewati batas atas
            y = 1 ;
        if (y > 370) // Agar tidak melewati batas bawah
        	y = 370 ;
    }
	
	// Getter Missile
	public List<Missile> getMissiles() {
        return missiles;
    }
	
	// Method untuk mengambil key yang ditekan pada keyboard
	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) // Spasi untuk menembak
            fire();
        
        if (key == KeyEvent.VK_LEFT)  // Panah kiri untuk geser kekiri
            dx = -3;

        if (key == KeyEvent.VK_RIGHT) // Panah kanan untuk geser kekanan
            dx = 3;

        if (key == KeyEvent.VK_UP) // Panah atas untuk geser keatas
            dy = -3;

        if (key == KeyEvent.VK_DOWN) // Panah bawah untuk geser kebawah
            dy = 3;
    }
	
	// Method untuk menembakkan missile (Membuat objek missile)
	public void fire() {
	    missiles.add(new Missile(x + width, y + height / 4));
	}
	
	// Method untuk mengembalikan status dx dy saat key dalam keyboard dilepas
	public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) 
            dx = 0;

        if (key == KeyEvent.VK_RIGHT) 
            dx = 0;

        if (key == KeyEvent.VK_UP) 
            dy = 0;

        if (key == KeyEvent.VK_DOWN) 
            dy = 0;
    }
}
