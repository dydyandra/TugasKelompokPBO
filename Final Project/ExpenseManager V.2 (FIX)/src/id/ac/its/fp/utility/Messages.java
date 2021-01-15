package id.ac.its.fp.utility;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Messages {
	
	public static void showError(String msg, String head) {
		Alert alert = new Alert( AlertType.ERROR );
        alert.setTitle( "Error Dialog" );
        alert.setHeaderText( head );
        alert.setContentText( msg );

        alert.showAndWait();
	}
	
	public static boolean showConfirm(String msg, String head) {
		Alert alert = new Alert( AlertType.INFORMATION );
        alert.setTitle( "Confirm" );
        alert.setHeaderText( head );
        alert.setContentText( msg );
        alert.getButtonTypes().setAll( ButtonType.OK, ButtonType.CANCEL );
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
            return true;
            
        } else {
            
            alert.close();
            return false;
            
        }
	}
	
}
