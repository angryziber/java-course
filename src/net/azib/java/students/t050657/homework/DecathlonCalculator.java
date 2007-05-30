package net.azib.java.students.t050657.homework;

import net.azib.java.students.t050657.homework.ui.DecathlonGUI;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * DecathlonCalculator
 *
 * @author Boriss
 */
public class DecathlonCalculator {

	public static void main(String[] args){
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
           public void run() {
        	  DecathlonGUI gui = new DecathlonGUI(); 
              gui.createAndShowGUI(gui);
           }
        });
	}
}
