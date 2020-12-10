package id.ac.its.raihan100;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CollisionEx extends JFrame {

	public CollisionEx(int aliens) {
		initUI(aliens) ;
	}
	
	public void initUI(int aliens) {
		add(new Board(aliens)) ;
		
		setResizable(false) ;
		pack() ;
		
		setTitle("Collision Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			int aliens = 0 ;
			String[] options1 = {"Easy", "Medium", "Hard"} ;
			
			int input1 = JOptionPane.showOptionDialog(null, 
					"Choose Difficulty", 
					"NoSpace", 
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
			
            CollisionEx ex = new CollisionEx(aliens);
            ex.setVisible(true);
        });
		
	}

}
