# APLIKASI COLLISION DETECTION WITH MOUSE (Space Invader v.0)

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
* Method KeyReleased.<br>
  Method KeyPressed masih digunakan apabila akan mengulang game. 

Method-method yand ditambah antara lain: 
* Method ``initBoard`` yang menginisialisasi Board Window. 
  ```initbaru
   // (B) Mouse Handler 
    MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
        
		// (B) Hilangkan Cursor Saat In-Game
		this.hideCursor();
  ```
  Membuat objek MouseHandler baru, yang kemudian akan digunakan juga untuk menambah MouseListener dan 
  MouseMotionListener. 
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
  Dengan menggunakan method ini, akan dibentuk suatu cursor baru yang akan memiliki gambar sama dengan objek Spaceship, sehingga ketika permainan
  pemain tidak akan terganggu dengan adanya cursor bawaan dari mouse. Untuk melakukan ini memanfaatkan method ``BufferedImage``. 

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
  
  ## Class Diagram Collision Detection with Mouse (Space Invader v.0)

  ![classdiagram](https://github.com/dydyandra/TugasKelompokPBO/blob/master/Collision%20Detection%20with%20Mouse/doc/CollisionDetectionWithMouse.jpg)
  
  ## Jalan Program Collision Detection with Mouse (Space Invader v.0)
  
  
  
  



