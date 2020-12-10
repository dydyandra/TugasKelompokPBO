package id.ac.its.raihan100;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite {
	
	private int dx ;
	private int dy ;
	private List<Missile> missiles ;
	
	public SpaceShip(int x, int y) {
		super(x, y);
		initCraft() ;
	}
	
	public void initCraft() {
		missiles = new ArrayList<> () ;
		super.loadImage("spaceship30.png");
		super.getImageDimension();
	}
	
	@Override
	public void move() {

        x += dx;
        y += dy;

        if (x < 1)
            x = 1 ;
        if (y < 1)
            y = 1 ;
        if (y > 370)
        	y = 370 ;
    }
	
	public List<Missile> getMissiles() {
        return missiles;
    }
	
	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) 
            fire();

        if (key == KeyEvent.VK_LEFT) 
            dx = -3;

        if (key == KeyEvent.VK_RIGHT) 
            dx = 3;

        if (key == KeyEvent.VK_UP) 
            dy = -3;

        if (key == KeyEvent.VK_DOWN)
            dy = 3;
    }

	public void fire() {
	    missiles.add(new Missile(x + width, y + height / 4));
	}
	
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
