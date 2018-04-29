package murach.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import murach.business.Rectangle;

public class AreaAndPerimeterFrame extends javax.swing.JFrame {

	javax.swing.JLabel lArea = new JLabel();
    javax.swing.JLabel lPeri = new JLabel();
	javax.swing.JLabel lX = new JLabel();
	javax.swing.JLabel lY = new JLabel();
	javax.swing.JTextField tfArea = new JTextField();
	javax.swing.JTextField tfPeri = new JTextField();
	javax.swing.JTextField tfX = new JTextField();
	javax.swing.JTextField tfY = new JTextField();
	javax.swing.JButton btnCompute = new JButton();
	javax.swing.JButton btnReset = new JButton();
	GridBagLayout bag = new GridBagLayout();
	FlowLayout buttonLayout = new FlowLayout();
	javax.swing.JPanel panel = new JPanel();
	javax.swing.JPanel grid = new JPanel(bag);
	javax.swing.JPanel flow = new JPanel(buttonLayout);

	
	public AreaAndPerimeterFrame() {
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
        setTitle("Area and Perimeter Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
		Dimension programSize = new Dimension(500, 175);
		setPreferredSize(programSize);
		setMinimumSize(programSize);

		// components go here
				
		Dimension text = new Dimension(400, 20);
		Dimension label = new Dimension(200, 20);
		Dimension button = new Dimension(100, 20);
		
		
		lArea.setSize(label);
		lArea.setText("Area:");
		
		lPeri.setSize(label);
		lPeri.setText("Perimeter:");
		
		lX.setSize(label);
		lX.setText("Length:");
		
		lY.setSize(label);
		lY.setText("Width:");

		tfArea.setEditable(false);
		tfArea.setPreferredSize(text);
	    tfArea.setMinimumSize(button);
		
		tfPeri.setEditable(false);
		tfPeri.setPreferredSize(text);
		tfPeri.setMinimumSize(button);
		
		tfX.setPreferredSize(text);
		tfX.setMinimumSize(button);
		
		tfY.setPreferredSize(text);
		GridBagConstraints gb = new GridBagConstraints();
		gb.
		tfY.setMinimumSize(button);
		
		btnCompute.setText("Compute");
		btnCompute.setPreferredSize(button);
		btnCompute.setMinimumSize(button);
		btnCompute.addActionListener(e -> computeButtonClicked());
		
		btnReset.setText("Reset");
		btnReset.setPreferredSize(button);
		btnReset.setMinimumSize(button);
		btnReset.addActionListener(e -> resetButtonClicked());
		
		buttonLayout.setAlignment(FlowLayout.RIGHT);
				
		grid.add(lX);
		bag.setConstraints(lX, getConstraints(0, 1));
				
		grid.add(lY);
		bag.setConstraints(lY, getConstraints(0, 2));
		
		grid.add(lArea);
		bag.setConstraints(lArea, getConstraints(0, 3));
		
		grid.add(lPeri);
		bag.setConstraints(lPeri, getConstraints(0, 4));
		
		grid.add(tfX);
		bag.setConstraints(tfX, getConstraints(1, 1));
		
		grid.add(tfY);
		bag.setConstraints(tfY, getConstraints(1, 2));

		grid.add(tfArea);
		bag.setConstraints(tfArea, getConstraints(1, 3));
		
		grid.add(tfPeri);
		bag.setConstraints(tfPeri, getConstraints(1, 4));

		flow.add(btnCompute);
		flow.add(btnReset);
		
		panel.add(grid);
		panel.add(flow);
		System.out.println(panel.getLayout());
		add(panel);
		
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

    private void computeButtonClicked() {
        Rectangle rect = new Rectangle();
		rect.setLength(Integer.parseInt(tfX.getText()));
		rect.setWidth(Integer.parseInt(tfY.getText()));
		tfArea.setText(String.valueOf(rect.getArea()));
		tfPeri.setText(String.valueOf(rect.getPerimeter()));
    }

    private void resetButtonClicked() {
		tfArea.setText("");
		tfPeri.setText("");
		tfX.setText("");
		tfY.setText("");
	}
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new AreaAndPerimeterFrame();
        });        
    }
}