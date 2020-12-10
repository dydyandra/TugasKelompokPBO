package id.ac.its.raihan100;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

public class Board extends JPanel implements ActionListener {
	
	private Timer timer;
    private SpaceShip spaceship;
    private List<Alien> aliens;
    protected static boolean ingame;
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 80;
    protected static int BOARD_WIDTH = 500 ;
    protected static int BOARD_HEIGHT = 400 ;
    private final int DELAY = 15;
    private int countAlien ;
    private boolean winStatus ;
    
    private int[][] pos ;
    
	public Board() {
		initBoard() ;
	}
	
	public void initBoard() {
		this.chooseDifficulty();
		
		addKeyListener(new TAdapter()) ;
		setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

        spaceship = new SpaceShip(ICRAFT_X, ICRAFT_Y);

        initAliens();

        timer = new Timer(DELAY, this);
        timer.start();
	}
	
	public void chooseDifficulty() {
		int aliens = 0 ;
		String[] options1 = {"Easy", "Medium", "Hard"} ;
		
		int input1 = JOptionPane.showOptionDialog(null, 
				"Choose Difficulty", 
				"'Space' Invader v.0", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]) ;
		
		if (input1 == 0) {
			Alien.setAlienSpeed(1) ;
			Missile.setMissileSpeed(4) ;
			aliens = 20 ;
		}
		else if (input1 == 1) {
			Alien.setAlienSpeed(3) ;
			Missile.setMissileSpeed(4) ;
			aliens = 25 ;
		}
		else if (input1 == 2) {
			Alien.setAlienSpeed(5) ;
			Missile.setMissileSpeed(3) ;
			aliens = 30 ;
		}
		this.countAlien = aliens;
		this.pos = randomizeAlien() ;
	}
	
	public int[][] randomizeAlien() {
		int x, y ;
		int [][] aliens = new int[this.countAlien][2] ;
		Random rand = new Random() ;
		
		for (int i = 0 ; i < this.countAlien ; i++) {
			x = 500 + rand.nextInt(2500 - 510) ;
			y = 29 + rand.nextInt(370 - 29) ;
			
			aliens[i][0] = x ;
			aliens[i][1] = y ;
		}
		
		return aliens ;
	}
	
	public void initAliens() {
        
        aliens = new ArrayList<>();

        for (int[] p : pos) {
            aliens.add(new Alien(p[0], p[1]));
        }
    }
    
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

	private void drawObjects(Graphics g) {

        if (spaceship.isVisible()) {
            g.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(),
                    this);
        }

        List<Missile> ms = spaceship.getMissiles();

        for (Missile missile : ms) {
            if (missile.isVisible()) {
                g.drawImage(missile.getImage(), missile.getX(), 
                        missile.getY(), this);
            }
        }

        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
        g.drawString("Aliens left: " + aliens.size(), 5, 15);
    }
	
	private void drawGameOver(Graphics g) {

        String msg = "Game Over, You Lose!";
        if (this.winStatus) 
        	msg = "Congratulation, You Win!" ;
        Font big = new Font("Comic Sans MS", Font.BOLD, 18);
        FontMetrics fm = getFontMetrics(big);
        
        g.setColor(Color.white);
        g.setFont(big);
        g.drawString(msg, (BOARD_WIDTH - fm.stringWidth(msg)) / 2,
                BOARD_HEIGHT / 2);
        
        msg = "Press 'Space' to Play Again" ;
        Font small = new Font("Comic Sans MS", Font.ITALIC, 14);
        fm = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (BOARD_WIDTH - fm.stringWidth(msg)) / 2,
                BOARD_HEIGHT / 2 + 22);
    }
	
	public void lastEvent(KeyEvent e) {
		int key = e.getKeyCode() ;
		
		if (key == KeyEvent.VK_SPACE)
			initBoard() ;
		
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(0) ;
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateShip();
        updateMissiles();
        updateAliens();

        checkCollisions();

        repaint();
    }

    private void inGame() {

        if (!ingame) {
            timer.stop();
        }
    }

    private void updateShip() {

        if (spaceship.isVisible()) {
            
            spaceship.move();
        }
    }

    private void updateMissiles() {

        List<Missile> ms = spaceship.getMissiles();

        for (int i = 0; i < ms.size(); i++) {

            Missile m = ms.get(i);

            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

    private void updateAliens() {

        if (aliens.isEmpty()) {
        	this.winStatus = true ;
            ingame = false;
            return;
        }

        for (int i = 0; i < aliens.size(); i++) {

            Alien a = aliens.get(i);
            
            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
            }
        }
    }

    public void checkCollisions() {

        Rectangle r3 = spaceship.getBounds();

        for (Alien alien : aliens) {
            
            Rectangle r2 = alien.getBounds();

            if (r3.intersects(r2)) {
                this.winStatus = false ;
                spaceship.setVisible(false);
                alien.setVisible(false);
                ingame = false;
            }
        }

        List<Missile> ms = spaceship.getMissiles();

        for (Missile m : ms) {

            Rectangle r1 = m.getBounds();

            for (Alien alien : aliens) {

                Rectangle r2 = alien.getBounds();

                if (r1.intersects(r2)) {
                    
                    m.setVisible(false);
                    alien.setVisible(false);
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceship.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
        	if (Board.ingame)
        		spaceship.keyPressed(e);
        	else 
        		lastEvent(e);
        }
    }
	
}
