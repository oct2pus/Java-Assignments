/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey;

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
	// labels
	JLabel lFN = new JLabel();
	JLabel lLN = new JLabel();
	JLabel lCountry = new JLabel();
	JLabel lEyes = new JLabel();
	JLabel lProg = new JLabel();
	// text fields
	JTextField tfFN = new JTextField();
	JTextField tfLN = new JTextField();
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
	ButtonGroup bgCheck = new ButtonGroup();
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
		lFN.setText("First Name:");
		lLN.setText("Last Name:");
		lCountry.setText("Country:");
		lEyes.setText("Eye Color:");
		lProg.setText("Programming Skills:");
		
		rbBrown.setText("Brown");
		rbGreen.setText("Green");
		rbBlue.setText("Blue");
		rbOther.setText("Other");
		
		
		setVisible(true);
	}
	
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new Survey();
        });    
	
}
