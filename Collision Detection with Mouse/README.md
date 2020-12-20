# APLIKASI COLLISION DETECTION WITH MOUSE (Space Invader v.1)

**Perubahan yang telah dilakukan:**
- Menggunakan Mouse Handling
- Menambahkan fitur Pause ketika bermain

Dalam pembuatan aplikasi game terdapat 2 cara untuk *event handling*, yaitu suatu metode untuk menangani sebuah event/aksi 
yang diberikan pengguna kepada suatu komponen GUI. 2 *event handling* tersebut adalah: 
- **Keyboard Handling**<br>
    Untuk melihat aplikasi Space Invader dengan menggunakan *keyboard handling*:<br> 
   [Link menuju Collision Detection](https://github.com/dydyandra/TugasKelompokPBO/tree/master/Collision%20Detection)
- **Mouse Handling**<br>
    Dari aplikasi Collision Detection menggunkan keyboard handling terdapat beberapa modifikasi agar dapat digunakan 
    menggunakan mouse handling, yang akan dijelaskan di bawah ini. 
    
## Cara Kerja Program

Modifikasi yang telah dilakukan dari program Collision Detection sebelumnya: 

### Board
Method-method yang dihilangkan yaitu: 
* Method ``KeyReleased``.<br>
  Method ``KeyPressed`` masih digunakan apabila akan mengulang game. 
  Method ``lastEvent`` yang diganti dengan method ``someEvent``. 

Adapun diubahnya beberapa method seperti: 
* Method ``initBoard`` yang menginisialisasi Board Window. Di method ini terdapat modifikasi pada bagian:
  ```initbaru
  // (B) Key listener untuk mendeteksi input keyboard
  if (usedKeyListener != null)
			removeKeyListener(usedKeyListener) ;
  usedKeyListener = new TAdapter();
  addKeyListener(usedKeyListener);
  setFocusable(true);
  setBackground(Color.BLACK);
  ingame = true;
  pauseStatus = false ; // (B) Inisiasi pauseStatus false
	
   // (B) Mouse Handler 
    MouseHandler handler = new MouseHandler();
    this.addMouseListener(handler);
    this.addMouseMotionListener(handler);
        
   // (B) Hilangkan Cursor Saat In-Game
    this.hideCursor();
  ```
  Perubahan yang terjadi adalah dimodifikasinya KeyListener untuk mendeteksi input bagi menggunakan fitur *Pause* dan *Continue*. Selain itu dibuat inisiasi status Pause untuk mendeteksi apakah game sedang di-pause atau tidak. <br>
  
  Membuat objek MouseHandler baru, yang kemudian akan digunakan juga untuk menambah MouseListener dan MouseMotionListener. <br>
  
  Selain itu, method juga memanggil fungsi untuk menghillangkan cursor. 

* Method ``hideCursor``untuk menghilangkan cursor saat permainan berlangsung.   
  ```hide
  public void hideCursor() {
	BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		cursorImg, new Point(0, 0), "blank cursor");
	this.setCursor(blankCursor);
  }
  ```
  Dengan menggunakan method ini, akan dibentuk suatu blank cursor sehingga pemain tidak akan terganggu dengan adanya cursor bawaan dari mouse ketika bermain. Untuk melakukan ini memanfaatkan method ``BufferedImage``. 

* Method ``paintComponent``, dimana ditambahkan method apabila game sedang dalam mode Pause. 
  ```paintcomponent
  if (pauseStatus) { // (B) Jika game sedang di pause
        	drawPause(g); // Gambar tulisan game dipause
        	this.setCursor(Cursor.getDefaultCursor()); // Munculkan cursor default 	    saat game di-pause
        	timer.stop(); // Hentikan Menggambar
  }
   ```
   Apabila game terdeteksi sedang dalam mode Pause, method akan menggambar tulisan bahwa game sedang dipause. Cursor dikembalikan dan memunculkan cursor default, dan timer diberhentikan. 
   
* Method ``drawPause`` untuk menggambar Pause
  ```drawPause
  // (B) Method untuk menggambar pause
	private void drawPause(Graphics g) {
		String msg = "Game Paused";
		Font big = new Font("Comic Sans MS", Font.BOLD, 18);
        FontMetrics fm = getFontMetrics(big);
        
        g.setColor(Color.white);
        g.setFont(big);
        g.drawString(msg, (BOARD_WIDTH - fm.stringWidth(msg)) / 2,
                BOARD_HEIGHT / 2);
        
        msg = "Press 'Esc' to Continue" ;
        Font small = new Font("Comic Sans MS", Font.ITALIC, 14);
        fm = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (BOARD_WIDTH - fm.stringWidth(msg)) / 2,
                BOARD_HEIGHT / 2 + 22);
	}
  ```
  
* Method ``someEvent`` yang merupakan method ``lastEvent`` yang diubah. 
  ```someEvent
  // (B) Method untuk menentukan apakah ingin mengulangi game
  public void someEvent(KeyEvent e) {
	int key = e.getKeyCode() ;
		
	if (!ingame) {
		if (key == KeyEvent.VK_SPACE) // spasi untuk mengulang game
			initBoard() ;
			
		if (key == KeyEvent.VK_ESCAPE) // Escape untuk menutup aplikasi
			System.exit(0) ;			
	}
	else {
		if (key == KeyEvent.VK_ESCAPE) { // (B) Escape untuk pause/continue game
				pause() ;
		}
	}
   }
   
   ```
   Perubahan yang terjadi adalah apabila key yang terdeteksi adalah key *escape* untuk meng-*pause* game tersebut. 
* method ``pause`` untuk meng-*pause* game
  ```pause
  // (B) Method untuk nge-pause game
  public void pause() {
	if (!timer.isRunning()) {
		pauseStatus = false ;
		hideCursor() ; // Hide lagi cursornya ketika game berjalan
		timer.start();
	}
	else {
		pauseStatus = true ;
	}
  }
  ```
* Inner class untuk mouse handler, yang digunakan untuk membaca mouse event. 
  ``` mouse handler
  private class MouseHandler implements MouseListener, MouseMotionListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			spaceship.fire();
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			spaceship.x = e.getX() ;
			spaceship.y = e.getY() ;
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			spaceship.x = e.getX() ;
			spaceship.y = e.getY() ;
		}
	}
  ```
  Perbedaan dari class ini dengan class yang menggunakan keyboard handling adalah, untuk menggeser koordinat
  dari objek, kita tidak perlu menghitung melalui perubahan (dx/dy) method ``KeyPressed``, akan tetapi untuk menggeser
  dapat langsung dilakukan dengan mengambil koordinat x dan y dari mouse (seperti yang bisa dilihat di method ``MouseMoved`` dan
  ``MouseDragged``
  
  Apabila akan menembakkan missile, kami menggunakan method ``MousePressed``. 
  
  ### Spaceship
  Terdapat beberapa perubahan seperti dihapusnya atribut ``dx`` dan ``dy`` karena tidak diperlukan lagi untuk meghitung pergerseran koordinat. 
  
  ## Class Diagram Collision Detection with Mouse (Space Invader v.1)

  ![classdiagram](https://github.com/dydyandra/TugasKelompokPBO/blob/master/Collision%20Detection%20with%20Mouse/doc/CollisionDetectionWithMouse.jpg)
  
  ## Jalan Program Collision Detection with Mouse (Space Invader v.1)
  [Link menuju video](https://www.youtube.com/watch?v=SLq--q9hsd4&feature=youtu.be)
  
     [![https://www.youtube.com/watch?v=SLq--q9hsd4&feature=youtu.be](http://img.youtube.com/vi/SLq--q9hsd4/0.jpg)](http://www.youtube.com/watch?v=SLq--q9hsd4 "Collision Detection with Mouse (Space Invader v.1)")
  

  
  



