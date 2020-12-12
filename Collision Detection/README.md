# APLIKASI COLLISION DETECTION (Space Invader v.0)

Salah satu karakteristik dari *games* yang berdimensi 2D adalah program berisi objek-objek yang bergerak, 
dimana objek-objek tersebut dapat bertumbukan (*collision*) dengan satu sama lain. Maka dari itu, dari membuat suatu *games*
diperlukan cara menangani *collision* tersebut, yaitu menggunakan *Collision Detection*. 

## Cara Kerja Program

Terdapat *abstract class* Sprite, yang  mengenkapsulasi objek-objek yang dapat bergerak di suatu game. 
Objek-objek yang bergerak dan dienkapsulasi tersebut adalah *Alien, Spaceship*, dan *Missile*. Objek-objek tersebut 
akan diinisialisasi saat objek *Board* dibuat, yang kemudian akan dipakai saat game dijalankan.

### Sprite
Pada class ini, terdapat beberapa method yang akan digunakan beberapa kali di dalam *class* lainnya. Method-method dalam 
Sprite antara lain 
* constructor yang akan menginisialisasi koordinat x, y, dan variabel visible
* *abstract method* untuk menggerakkan objek. Method ini abstrak dikarenakan implementasi method di setiap objek berbeda-beda. 
* method-method untuk mendapatkan gambar, dan dimensi (*height, width*) gambar tersebut
* method untuk mengatur visibilitas objek-objek bergerak
* getter dan setter untuk variabel-variabel dalam class
* method *bounding*:
  ```getBounds()
  public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
     }
  ```
  Method ini akan membuat Rectangle baru menggunakan koordinat dan ukuran yang telah didapatkan. 

### Alien
Method-method yang terdapat dalam class: 
* constructor untuk menginisialisasi koordinat dan gambar Alien
* setter untuk mengeset kecepatan bergeraknya objek Alien
* method agar objek dapat bergerak
  ```move
  @Override // Method untuk menggeser posisi alien
	  public void move() {
		
		  if (x < -30) { // Ketika sudah lewat batas kiri, kembali ke batas kanan
	         x = Board.BOARD_WIDTH;
	     }

	     x -= ALIEN_SPEED;
	  }
  ```
  Dalam method ini, karena Alien bergerak menuju kiri (mundur) maka untuk menggeser posisi koordinat objek akan terus dikurangi dengan kecepatan objek. 
### Missile  
Method-method dalam class: 
* constructor untuk menginisialisasi objek
* setter untuk kecepatan objek missile
* method agar objek dapat bergerak
 ```move
 @Override // Method untuk menggeser posisi missile
	 public void move() {
		 x += MISSILE_SPEED ;
		
		 if (x > Board.BOARD_WIDTH) // Jika menyentuh batas kanan, missile hancur
			 super.setVisible(false) ;
	 }
 ```
 Karena Missile bergerak ke kanan, maka untuk menggeser posisi Missile menggunakan koordinat objek yang kemudian ditambah dengan kecepatan objek Missile. Apabila melebihi lebar board, Missile akan menghilang. 
 
### Spaceship
Method-method yang terdapat dalam class: 
* constructor yang akan menginisialisasi objek
* method untuk inisialisasi Spaceship. Selain terdapat gambar spaceship, objek Missile juga dibuat list (dikarenakan Missile juga berjalan bersama Spaceship)
* method untuk mendapatkan Missile, yang akan dipanggil oleh class Board. 
* method agar objek dapat bergerak
  ``` move
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
   ```
   Karena objek bergerak mengikuti keyboard, maka untuk menggeser posisi koordinat dari objek ditambah dengan perpindahan objek Spaceship (dx, dy) yang akan diset di method lain. Agar objek tidak menghilang, maka apabila melewati batas, koordinat akan diset kembali. 

* Method untuk mengambil key yang ditekan pada keyboard 
  ```move
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
  
  ```
* method untuk megembalikan status perpindahan saat key dilepas (delta x dan y diset kembali menjadi 0 sesuai dengan key yang telah dilepas)
* method untuk menembakkan Missile (sekaligus membuat objek Missile dan menambahkan ke dalam list Missile)
  
### Board
Method-method dalam class: 
* constructoryang menginisialisasi *window* Board dari method lain
* method yang akan dipanggil di constructor
  Dalam method ini akan memanggil method chooseDifficulty, yang akan mengeset kecepatan dan jumlah dari objek Alien dan Missile. Selain itu, method juga memanggil method untuk medeteksi input keyboard, mengeset elemen-elemen dari window seperti warna dan ukuran, membuat objek Spaceship, menginisialisasi objek Alien, dan membuat objek Timer. 
