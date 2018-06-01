/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey;

import javax.swing.ButtonGroup;

/**
 *
 * @author Austin LaBerta
 */
public class Verify {
	private boolean hasFailed;
	private String errorMessage;
	
	public Verify() {
		hasFailed = false;
		errorMessage = "";
	}
	
	public void verifyText(String enteredText, String object) {
		if (enteredText.isEmpty()) {
			hasFailed = true;
			extendErrorMessage(object);
		}
	}
	
	public void verifyBtn(ButtonGroup buttonSelected, String object) {
		if (buttonSelected.getSelection() == null) {
			hasFailed = true;
			extendErrorMessage(object);
		}
	}
	
	public void verifyCom(String selectedItem,String comparedItem, String object) {
		if (selectedItem.equals(comparedItem)) {
			hasFailed = true;
			extendErrorMessage(object);
		}
	}
	
	public boolean hasFailed() {
		return hasFailed;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	private void extendErrorMessage(String object) {
			errorMessage += "\nPlease select a " + object + ".";
	}
}
