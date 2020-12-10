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
	
	private Timer timer;	// Objek timer, penghitung waktu
    private SpaceShip spaceship;	// Objek spaceship yang dipakai
    private List<Alien> aliens;		// List alien
    protected static boolean ingame;// Status dalam game / tidak
    private final int ICRAFT_X = 40;// Posisi x awal spaceship
    private final int ICRAFT_Y = 80;// Posisi y awal spaceship
    protected static int BOARD_WIDTH = 500 ; // Lebar window
    protected static int BOARD_HEIGHT = 400 ;// Tinggi window
    private final int DELAY = 15;	// Waktu jeda antara gerakan
    private int countAlien ;		// Jumlah alien
    private boolean winStatus ;		// Status menang / kalah
    
    private int[][] pos ;			// Array posisi alien yang ada
    
    // Constructor
	public Board() {
		initBoard() ;
	}
	
	// Inisialisasi Board Window
	public void initBoard() {
		// Memilih tingkat kesulitan game
		this.chooseDifficulty();
		
		// Key listener untuk mendeteksi input keyboard
		addKeyListener(new TAdapter()) ;
		setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;
        
        // Size window
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        
        // membuat objek spaceship
        spaceship = new SpaceShip(ICRAFT_X, ICRAFT_Y);

        // inisialisasi alien (Membuat objek alien)
        initAliens();
        
        // Membuat objek timer, penghitung waktu
        timer = new Timer(DELAY, this);
        timer.start();
	}
	
	public void chooseDifficulty() {
		int aliens = 0 ;
		// Opsi tingkat kesulitan
		String[] options1 = {"Easy", "Medium", "Hard"} ;
		
		// JOptionPane untuk memilih kesuiltan
		int input1 = JOptionPane.showOptionDialog(null, 
				"Choose Difficulty", 
				"'Space' Invader v.0", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]) ;
		
		// Seleksi pilihan untuk masing - masing kesulitan dibedakan kecepatan alien dan jumlahnya
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
			Missile.setMissileSpeed(4) ;
			aliens = 30 ;
		}
		else // Jika tidak ada input exit saja
			System.exit(0) ;
		// Simpan jumlah alien
		this.countAlien = aliens;
		
		// buat lokasi alien secara random
		this.pos = randomizeAlien() ;
	}
	
	// Method randomisasi posisi alien
	public int[][] randomizeAlien() {
		int x, y ; // Koordinat
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
	
	// Inisialisasi alien dengan membuat objek alien berdasarkan posisinya
	public void initAliens() {
        
        aliens = new ArrayList<>();
        
        for (int[] p : pos) {
            aliens.add(new Alien(p[0], p[1]));
        }
    }
    
	@Override // Menggambar
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Jika masih dalam game
        if (ingame) {
        	// Gambar objek
            drawObjects(g);

        } else { // Jika nggak
        	// Gambar tulisan bahwa game tealh selesai
            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }
	
	private void drawObjects(Graphics g) {
		// Jika spaceship berstatus masih ada
        if (spaceship.isVisible()) {
            g.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(),
                    this);
        }
        
        List<Missile> ms = spaceship.getMissiles();
        // Menggambar missile
        for (Missile missile : ms) {
            if (missile.isVisible()) {
                g.drawImage(missile.getImage(), missile.getX(), 
                        missile.getY(), this);
            }
        }
        // MEnggambar alien
        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
        }
        // menulis status jumlah alien
        g.setColor(Color.WHITE);
        g.drawString("Aliens left: " + aliens.size(), 5, 15);
    }
	
	private void drawGameOver(Graphics g) {
		
        String msg = "Game Over, You Lose!";
        if (this.winStatus) // Jika status menang true
        	msg = "Congratulation, You Win!" ;
        Font big = new Font("Comic Sans MS", Font.BOLD, 18);
        FontMetrics fm = getFontMetrics(big);
        
        g.setColor(Color.white);
        g.setFont(big);
        g.drawString(msg, (BOARD_WIDTH - fm.stringWidth(msg)) / 2,
                BOARD_HEIGHT / 2);
        
        // Menulis panduan jika ingin melanjutkan game
        msg = "Press 'Space' to Play Again" ;
        Font small = new Font("Comic Sans MS", Font.ITALIC, 14);
        fm = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (BOARD_WIDTH - fm.stringWidth(msg)) / 2,
                BOARD_HEIGHT / 2 + 22);
    }
	
	// Method untuk menentukan apakah ingin mengulangi game
	public void lastEvent(KeyEvent e) {
		int key = e.getKeyCode() ;
		
		if (key == KeyEvent.VK_SPACE) // spasi untuk mengulang game
			initBoard() ;
		
		if (key == KeyEvent.VK_ESCAPE) // Escape untuk menutup aplikasi
			System.exit(0) ;
	}
	
	@Override // Aksi - aksi yang dilakukan dalam game
    public void actionPerformed(ActionEvent e) {

        inGame(); // cek status dalam game, jika tidak, stop timer nya

        updateShip();	// Mengupdate posisi spaceship
        updateMissiles(); // Mengupdate posisi missile
        updateAliens();	// MEngupdate posisi alien

        checkCollisions();	// Cek apakah terjadi tabrakan

        repaint();	 // Gambar ulang
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
