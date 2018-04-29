/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Austin LaBerta
 */
public class ButtonController {
	@FXML private Label lFeedback;
	@FXML private TextField tfFN;
	@FXML private TextField tfLN;
	@FXML private TextField tfYOB;
	@FXML private TextField tfPass;
	
		@FXML protected void regPressedAction(ActionEvent event) {
			if (tfFN.getText().matches("[a-zA-Z]+")
					&& tfLN.getText().matches("[a-zA-Z]+")
					&& tfYOB.getText().matches("[0-9]+")) {
				tfPass.setText(tfFN.getText() + "*" + tfYOB.getText());
				lFeedback.setText("Welcome " + tfFN.getText() + " "
								  + tfLN.getText() + "!");
			} else {
				tfPass.setText("");
				lFeedback.setText("Please enter first and last name and year" +
						" of birth.");
			}
		}
		@FXML protected void exitPressedAction(ActionEvent event) {
			System.exit(0);
	}
}
