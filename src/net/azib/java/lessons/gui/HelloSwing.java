package net.azib.java.lessons.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
  
public class HelloSwing {

     private static void createAndShowGUI() {
        JFrame frame = new JFrame("HelloSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello, Swing!");
        frame.add(label, BorderLayout.SOUTH);
        JLabel label2 = new JLabel("Hello, Swing!");
        frame.add(label2, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
        
        System.out.println(frame.getLayout());
     }
     
     public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	       public void run() {
	          createAndShowGUI();
	       }
	    });

     } 
}
