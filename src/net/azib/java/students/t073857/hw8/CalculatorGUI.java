package net.azib.java.students.t073857.hw8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Calculator
 *
 * @author Joonas Vali
 */
public class CalculatorGUI {
	public static JTextField screen;
	public static Calculator calc = new Calculator();;
	
	
	
	
	private static void createAndShowGUI() {
		
		
        final JFrame frame = new JFrame("Photos, The Up-To-Date Calculator");        
        final Banner banner = new Banner(frame.getWidth());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(new Point(200, 200));        
        frame.setMinimumSize(new Dimension(350, 200));
        
        frame.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsListener(){
			@Override
			public void ancestorMoved(HierarchyEvent e) {	}

			@Override
			public void ancestorResized(HierarchyEvent e) {				
				banner.setSize(new Dimension(frame.getWidth(), banner.getHeight()));
				banner.initOffscreen();
			}        	
        });
        
        BorderLayout frameGrid = new BorderLayout();             
        frame.setLayout(frameGrid);              
        
        JPanel controlPanel = new JPanel(new GridLayout(0,4));
        JPanel screenPanel = new JPanel(new BorderLayout());        
        screenPanel.setBackground(new Color(220,220,230));
        
        screen = new JTextField("0");
        screen.setEditable(false);
        screen.setBackground(Color.WHITE);
        screen.setHorizontalAlignment(JTextField.RIGHT);    
        
        
        JButton C = new JButton("C");
        JButton res1 = new JButton("");        
        JButton res2 = new JButton("");
        JButton res3 = new JButton("");
        JButton but1 = new JButton("1");
        JButton but2 = new JButton("2");        
        JButton but3 = new JButton("3");
        JButton butDivide = new JButton("%");
        JButton but4 = new JButton("4");
        JButton but5 = new JButton("5");        
        JButton but6 = new JButton("6");
        JButton butMulti = new JButton("*");
        JButton but7 = new JButton("7");
        JButton but8 = new JButton("8");        
        JButton but9 = new JButton("9");
        JButton butAdd = new JButton("+");
        JButton butComma = new JButton(",");
        JButton but0 = new JButton("0");
        JButton butMinus = new JButton("-");
        JButton butEquals = new JButton("=");
             
        addListener(C);
        addListener(res1);
        addListener(res2);
        addListener(res3);
        addListener(butComma);
        addListener(but0);
        addListener(but1);
        addListener(but2);
        addListener(but3);
        addListener(but4);
        addListener(but5);
        addListener(but6);
        addListener(but7);
        addListener(but8);
        addListener(but9);
        addListener(butDivide);
        addListener(butMinus);
        addListener(butEquals);
        addListener(butAdd);
        addListener(butMulti);
        
        controlPanel.add(C);
        controlPanel.add(res1);
        controlPanel.add(res2);
        controlPanel.add(res3);
        controlPanel.add(but1);
        controlPanel.add(but2);
        controlPanel.add(but3);
        controlPanel.add(butDivide);
        controlPanel.add(but4);
        controlPanel.add(but5);
        controlPanel.add(but6);
        controlPanel.add(butMulti);
        controlPanel.add(but7);
        controlPanel.add(but8);
        controlPanel.add(but9);
        controlPanel.add(butAdd);
        controlPanel.add(butComma);
        controlPanel.add(but0);
        controlPanel.add(butMinus);
        controlPanel.add(butEquals);    
        
        res1.setEnabled(false);
        res2.setEnabled(false);
        res3.setEnabled(false);
        
        banner.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        banner.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = {"Read in browser",
	            "Cancel"};
				URI activeLink = banner.active.getUri();
				int n = JOptionPane.showOptionDialog(frame, banner.active.slicedDescription(15)+
						"\n\nWould you like to read about it from your browser?",
						"Open browser?",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[1]
				);
				if(n == 0)
					try {
						Desktop.getDesktop().browse(activeLink);
					}
					catch (IOException e1) {
						JOptionPane.showMessageDialog(frame,
							    "Unable to open browser.",
							    "Error",
							    JOptionPane.ERROR_MESSAGE
						);
					}

			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}        	
        });
        
        screenPanel.add(banner, BorderLayout.CENTER);
        screenPanel.add(screen, BorderLayout.SOUTH);
        frame.add(screenPanel,BorderLayout.PAGE_START);
        frame.add(controlPanel,BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);
        
     }
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	       public void run() {
	          createAndShowGUI();
	       }
	    });

    } 
	
	private static void addListener(final JButton b){
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				char input = b.getText().charAt(0);
				calc.type(input);
				screen.setText(calc.toString());
				
			}        	
        });
	}	
	
	
}
