package id.ac.its.raihan100;
import java.util.ArrayList;
import java.util.List;

// (B) Line 9, 33, 37, 55, 56

public class SpaceShip extends Sprite {
	
	// (B) Atribut dx dan dy dihapus karena tidak digunakan
	
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
        
		// (B) Statement untuk dx dan dy dihapus karena tidak digunakan
		
        if (x < 1) // Agar tidak melewati batas kiri
            x = 1 ;
        if (x > 470) // (B) Agar tidak melewati batas kanan
        	x = 470 ;
        if (y < 1) // Agar tidak melewati batas atas
            y = 1 ;
        if (y > 370) // Agar tidak melewati batas bawah
        	y = 370 ;
    }
	
	// Getter Missile
	public List<Missile> getMissiles() {
        return missiles;
    }
	
	// Method untuk menembakkan missile (Membuat objek missile)
	public void fire() {
	    missiles.add(new Missile(x + width, y + height / 4));
	}
	
	// (B) Method KeyPressed dan KeyReleased ditukar dengan Mouse Handler
	// (B) Di Class Board

}
