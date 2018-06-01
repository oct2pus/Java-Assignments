/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HypotenuseCalculator_swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Austin LaBerta
 */

public final class HypotenuseCalculator extends javax.swing.JFrame {

	JPanel pPane = new JPanel();
	
	JLabel lA = new JLabel(),
		   lB = new JLabel(),
		   lC = new JLabel();
	
	JTextField tfA = new JTextField(),
			   tfB = new JTextField(),
			   tfC = new JTextField();
	
	JButton btnCalc = new JButton(),
			btnExit = new JButton();
	
	public HypotenuseCalculator() {
		       try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
	}
	
	public void initComponents() {
		// Window settings
        setTitle("Right Triangles");
		Dimension dProg = new Dimension(320, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
		setPreferredSize(dProg);
		setMinimumSize(dProg);
		
		
		// Set Swing Component Sizes
		Dimension dText = new Dimension(160, 20);
		Dimension dLabel = new Dimension(80, 20);
		Dimension dButton = new Dimension(120, 20);
		
		lA.setPreferredSize(dLabel);
		lA.setMinimumSize(dLabel);
		lB.setPreferredSize(dLabel);
		lB.setMinimumSize(dLabel);
		lC.setPreferredSize(dLabel);
		lC.setMinimumSize(dLabel);
		
		tfA.setPreferredSize(dText);
		tfA.setMinimumSize(dText);
		tfB.setPreferredSize(dText);
		tfB.setMinimumSize(dText);
		tfC.setPreferredSize(dText);
		tfC.setMinimumSize(dText);
		
		btnCalc.setPreferredSize(dButton);
		btnCalc.setMinimumSize(dButton);
		btnExit.setPreferredSize(dButton);
		btnExit.setMinimumSize(dButton);
		
		// Set Swing Component properties
		
		lA.setText("Side A:");
		lB.setText("Side B:");
		lC.setText("Side C:");
		
		tfC.setEditable(false);
		
		btnCalc.setText("Calculate");
		btnCalc.addActionListener(e -> btnCalcActionPerformed());
		
		btnExit.setText("Exit");
		btnExit.addActionListener(e -> btnExitActionPerformed());
		
		// Add to Panels
		pPane.add(lA);
		pPane.add(tfA);
		pPane.add(lB);
		pPane.add(tfB);
		pPane.add(lC);
		pPane.add(tfC);
		pPane.add(btnCalc);
		pPane.add(btnExit);
		// Draw Application
		add(pPane);
		setVisible(true);
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
	
	private void btnExitActionPerformed() {                                        
		System.exit(0);
    }                                       

    private void btnCalcActionPerformed() {                                        
		String a = tfA.getText(),
			   b = tfB.getText(),
			   errorString = valid(a, "a") + "\n" + valid(b, "b");
		Double c;		 
		
			   if (errorString.trim().isEmpty())
				{
					c = Math.pow(Double.valueOf(a), 2) + Math.pow(Double.valueOf(b), 2);
					c = Math.pow(c, 0.5);
					
					DecimalFormat numberFormat = new DecimalFormat("#.000");
					
					tfC.setText(numberFormat.format(c));
				}
			   else
			   {
					Component frame = null;
					JOptionPane.showMessageDialog(null,
					errorString,
					"Invalid Data",
					JOptionPane.ERROR_MESSAGE);
					
					// not stated in requirements but assumed
					tfA.setText("");
					tfB.setText("");
					tfC.setText("");

			   }
				   
    }                                       

	public String valid(String input, String name)
	{
		if (input.matches("[0-9]*|[0-9]*\\.(?=[0-9])[0-9]*"))
			return "";
		else
			return "Side " + name + " must be a valid number.";
	}
	
	public static void main(String[] args) {
	        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new HypotenuseCalculator();
        });    	
	}
	
}
