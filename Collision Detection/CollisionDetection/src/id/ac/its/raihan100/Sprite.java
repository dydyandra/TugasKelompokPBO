package id.ac.its.raihan100;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public abstract class Sprite {
	
	protected int x ;	 		// Koordinat X
	protected int y ;			// Koordinat Y
	protected int width ;		// Lebar Objek
	protected int height ;		// Tinggi Objek
	private Image img ;			// Gambar Objek
	private boolean visible ;	// Visibilitas Objek
	
	// Abstract method move wajib ada di semua subclass
	public abstract void move() ;
	
	// Constructor
	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		this.visible = true;
	}
	
	// Mengambil dimensi gambar objek
	protected void getImageDimension() {
		width = img.getWidth(null);
        height = img.getHeight(null);
	}
	
	// Mengambil file gambar
	protected void loadImage(String filename) {
		ImageIcon image = new ImageIcon(filename) ;
		img = image.getImage() ;
	}
	
	// ---Getter dan Setter---
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return img;
	}
	// -------------------------
	
	// Mengambil Batasan gambar dalam bentuk persegi panjang
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
