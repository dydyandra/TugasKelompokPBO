package id.ac.its.raihan100;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class CollisionEx extends JFrame {
	
	// Constructor
	public CollisionEx() {
		initUI() ;
	}
	
	// Inisialisasi UI
	public void initUI() {
		// Membuat Objek Board Baru
		add(new Board()) ;
		
		// Men-set Board agar tidak dapat di resize
		setResizable(false) ;
		pack() ;
		
		// Judul Game
		setTitle("'Space' Invader v.1");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// Membuat Event
		EventQueue.invokeLater(() -> {
            CollisionEx ex = new CollisionEx();
            ex.setVisible(true);
        });
		
	}

}
