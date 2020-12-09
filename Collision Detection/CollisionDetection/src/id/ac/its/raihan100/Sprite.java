package id.ac.its.raihan100;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public abstract class Sprite {
	
	protected int x ;
	protected int y ;
	protected int width ;
	protected int height ;
	private Image img ;
	private boolean visible ;
	
	public abstract void move() ;
	
	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		this.visible = true;
	}
	
	protected void getImageDimension() {
		width = img.getWidth(null);
        height = img.getHeight(null);
	}
	
	protected void loadImage(String filename) {
		ImageIcon image = new ImageIcon(filename) ;
		img = image.getImage() ;
	}

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
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
