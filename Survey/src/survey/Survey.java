/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.*;

/**
 *
 * @author Austin LaBerta
 */
public class Survey  extends javax.swing.JFrame {

	// panels
	JPanel pPane = new JPanel();
	JPanel pPersonal = new JPanel();
	JPanel pEyes = new JPanel();
	JPanel pProg = new JPanel();
	JPanel pBtn = new JPanel();
	
	//Gridbag
	GridBagLayout gbPane = new GridBagLayout();
	GridBagLayout gbPersonal = new GridBagLayout();
	
	// labels
	JLabel lFN = new JLabel();
	JLabel lLN = new JLabel();
	JLabel lCountry = new JLabel();
	JLabel lEyes = new JLabel();
	JLabel lProg = new JLabel();
	// Text Fields
	JTextField tfFN = new JTextField();
	JTextField tfLN = new JTextField();
	
	// Combo box
	String[] countries = { "Select a country...", "United States", "Mexico",
		"Canada", "Brazil", "Libya", "France", "Spain", "Niger", "China",
		"Japan", "Other" };
	JComboBox comCountries = new JComboBox(countries);
	
	// Radio Buttons
	JRadioButton rbBrown = new JRadioButton();
	JRadioButton rbGreen = new JRadioButton();
	JRadioButton rbBlue = new JRadioButton();
	JRadioButton rbOther = new JRadioButton();
	// Check Box
	JCheckBox cbHTML = new JCheckBox();
	JCheckBox cbSQL = new JCheckBox();
	JCheckBox cbJava = new JCheckBox();
	JCheckBox cbAndroid = new JCheckBox();
	JCheckBox cbPython = new JCheckBox();
	// Buttons
	JButton bSubmit = new JButton();
	JButton bExit = new JButton();
	// Button Groups
	ButtonGroup bgRadio = new ButtonGroup();
	
	
	public Survey() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }
	
	private void initComponents() {
		// Window settings
        setTitle("Student Survey");
		Dimension dProg = new Dimension(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
		setPreferredSize(dProg);
		setMinimumSize(dProg);
		
		// Set Swing Component Sizes	
		Dimension dText = new Dimension(140, 20);
		Dimension dLabel = new Dimension(100, 20);
		Dimension dButton = new Dimension(120, 20);
		Dimension dProgramming = new Dimension(200, 20);
		
		lFN.setMinimumSize(dLabel);
		lLN.setMinimumSize(dLabel);
		lCountry.setMinimumSize(dLabel);
		lEyes.setMinimumSize(dLabel);
		lProg.setMinimumSize(dProgramming);
		lFN.setPreferredSize(dLabel);
		lLN.setPreferredSize(dLabel);
		lCountry.setPreferredSize(dLabel);
		lEyes.setPreferredSize(dLabel);
		lProg.setPreferredSize(dProgramming);
		
		tfFN.setMinimumSize(dText);
		tfLN.setMinimumSize(dText);
		tfFN.setPreferredSize(dText);
		tfLN.setPreferredSize(dText);		
		
		comCountries.setMinimumSize(dText);
		comCountries.setPreferredSize(dText);
		
		rbBrown.setMinimumSize(dLabel);
		rbGreen.setMinimumSize(dLabel);
		rbBlue.setMinimumSize(dLabel);
		rbOther.setMinimumSize(dLabel);
		rbBrown.setPreferredSize(dLabel);
		rbGreen.setPreferredSize(dLabel);
		rbBlue.setPreferredSize(dLabel);
		rbOther.setPreferredSize(dLabel);
		
		cbHTML.setMinimumSize(dLabel);
		cbSQL.setMinimumSize(dLabel);
		cbJava.setMinimumSize(dLabel);
		cbAndroid.setMinimumSize(dLabel);
		cbPython.setMinimumSize(dLabel);
		cbHTML.setPreferredSize(dLabel);
		cbSQL.setPreferredSize(dLabel);
		cbJava.setPreferredSize(dLabel);
		cbAndroid.setPreferredSize(dLabel);
		cbPython.setPreferredSize(dLabel);
		
		bSubmit.setMinimumSize(dButton);
		bExit.setMinimumSize(dButton);
		bSubmit.setPreferredSize(dButton);
		bExit.setPreferredSize(dButton);
		
		// Set Text
		lFN.setText("First Name:");
		lLN.setText("Last Name:");
		lCountry.setText("Country:");
		lEyes.setText("Eye Color:");
		lProg.setText("Programming Skills:");
		
		rbBrown.setText("Brown");
		rbGreen.setText("Green");
		rbBlue.setText("Blue");
		rbOther.setText("Other");
		
		cbHTML.setText("HTML");
		cbSQL.setText("SQL");
		cbJava.setText("Java");
		cbAndroid.setText("Android");
		cbPython.setText("Python");
		
		bSubmit.setText("Submit");
		bExit.setText("Exit");
		
		bgRadio.add(rbBrown);
		bgRadio.add(rbGreen);
		bgRadio.add(rbBlue);
		bgRadio.add(rbOther);
		
		
		// Button fuction links
		bSubmit.addActionListener(e -> submitButtonClicked());
		bExit.addActionListener(e -> exitButtonClicked());

		// Panels
		
		//pPersonal grid
		pPersonal.setLayout(gbPersonal);
		pPersonal.add(lFN);
		gbPersonal.setConstraints(lFN, getConstraints(0,0));
		pPersonal.add(tfFN);
		gbPersonal.setConstraints(tfFN, getConstraints(1,0));
		pPersonal.add(lLN);
		gbPersonal.setConstraints(lLN, getConstraints(0,1));
		pPersonal.add(tfLN);
		gbPersonal.setConstraints(tfLN, getConstraints(1,1));
		pPersonal.add(lCountry);
		gbPersonal.setConstraints(lCountry, getConstraints(0,2));
		pPersonal.add(comCountries);
		gbPersonal.setConstraints(comCountries, getConstraints(1,2));

		
//		pEyes.add(lEyes);
		pEyes.add(rbBrown);
		pEyes.add(rbGreen);
		pEyes.add(rbBlue);
		pEyes.add(rbOther);
		
//		pProg.add(lProg);
		pProg.add(cbHTML);
		pProg.add(cbSQL);
		pProg.add(cbJava);
		pProg.add(cbAndroid);
		pProg.add(cbPython);
		
		pBtn.add(bSubmit);
		pBtn.add(bExit);
		
		// pPanel grid
		pPane.setLayout(gbPane);
		pPane.add(pPersonal);
		gbPane.setConstraints(pPersonal, getConstraints(0,0));
		pPane.add(lEyes);
		gbPane.setConstraints(lEyes, getConstraints(0,1));
		pPane.add(pEyes);
		gbPane.setConstraints(pEyes, getConstraints(0,2));
		pPane.add(lProg);
		gbPane.setConstraints(lProg, getConstraints(0,3));
		pPane.add(pProg);
		gbPane.setConstraints(pProg, getConstraints(0,4));
		pPane.add(pBtn);
		gbPane.setConstraints(pBtn, getConstraints(0,5));

		
		
		// display
		add(pPane);
		setVisible(true);
	}
	
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new Survey();
        });    
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
		
	private void submitButtonClicked()
	{
		System.out.println(bgRadio.isSelected(bgRadio.getSelection()));
		Verify ver = new Verify();
		ver.verifyText(tfFN.getText(), "First Name");
		ver.verifyText(tfLN.getText(), "Last Name");
		ver.verifyCom((String) comCountries.getSelectedItem(), countries[0], "Country");
		ver.verifyBtn(bgRadio, "Eye Color");
		
		if (ver.hasFailed()) {
			createErrorMessage(ver);
		} else {
			createThankYouMessage();
			logResponse();
		}
	}
	
	private void createErrorMessage(Verify ver) {
		Component frame = null;
		JOptionPane.showMessageDialog(frame,
    ver.getErrorMessage(), "Bad Input", JOptionPane.ERROR_MESSAGE);
		
	}
	
	private void createThankYouMessage() {
		Component frame = null;
		String output = "Thank you for taking the survey!\n\n"
				+ "Here is the data you entered:";
			output += "\nName: " + tfFN.getText() + " " +tfLN.getText();
			output += "\nCountry: " + (String) comCountries.getSelectedItem();
			output += "\nEye Color: ";
			if (rbBrown.isSelected())
				output += rbBrown.getText();
			else if (rbGreen.isSelected())
				output += rbGreen.getText();
			else if (rbBlue.isSelected())
				output += rbBlue.getText();
			else if (rbOther.isSelected())
				output += rbOther.getText();
			else
				output += "Something went wrong.";
			output += "\nSkills: ";
			if (cbHTML.isSelected())
				output += " " + cbHTML.getText();
			if (cbSQL.isSelected())
				output += " " + cbSQL.getText();
			if (cbJava.isSelected())
				output += " " + cbJava.getText();
			if (cbAndroid.isSelected())
				output += " " + cbAndroid.getText();
			if (cbPython.isSelected())
				output += " " + cbPython.getText();

		JOptionPane.showMessageDialog(frame,
    output);
	}
	
	private void logResponse() {
		File file = new File("results.txt");
		if (!file.exists()) {
			try (BufferedWriter writer =
			new BufferedWriter(new FileWriter("results.txt", true))) {
			writer.append("Name\tCountry\tEye Color\tSkills\n");
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
		
		String output = "";
		output += tfFN.getText() + " " +tfLN.getText();
		output += "\t" + (String) comCountries.getSelectedItem();
		output += "\t";
		if (rbBrown.isSelected())
			output += rbBrown.getText();
		else if (rbGreen.isSelected())
			output += rbGreen.getText();
		else if (rbBlue.isSelected())
			output += rbBlue.getText();
		else if (rbOther.isSelected())
			output += rbOther.getText();
		else
			output += "Something went wrong.";
		output += "\t";
		if (cbHTML.isSelected())
			output += " " + cbHTML.getText();
		if (cbSQL.isSelected())
			output += " " + cbSQL.getText();
		if (cbJava.isSelected())
			output += " " + cbJava.getText();
		if (cbAndroid.isSelected())
			output += " " + cbAndroid.getText();
		if (cbPython.isSelected())
			output += " " + cbPython.getText();
		output += "\n";
		
		try (BufferedWriter writer =
			new BufferedWriter(new FileWriter("results.txt", true))) {
		writer.append(output);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
	
	private void exitButtonClicked()
	{
		System.exit(0);
	}
}