* method untuk mengeset elemen dari objek Alien dan Missile sesuai dengan kesulitan yang dipilih. 
  ``` choose
  public void chooseDifficulty() {
		  int aliens = 0 ;
		  // Opsi tingkat kesulitan
		  String[] options1 = {"Easy", "Medium", "Hard"} ;
		
		  // JOptionPane untuk memilih kesuiltan
		  int input1 = JOptionPane.showOptionDialog(null, 
				  "Choose Difficulty", 
				  "'Space' Invader v.0", 
				  JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1,     options1[0]) ;
		
		  // Seleksi pilihan untuk masing - masing kesulitan dibedakan kecepatan alien  dan jumlahnya
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
  ```
  Method ini memanfaatkan JOption untuk menampilkan pilihan tingkat kesulitan. 
* method untuk men-*generate* posisi Alien. Method ini menggunakan array 2D dan looping untuk mendapatkan koordinat x, y random untuk membuat objek Alien.
  ```random
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
  ```
  
* method-method untuk menggambar GUI objek Spaceship, Missile, Alien  dan menulis status jumlah Alien, apabila game masih berjalan. 
* method untuk menggambar GUI saat permainan selesai. Method ini akan menggambar tulisan menang/kalah 
* Method untuk menentukan apakah ingin mengulang game. 
  ``` ulang
  public void lastEvent(KeyEvent e) {
		int key = e.getKeyCode() ;
		
		if (key == KeyEvent.VK_SPACE) // spasi untuk mengulang game
			initBoard() ;
		
		if (key == KeyEvent.VK_ESCAPE) // Escape untuk menutup aplikasi
			System.exit(0) ;
	}
  ```
  Apabila menekan key spasi, Board akan diinisialisasi ulang, sedangkan apabila meggunakan key escape, aplikasi akan tertutup. 
  
* Method untuk memanggil method aksi-aksi dalam game, yaitu mengecek status, memperbarui posisi, dan menggambar ulang. 
* Method untuk mengecek status apakah game masih berjalan atau tidak. 
* Method untuk memperbarui posisi Spaceship dengan cara memanggil method move. 
* Method untuk memperbarui posisi Missile, dengan cara membuat objek Missile dan mengeloop sesuai banyaknya missile untuk memanggil method move atau remove (apabila missile sudah tidak terlihat)
* Method untuk memperbarui posisi Alien. Objek akan dicek apakah masih ada atau tidak untuk menentukan selesainya permainan. Selain itu, method juga menggunakan cara looping untuk memanggil method move atau remove.
* method untuk mengecek apakah objek bertabrakan atau tidak. Objek dicek dengan melihat apakah bentuk Rectangle objek berpotongan dengan bentuk Rectangle objek lainnya. 
  Apabila objek Alien dan Spaceship bertabrakan, artinya game telah selesai dan kalah. Apabila Alien dan Missile bertabrakan, objek keduanya hilang. 
* terdapat class baru dalam class Board, yang akan membaca keyboard apabila dilepas ataupun ditekan. 

### CollisionEx
Method-method dalam class: 
* constructor yang akan memanggil inisialisasi UI
* method untuk menginisialisasi UI, dimana akan membuat objek Board baru. 
* class **main** yang akan membuat event, dimana akan menginisialisasi permainan. 

## Class Diagram Collision Detection (Space Invader v.0)

![classdiagram](https://github.com/dydyandra/TugasKelompokPBO/blob/master/Collision%20Detection/doc/collision.jpg)

## Jalan Collision Detection (Space Invader v.0)

Apabila program dijalankan, pemain akan memilih tingkat kesulitan sebelum bermain. 

![pick difficulty](https://github.com/dydyandra/TugasKelompokPBO/blob/master/Collision%20Detection/doc/optiondiff.png)



Berikut adalah contoh jalan permainan dari setiap tingkat kesulitan:

Easy | Medium | Hard
| :---: | :---: | :---:
<img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Collision%20Detection/doc/easy.gif" width="250" height="214" />  | <img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Collision%20Detection/doc/medium.gif" width="250" height="214" /> | <img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Collision%20Detection/doc/hard.gif" width="250" height="214" />



Berikut adalah tampilan apabila pemain berhasil memenangkan atau tidak berhasil dalam permainan: 
Kalah  | Menang
------------- | -------------
<img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Collision%20Detection/doc/youlose.png" width="250" height="214" />  | <img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Collision%20Detection/doc/youwin.png" width="250" height="214" />






