/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistrationswing;

/**
 *
 * @author Austin LaBerta
 */

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class StudentRegistrationFrame extends javax.swing.JFrame {
	
	JPanel  pPane = new JPanel(),
		pBTN = new JPanel(),
		pTF = new JPanel();
	JButton btnReg = new JButton(),
		btnExit = new JButton();
	JLabel  lFN = new JLabel(),
		lLN = new JLabel(),
		lYOB = new JLabel(),
		lTP = new JLabel(),
		lInfo = new JLabel();
	JTextField tfFN = new JTextField(),
		   tfLN = new JTextField(),
		   tfYOB = new JTextField(),
		   tfTP = new JTextField();
	GridBagLayout gbLayout = new GridBagLayout(),
		      gbTF = new GridBagLayout();
	
	public StudentRegistrationFrame() {
        try {
        	UIManager.setLookAndFeel(
                	UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
        	IllegalAccessException | UnsupportedLookAndFeelException e) {
        	System.out.println(e);
        }
        initComponents();
    }
	
	private void initComponents()
	{
		// Frame manipulation
		setTitle("Student Registration");
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	setLocationByPlatform(true);
		Dimension programSize = new Dimension(400, 160);
		Dimension dTF = new Dimension(164, 18);
		setPreferredSize(programSize);
		setMinimumSize(programSize);
		
		// Define Values
		
		//Labels
		lFN.setText("First Name:");
		lLN.setText("Lasts Name:");
		lYOB.setText("Year of Birth:");
		lTP.setText("Temporary Password:");
		lInfo.setText("");
		
		//Buttons
		btnReg.setText("Register");
		btnReg.addActionListener(e -> registerButtonClicked());
		btnExit.setText("Exit");
		btnExit.addActionListener(e -> exitButtonClicked());
		
		pBTN.add(btnReg);
		pBTN.add(btnExit);
		
		//TextFields
		tfFN.setPreferredSize(dTF);
		tfFN.setMinimumSize(dTF);
		tfLN.setPreferredSize(dTF);
		tfLN.setMinimumSize(dTF);
		tfYOB.setPreferredSize(dTF);
		tfYOB.setMinimumSize(dTF);
		tfTP.setPreferredSize(dTF);
		tfTP.setMinimumSize(dTF);
		
		tfTP.setEditable(false);
		
		pTF.setLayout(gbTF);
		pTF.add(lFN);
		gbTF.setConstraints(lFN, getConstraints(0, 0));
		
		pTF.add(lLN);
		gbTF.setConstraints(lLN, getConstraints(0, 1));

		pTF.add(lYOB);
		gbTF.setConstraints(lYOB, getConstraints(0, 2));

		pTF.add(lTP);
		gbTF.setConstraints(lTP, getConstraints(0, 3));
		
		pTF.add(tfFN);
		gbTF.setConstraints(tfFN, getConstraints(1, 0));

		pTF.add(tfLN);
		gbTF.setConstraints(tfLN, getConstraints(1, 1));

		pTF.add(tfYOB);
		gbTF.setConstraints(tfYOB, getConstraints(1, 2));

		pTF.add(tfTP);
		gbTF.setConstraints(tfTP, getConstraints(1, 3));

		// Set pPane
		pPane.add(pTF);
		gbLayout.setConstraints(pTF, getConstraints(0,0));
		
		pPane.add(lInfo);
		gbLayout.setConstraints(lInfo, getConstraints(0, 1));
		pPane.add(pBTN);
		gbLayout.setConstraints(pBTN, getConstraints(0, 2));
		add(pPane);
		
		// Set visible
		setVisible(true);

	}		
	
	private void registerButtonClicked() {
		String firstName = tfFN.getText(),
			   lastName = tfLN.getText(),
			   YearOfBirth = tfYOB.getText();
		
		if (!firstName.isEmpty() && !lastName.isEmpty() && !YearOfBirth.isEmpty()
			&& firstName.matches("[a-zA-Z]+")
			&& lastName.matches("[a-zA-Z]+")
			&& YearOfBirth.matches("[0-9]+")) {
			lInfo.setText("Welcome " + firstName + " " + lastName + "!");
			tfTP.setText(firstName + "*" + YearOfBirth);
		} else {

			lInfo.setText("Please enter first name, last name,"
						  + "and year of birth.");
			tfFN.setText("");
			tfLN.setText("");
			tfYOB.setText("");
			tfTP.setText("");
		}
	}
	
	private void exitButtonClicked() {
		System.exit(0);
	}
	
	// Helper method to return GridBagConstraints objects
    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        return c;
    }
	
	public static void main(String[] args) {
        	java.awt.EventQueue.invokeLater(() -> {
        		JFrame frame = new StudentRegistrationFrame();
        	});	
	}
	
}
