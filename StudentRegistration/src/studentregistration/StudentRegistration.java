/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Austin LaBerta
 */
public class StudentRegistration extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
	FXMLLoader load = new FXMLLoader(getClass().getResource("FXML.fxml"));
	Parent root = load.load();
    Scene scene = new Scene(root);
	primaryStage.setTitle("Student Registration");
    primaryStage.setScene(scene);
    primaryStage.show();
	 
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
